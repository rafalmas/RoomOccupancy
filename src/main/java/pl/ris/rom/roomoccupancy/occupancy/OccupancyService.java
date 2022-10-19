package pl.ris.rom.roomoccupancy.occupancy;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.ris.rom.roomoccupancy.offers.OffersService;

/** service with occupancy calculation logic */
@Service
public class OccupancyService {
    private static final BigDecimal PREMIUM_THRESHOLD = BigDecimal.valueOf(100.);

    @Autowired
    OffersService offersService;

    public OccupiedRooms calculateOccupancy(int premiumRooms, int economyRooms) {
        OccupiedRooms result = new OccupiedRooms();
        List<BigDecimal> offers = offersService.getOffers();

        handlePremiumOffers(premiumRooms, result, offers);        
        handleEconomyOffers(economyRooms, premiumRooms, result, offers);
        return result;        
    }

    private void handlePremiumOffers(int premiumRooms, OccupiedRooms result, List<BigDecimal> offers) {
        offers.stream()
                .filter(amount -> amount.compareTo(PREMIUM_THRESHOLD) >= 0)
                .sorted(Comparator.reverseOrder())
                .limit(premiumRooms)
                .forEach(result::bookPremiumRoom);
    }

    private void handleEconomyOffers(int economyRooms, int premiumRooms, OccupiedRooms result, List<BigDecimal> offers) {
        offers.stream()
                .filter(amount -> amount.compareTo(PREMIUM_THRESHOLD) < 0)
                .sorted(Comparator.reverseOrder())
                .limit(economyRooms + premiumRooms - result.getPremiumRooms())
                .sorted()
                .forEach(offer -> {
                    if (result.getEconomyRooms() < economyRooms) {
                        result.bookEconomyRoom(offer);
                    } else {
                        result.bookPremiumRoom(offer);
                    }
                });
    }    
}
