package app;

public class CommunicationSatellite extends Satellite{
    private final double bandwidth;

    public final static double sendDataOperationCost = 0.05;

    public CommunicationSatellite(String name, double batteryLevel, double bandwidth){
        super(name, batteryLevel);
        this.bandwidth = bandwidth;
    }

    public double getBandwidth(){
        return bandwidth;
    }

    private void sendData(double dataAmount){
        System.out.println(name + ": Отправил " + dataAmount + " Мбит данных");
    }

    @Override
    public void performMission(){
        if (!state.isActive()) {
            System.out.println(name + ": Не может выполнить отправку - не активен");
            return;
        }
        if (energySystem.getBatteryLevel() < sendDataOperationCost) {
            System.out.println(name + ": Не может выполнить отправку - низкий заряд батареи");
            return;
        }
        System.out.println(name + ": Передача данных со скоростью " + bandwidth + " Мбит/c");
        sendData(bandwidth);
        energySystem.consume(sendDataOperationCost);
    }

    @Override
    public String toString() {
        return "CommunicationSatellite{" +
                "name=" + name +
                ", bandwidth=" + bandwidth +
                ", energySystem=" + energySystem +
                ", satelliteState=" + state +
                "}";
    }

}
