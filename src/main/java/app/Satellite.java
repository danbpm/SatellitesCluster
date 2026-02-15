package app;

public abstract class Satellite {
    /// Имя КА
    protected String name;

    ///  Энергетическая система
    protected  EnergySystem energySystem;

    ///  Состояние КА
    protected  SatelliteState state;

    public Satellite(String name, double batteryLevel){
        this.name = name;
        this.energySystem = new EnergySystem(batteryLevel);
        this.state = new SatelliteState();

        System.out.println("Создан спутник: " + name + " (заряд: " + energySystem.getBatteryLevel() + "%" + ")");
    }

    public String getName() {
        return name;
    }

    public SatelliteState getState() {
        return state;
    }

    public boolean activate(){
        if (state.activate(energySystem.hasSufficientPower())) {
            System.out.println(name + " : Активация успешна");

            return true;
        }
        System.out.println(name + " : Ошибка активации. " +
                state.getStatusMessage() +
                ". Заряд батареи: " +
                energySystem.getBatteryLevel() + "%.");

        return false;
    }

    public void deactivate(){
        if (state.isActive()) {
            state.deactivate();
        }
    }

    protected abstract void performMission();
}
