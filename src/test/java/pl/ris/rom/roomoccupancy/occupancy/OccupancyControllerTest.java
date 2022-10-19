package pl.ris.rom.roomoccupancy.occupancy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OccupancyControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getRoomOccupancyShouldReturnOK() {
        // given
        String uriString = UriComponentsBuilder.fromUriString("http://localhost").port(port)
            .path("roomOccupancy")
            .queryParam("premiumRooms", 0)
            .queryParam("economyRooms", 0)
            .toUriString(); 

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetRoomOccupancyShouldReturn400BadRequestIfRoomsAreNotSpecified() {
        // given
        String uriString = UriComponentsBuilder.fromUriString("http://localhost").port(port)
            .path("roomOccupancy")
            .toUriString(); 

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testGetRoomOccupancyShouldReturn400BadRequestIfEconomyRoomsAreNotSpecified() {
        // given
        String uriString = UriComponentsBuilder.fromUriString("http://localhost").port(port)
            .path("roomOccupancy")
            .queryParam("premiumRooms", 0)
            .toUriString(); 

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testGetRoomOccupancyShouldReturn400BadRequestIfPremiumRoomsAreNotSpecified() {
        // given
        String uriString = UriComponentsBuilder.fromUriString("http://localhost").port(port)
            .path("roomOccupancy")
            .queryParam("economyRooms", 0)
            .toUriString(); 

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(uriString, String.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
