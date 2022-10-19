package pl.ris.rom.roomoccupancy.occupancy;

import org.springframework.stereotype.Service;

/** service with occupancy calculation logic */
@Service
public class OccupancyService {

    public OccupiedRooms calculateOccupancy(int premiumRooms, int economyRooms) {
        OccupiedRooms occupiedRooms = OccupiedRooms.builder()
                .economyRooms(economyRooms)
                .premiumRooms(premiumRooms)
                .build();
        return occupiedRooms;        
    }
}
