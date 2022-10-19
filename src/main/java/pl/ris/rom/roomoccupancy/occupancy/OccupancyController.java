package pl.ris.rom.roomoccupancy.occupancy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OccupancyController {
    @Autowired
    OccupancyService occupancyService;

    /**
     * calculate room occupancy for given set of premium and economy rooms
     * 
     * @return data about occupied rooms
     */
    @GetMapping("/roomOccupancy")
    public OccupiedRooms getRoomOccupancy(@RequestParam("premiumRooms") int premiumRooms,
            @RequestParam("economyRooms") int economyRooms) {

        return occupancyService.calculateOccupancy(premiumRooms, economyRooms);
    }

}
