package pl.ris.rom.roomoccupancy.offers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OffersServiceTest {
    @Autowired
    OffersService service;

    @Test
    void getOffersShouldNotReturnNull() {
        assertThat(service.getOffers()).isNotNull();
    }

    @Test
    void getOffersShouldLoadInitialData() {
        assertThat(service.getOffers().size()).isEqualTo(10);
    }
}
