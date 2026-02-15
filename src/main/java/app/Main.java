package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Main {
    public static void main(String[] args){
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ");
        System.out.println("=".repeat(60));

        ConfigurableApplicationContext context = SpringApplication.run(Main.class, args);

        ConstellationRepository constellationRepository = context.getBean(ConstellationRepository.class);
        SpaceOperationCenterService operationCenter = context.getBean(SpaceOperationCenterService.class);

        System.out.println("СОЗДАНИЕ СПЕЦИАЛИЗИРОВАННЫХ СПУТНИКОВ:");
        System.out.println("-".repeat(40));

        CommunicationSatellite commSat1 = new CommunicationSatellite("Cвязь-1", 0.85, 500.);
        CommunicationSatellite commSat2 = new CommunicationSatellite("Связь-2", 0.75, 1000.);
        CommunicationSatellite commSat3 = new CommunicationSatellite("Связь-3", 0.55, 750.);
        CommunicationSatellite commSat4 = new CommunicationSatellite("Связь-4", 0.19, 300.);

        ImagingSatellite imSat1 = new ImagingSatellite("ДЗЗ-1", 0.92, 2.5);
        ImagingSatellite imSat2 = new ImagingSatellite("ДЗЗ-2", 0.45, 1.0);
        ImagingSatellite imSat3 = new ImagingSatellite("ДЗЗ-3", 0.15, 0.5);


        System.out.println("-".repeat(40));

        operationCenter.createAndSaveConstellation("RU Basic");
        operationCenter.createAndSaveConstellation("RU Walker");

        System.out.println("-".repeat(40));

        System.out.println("ФОРМИРОВАНИЕ ГРУППИРОВКИ:");

        System.out.println("-".repeat(40));

        operationCenter.addSatelliteToConstellation("RU Basic", commSat1);
        operationCenter.addSatelliteToConstellation("RU Basic", commSat2);
        operationCenter.addSatelliteToConstellation("RU Basic", imSat1);
        operationCenter.addSatelliteToConstellation("RU Basic", imSat2);
        operationCenter.addSatelliteToConstellation("RU Basic", imSat3);

        System.out.println("-".repeat(40));
        operationCenter.showConstellationStatus("RU Basic");
        System.out.println("-".repeat(40));

        operationCenter.addSatelliteToConstellation("RU Walker", commSat3);
        operationCenter.addSatelliteToConstellation("RU Walker", commSat4);
        operationCenter.addSatelliteToConstellation("RU Walker", imSat2);


        System.out.println("-".repeat(40));
        operationCenter.showConstellationStatus("RU Walker");
        System.out.println("-".repeat(40));


        System.out.println("АКТИВАЦИЯ СПУТНИКОВ:");
        System.out.println("-".repeat(30));


        operationCenter.activateAllSatellits("RU Basic");
        operationCenter.activateAllSatellits("RU Walker");

        // Выполнение миссий группировками
        operationCenter.executeConstellationMission("RU Basic");
        operationCenter.executeConstellationMission("RU Walker");






    }
}