package pl.ris.rom.roomoccupancy.occupancy;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OccupiedRooms {
    private int premiumRooms;
    private int economyRooms;
    private BigDecimal premiumRevenue = BigDecimal.ZERO;
    private BigDecimal economyRevenue = BigDecimal.ZERO;

    public void bookPremiumRoom(BigDecimal amount) {
        premiumRooms++;
        premiumRevenue = premiumRevenue.add(amount);
    }

    public void bookEconomyRoom(BigDecimal amount) {
        economyRooms++;
        economyRevenue = economyRevenue.add(amount);
    }
}
