package app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
@DisplayName("Интеграционный тест выполнения репозитория")
class ConstellationRepositoryIntegrationTest {
    private static final String CONSTELLATION_1 = "testConstellation";
    private static final String CONSTELLATION_2 = "testConstellation2";

    @Autowired
    private ConstellationRepository repository;

    @Test
    @DisplayName("Добавление нескольких группировок должно сохранять их все")
    void testRepository() {
        SatelliteConstellation constellation1 = new SatelliteConstellation(CONSTELLATION_1);
        SatelliteConstellation constellation2 = new SatelliteConstellation(CONSTELLATION_2);

        repository.addConstellation(constellation1);
        repository.addConstellation(constellation2);

        repository.getConstellation(CONSTELLATION_1);
        repository.getConstellation(CONSTELLATION_2);

        assertTrue(repository.containsConstellation(CONSTELLATION_1));
        assertTrue(repository.containsConstellation(CONSTELLATION_2));

        assertEquals(2, repository.getAllConstellations().size());
    }

}
