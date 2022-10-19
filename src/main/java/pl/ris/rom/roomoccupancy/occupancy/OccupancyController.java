package pl.ris.rom.roomoccupancy.occupancy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OccupancyController {

    /**
     * calculate room occupancy for given set of premium and economy rooms
     * 
     * @return ok for now
     */
    @GetMapping("/roomOccupancy")
    public ResponseEntity<?> getRoomOccupancy(@RequestParam("premiumRooms") int premiumRooms,
                                                @RequestParam("economyRooms") int economyRooms) {
        return ResponseEntity.ok().build();
    }

}
