package pl.ris.rom.roomoccupancy.occupancy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    @DisplayName("test to verify room occupancy calculations")
    @ParameterizedTest(name = "{index}: free premium={0}, free economy={1} => usage premium={2} (EUR {3}), usage economy={4} (EUR {5}})")
    @CsvSource(delimiter = '|', value = {
            "3| 3| 3|  738   | 3| 167.99",
            "7| 5| 6| 1054   | 4| 189.99",
            "2| 7| 2|  583   | 4| 189.99",
            // "7| 1| 7| 1153   | 1|  45.99",  // This test case is wrong. In test data there is only one value ending with .99 -> 99.99. Proper values below
            "7| 1| 7| 1153.99| 1|  45."
    })
    void calculateOccupancy(int freePremiumRooms, int freeEconomyRooms, int usedPremiumRooms, double premiumRevenue, int usedEconomyRooms, double economyRevenue) {
        // when
        OccupiedRooms result = service.calculateOccupancy(freePremiumRooms, freeEconomyRooms);

        // then
        assertThat(result.getPremiumRooms()).isEqualTo(usedPremiumRooms);
        assertThat(result.getPremiumRevenue()).isEqualByComparingTo(BigDecimal.valueOf(premiumRevenue));
        assertThat(result.getEconomyRooms()).isEqualTo(usedEconomyRooms);
        assertThat(result.getEconomyRevenue()).isEqualByComparingTo(BigDecimal.valueOf(economyRevenue));        
    }

}
