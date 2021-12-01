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

### GET /fff/events
This retrieves all free food events from the database, for cases where no filtering criteria has been specified.

`@param` **search** (optional): search terms entered by the user to be searched using the food description field

`@param` **location** (optional): integer location ID of desired location

`@param` **filters** (optional): list of filter strings of form: `GLUTEN_FREE,LACTOSE_FREE,VEGAN,KOSHER,VEGETARIAN,NO_EGGS,NO_PEANUTS,NO_SOY`, where only desired filters are listed.

`@return` List of Event Objects

Example Query: Get all events
```bash
curl 'localhost:8080/fff/events'
```

Example output (assuming only 1 event in the database):
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
      "address":"1111 Engineering Drive",
      "isOutdoor":false
    }
  }]
}
```

Example Query: Get filtered events
```bash
curl 'localhost:8080/fff/events?search=pizza&location=85&filters=NO_EGGS'
```

Example output:
```json
{
   "events": [
      {
         "eventID":53,
         "foodName":"Veggie Pizza",
         "availableUntil":"2021-11-30T22:15:00.000+00:00",
         "foodDescription":"5 slices of olive and mushroom veggie pizza. ",
         "roomNumber":"Lobby",
         "restrictionID":
         {
            "restrictionID":54,
            "glutenFree":false,
            "vegan":false,
            "vegetarian":true,
            "noPeanut":true,
            "lactoseFree":false,
            "kosher":false,
            "noEgg":true,
            "noSoy":true
         },
         "locationID":
         {
            "locationID":85,
            "locationName":"Andrews Hall",
            "latitude":40.00308,
            "longitude":-105.26209,
            "address":"2510 Kittredge Loop Rd",
            "isOutdoor":false
         }
      }
   ]
}
```

### GET /fff/locations
This retrieves all locations from the database.

`@param` None

`@return` List of Location Objects

Example Query
```bash
curl 'localhost:8080/fff/locations'
```

Example output (assuming only 3 locations in the database):
```json
{
   "locations": [
      {
         "locationID":1,
         "locationName":"Engineering Center",
         "latitude":20.5,
         "longitude":30.2,
         "address":"1111 Engineering Drive",
         "isOutdoor":false
      },
      {
         "locationID":2,
         "locationName":"Math Building",
         "latitude":19.3,
         "longitude":30.2,
         "address":"2300 Colorado Avenue",
         "isOutdoor":false
      },
      {
         "locationID":3,
         "locationName":"Outside of Math Building",
         "latitude":20.0,
         "longitude":30.0,
         "address":null,
         "isOutdoor":true
      }
   ]
}
```

### POST /fff/events
Adds an event to the database.

Example Request Body
```json
{
  "name": "Apples and Peanut Butter",
  "desc": "this is leftover food from the OOAD yearly Gala",
  "availableUntil": "2021-11-17T23:28:00.000Z",
  "locationID": 3,
  "room": "E1004",
  "glutenFree": true,
  "kosher": true,
  "lactoseFree": false,
  "noEggs": false,
  "noPeanuts": false,
  "noSoy": true,
  "vegan": false,
  "vegetarian": true
} 
```

Example Query
```bash
curl -X POST -H "Content-Type: application/json" \
    -d '{ "name": "Apples and Peanut Butter", "desc": "this is leftover food from the OOAD yearly Gala", "availableUntil": "2021-11-30T23:28:00.000Z", "locationID": 3, "room": "E1004", "glutenFree": true, "kosher": true, "lactoseFree": false, "noEggs": false, "noPeanuts": false, "noSoy": true, "vegan": false, "vegetarian": true}' \
    http://localhost:8080/fff/events
```

Example Response
```json
{
  "event": 
  {
     "eventID":59,
     "foodName":"Apples and Peanut Butter",
     "availableUntil":"2021-11-30T23:28:00.000+00:00",
     "foodDescription":"this is leftover food from the OOAD yearly Gala",
     "roomNumber":"E1004",
     "restrictionID":
     {
        "restrictionID":60,
        "glutenFree":true,
        "vegan":false,
        "vegetarian":true,
        "noPeanut":false,
        "lactoseFree":false,
        "kosher":true,
        "noEgg":false,
        "noSoy":true
     },
     "locationID": 
     {
        "locationID":3,
        "locationName":"Outside of Math Building",
        "latitude":20.0,
        "longitude":30.0,
        "address":null,
        "isOutdoor":true
     }
  }
}
```
