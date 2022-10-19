# RoomOccupancy

Test project exposing api to calculate room occupancy

### Build with gradle
To build and run tests type:

    ./gradlew build

### Run
To run locally type:

    ./gradlew bootRun


## Exposed endpoints

### Calculate room occupancy
To get results of room occupancy calculations call:

    GET http://localhost:8080/roomOccupancy?premiumRooms=<no_of_available_premium_rooms>&economyRooms=<no_of_available_economy_rooms>

replace _<no_of_available_premium_rooms>_ and _<no_of_available_economy_rooms>_ with actual values
