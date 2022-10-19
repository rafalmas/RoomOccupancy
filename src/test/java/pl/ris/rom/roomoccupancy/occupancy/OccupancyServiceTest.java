package pl.ris.rom.roomoccupancy.occupancy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OccupancyServiceTest {

    @Autowired
    OccupancyService service;

    @Test
    void calculateOccupancyShouldReturnNonNull() {
        // when
        OccupiedRooms result = service.calculateOccupancy(0, 0);

        // then
        assertThat(result).isNotNull();
    }
}
