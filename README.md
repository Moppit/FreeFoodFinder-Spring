# FreeFoodFinder-Spring

## Run the Project
You must run the project as a Maven project. In the `freefoodfinder` directory, run the command:
```bash
./mvnw spring-boot:run
```

## Database
All SQL files are located in the `db` directory.
- Database schema specifications are outlined in `Food_Finder_Initializing.sql`.
- Mock data is provided in `Food_Finding_Mock_Data.sql`

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