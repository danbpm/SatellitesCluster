import java.util.ArrayList;
import java.util.List;

public class SatelliteConstellation {
    private final String constellationName;
    private  final List<Satellite> satellites = new ArrayList<>();

    public SatelliteConstellation(String constellationName){
        this.constellationName = constellationName;
        System.out.println("Создана спутниковая группировка: " + constellationName);
    }

    public void addSatellite(Satellite satellite){
        System.out.println(satellite.name + " добавлен в группировку " + constellationName);
        satellites.add(satellite);
    }

    public String getName(){
        return constellationName;
    }

    public List<Satellite> getSatellites(){
        return satellites;
    }

    public void executeAllMissions(){
        System.out.println("ВЫПОЛНЕНИЕ МИССИЙ ГРУППИРОВКИ " + constellationName);
        System.out.println("=".repeat(60));
        for (Satellite sat : satellites) {
            sat.performMission();
        }
    }
}
