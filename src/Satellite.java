public abstract class Satellite {
    /// Имя КА
    protected String name;

    ///  Энергетическая система
    protected  EnergySystem energySystem;

    ///  Состояние КА
    protected  SatelliteState satelliteState;

    public Satellite(String name, double batteryLevel){
        this.name = name;
        this.energySystem = new EnergySystem(batteryLevel);
        this.satelliteState = new SatelliteState();

        System.out.println("Создан спутник: " + name + " (заряд: " + energySystem.getBatteryLevel() + "%" + ")");
    }

    public boolean activate(){
        if (satelliteState.activate(energySystem.hasSufficientPower())) {
            System.out.println(name + " : Активация успешна");

            return true;
        }
        System.out.println(name + " : Ошибка активации. " +
                satelliteState.getStatusMessage() +
                ". Заряд батареи: " +
                energySystem.getBatteryLevel() + "%.");

        return false;
    }

    public void deactivate(){
        if (satelliteState.isActive()) {
            satelliteState.deactivate();
        }
    }

    protected abstract void performMission();
}
