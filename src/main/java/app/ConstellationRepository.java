package app;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConstellationRepository {

    private final Map<String, SatelliteConstellation> constellations = new HashMap<>();


    public void addConstellation(SatelliteConstellation constellation) {
        constellations.put(constellation.getName(), constellation);
        System.out.println("Сохранена группировка: " + constellation.getName());
    }

    public SatelliteConstellation getConstellation(String name) {
        SatelliteConstellation constellation = constellations.get(name);
        if (constellation == null) {
            throw new RuntimeException("Группировка не найдена: " + name);
            }
        return constellation;
    }

    public Map<String, SatelliteConstellation> getAllConstellations() {
        return new HashMap<>(constellations);
    }

    public boolean containsConstellation(String name) {
        return constellations.containsKey(name);
    }

    public void removeConstellation(String name) {
        SatelliteConstellation removeConstellation = constellations.remove(name);

        if (removeConstellation == null) {
            System.out.println("Группировка не найдена: " + name);
            return;
        }

        System.out.println("Удалена группировка: " + name);

    }

}
