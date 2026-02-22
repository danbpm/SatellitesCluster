package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstellationRepositoryUnitTest {
    private static final String CONSTELLATION_1 = "testConstellation";
    private static final String CONSTELLATION_2 = "testConstellation2";

    ConstellationRepository repository;

    @BeforeEach
    void setup() {
        repository = new ConstellationRepository();
    }

    @Test
    @DisplayName("Тест репозитория группировок")
    void testRepository() {
        SatelliteConstellation constellation1 = new SatelliteConstellation(CONSTELLATION_1);
        SatelliteConstellation constellation2 = new SatelliteConstellation(CONSTELLATION_2);

        repository.addConstellation(constellation1);
        repository.addConstellation(constellation2);

        assertTrue(repository.containsConstellation(CONSTELLATION_1));
        assertTrue(repository.containsConstellation(CONSTELLATION_2));
        assertEquals(2, repository.getAllConstellations().size());
    }
}
