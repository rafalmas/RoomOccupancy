package pl.ris.rom.roomoccupancy.offers;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Service;

import lombok.Getter;

/** service providing list of offers from potential guests */
@Service
public class OffersService {
    private static final String JSON_INPUT = "[23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]";

    @Getter
    private List<BigDecimal> offers;

    @PostConstruct
    void loadOffers() {
        JsonParser springParser = JsonParserFactory.getJsonParser();

        offers = springParser.parseList(JSON_INPUT).stream()
                .filter(obj -> obj instanceof Integer || obj instanceof Double)
                .map(n -> {
                    if (n instanceof Integer) {
                        return BigDecimal.valueOf((Integer) n);
                    } else if (n instanceof Double) {
                        return BigDecimal.valueOf((Double) n);
                    } else {
                        return BigDecimal.ZERO;
                    }
                })
                .toList();
    }

}
