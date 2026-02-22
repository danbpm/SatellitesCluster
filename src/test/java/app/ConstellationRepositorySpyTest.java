package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConstellationRepositorySpyTest {
    private final static String CONSTELLATION_1 = "testConstellation";
    private final static String CONSTELLATION_2 = "testConstellation2";

    @Spy
    ConstellationRepository repository;

    @Test
    @DisplayName("Тест репозитория группировок")
    void testRepository() {
        SatelliteConstellation constellation1 = new SatelliteConstellation(CONSTELLATION_1);
        SatelliteConstellation constellation2 = new SatelliteConstellation(CONSTELLATION_2);

        doReturn(true).when(repository).containsConstellation(CONSTELLATION_1);
        doReturn(true).when(repository).containsConstellation(CONSTELLATION_2);

        Map<String, SatelliteConstellation> constellations = Map.of(
                CONSTELLATION_1, constellation1,
                CONSTELLATION_2, constellation2
        );

        doReturn(constellations).when(repository).getAllConstellations();

        assertTrue(repository.containsConstellation(CONSTELLATION_1));
        assertTrue(repository.containsConstellation(CONSTELLATION_2));
        assertEquals(2, repository.getAllConstellations().size());


    }
}
