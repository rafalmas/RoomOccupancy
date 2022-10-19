package pl.ris.rom.roomoccupancy.occupancy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OccupancyController {

    /**
     * calculate room occupancy for given set of premium and economy rooms
     * 
     * @return data about occupied rooms
     */
    @GetMapping("/roomOccupancy")
    public OccupiedRooms getRoomOccupancy(@RequestParam("premiumRooms") int premiumRooms,
            @RequestParam("economyRooms") int economyRooms) {

        OccupiedRooms occupiedRooms = OccupiedRooms.builder()
                .economyRooms(economyRooms)
                .premiumRooms(premiumRooms)
                .build();
        return occupiedRooms;
    }

}
