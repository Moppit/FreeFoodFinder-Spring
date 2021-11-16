# FreeFoodFinder-Spring

## Deliverables

### Project 6
Our written deliverables is saved in this repo as `Project 6 Update.pdf` in the root directory.

Our code is separated into 2 repositories for ease of development. This project contains the Spring half. To access the Angular side of the project, visit https://github.com/Moppit/FreeFoodFinder-Angular. 

## Run the Project
You must run the project as a Maven project. In the `freefoodfinder` directory, run the command:
```bash
./mvnw spring-boot:run
```

## Database
All SQL files are located in the `db` directory.
- Database schema specifications are outlined in `Food_Finder_Initializing.sql`.
- Mock data is provided in `Food_Finding_Mock_Data.sql`

### Connecting to a Local DB Server
Setting up the database is modeled after this tutorial: https://spring.io/guides/gs/accessing-data-mysql/.

For our specific server:

1. Install MySQL/the `mysql` CLI. 
2. Generate the database based on our DDL, `Food_Finder_Initializing.sql`.
   1. Sign in as root to MySQL with `sudo mysql --password`
   2. Create a new database named `FreeFoodFinderDB` using `create database FreeFoodFinderDB;`
   3. Create a new user for Spring to access the DB.
      1. Create with `create user 'springuser'@'%' identified by 'CSCI5448';`
      2. Decide privileges with `grant all on FreeFoodFinderDB.* to 'springuser'@'%';`
   4. Load the DDL with `source /{ABSOLUTE PATH}/Food_Finder_Initializing.sql`
3. Configure your Spring project to load this new DDL.
   1. Navigate to `freefoodfinder/src/main/resources/application.properties`.
   2. Change the first line (`spring.jpa.hibernate.ddl-auto=none`) to `spring.jpa.hibernate.ddl-auto=update`.
   3. Note for posterity: after your first run (which needs to create the hiberate table), you should change the `ddl-auto` attribute back to `none` if you don't intend for any more structural changes to the database.
4. Now you should be able to run the project (using `./mvnw spring-boot:run` as described above) and curl `localhost` to retrieve data.

### Creating the locations for the database
Locations will be generated from the `locations.yaml` file. The created `location_inserts.sql` can be used to insert the rows into the db.
1. `cd db`
2. `python3 generate_location_inserts.py`

## Endpoints

### /fff/events
This retrieves all free food events from the database, for cases where no filtering criteria has been specified.

`@param` None

`@return` List of Event Objects

Example Query
```bash
curl 'localhost:8080/fff/events'
```

Example output (assuming only 1 events in the database):
```json
{
  "events": [{
    "eventID":1,
    "foodName":"cookies",
    "availableUntil":"2021-11-18T22:30:00.000+00:00",
    "foodDescription":"Freshman Welcome!",
    "roomNumber":"ECCE 188",
    "restrictionID": {
      "restrictionID":1,
      "glutenFree":false,
      "vegan":true,
      "vegetarian":true,
      "noPeanut":false,
      "lactoseFree":true,
      "kosher":false,
      "noEgg":false,
      "noSoy":false
    },
    "locationID": {
      "locationID":1,
      "locationName":"Engineering Center",
      "latitude":20.5,
      "longitude":30.2,
      "isOutdoor":false
    }
  }]
}
```