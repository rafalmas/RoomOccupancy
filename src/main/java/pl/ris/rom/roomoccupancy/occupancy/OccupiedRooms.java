package pl.ris.rom.roomoccupancy.occupancy;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OccupiedRooms {
    private int premiumRooms;
    private int economyRooms;
    @Builder.Default
    private BigDecimal premiumRevenue = BigDecimal.ZERO;
    @Builder.Default
    private BigDecimal economyRevenue = BigDecimal.ZERO;
}
