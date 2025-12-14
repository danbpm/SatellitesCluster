public class Main {
    public static void main(String[] args){
        System.out.println("ЗАПУСК СИСТЕМЫ УПРАВЛЕНИЯ СПУТНИКОВОЙ ГРУППИРОВКОЙ");
        System.out.println("=".repeat(60));

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

        SatelliteConstellation constellation1 = new SatelliteConstellation("RU Basic");
        SatelliteConstellation constellation2 = new SatelliteConstellation("RU Walker");

        System.out.println("-".repeat(40));

        System.out.println("ФОРМИРОВАНИЕ ГРУППИРОВКИ:");

        System.out.println("-".repeat(40));

        constellation1.addSatellite(commSat1);
        constellation1.addSatellite(commSat2);
        constellation1.addSatellite(imSat1);
        constellation1.addSatellite(imSat2);
        constellation1.addSatellite(imSat3);
        System.out.println("-".repeat(40));
        System.out.println(constellation1.getSatellites());
        System.out.println("-".repeat(40));

        constellation2.addSatellite(commSat3);
        constellation2.addSatellite(commSat4);
        constellation2.addSatellite(imSat2);

        System.out.println("-".repeat(40));
        System.out.println(constellation2.getSatellites());
        System.out.println("-".repeat(40));


        System.out.println("АКТИВАЦИЯ СПУТНИКОВ:");
        System.out.println("-".repeat(30));


        System.out.println("ГРУППИРОВКА: " + constellation1.getName());
        System.out.println("-".repeat(20));
        for (Satellite sat : constellation1.getSatellites()){
            sat.activate();
        }

        System.out.println("ГРУППИРОВКА: " + constellation2.getName());
        System.out.println("-".repeat(20));
        for (Satellite sat : constellation2.getSatellites()){
            sat.activate();
        }

        // Выполнение миссий группировками
        constellation1.executeAllMissions();
        constellation2.executeAllMissions();


    }
}