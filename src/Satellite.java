public abstract class Satellite {
    /// Имя КА
    protected String name;

    /// Флаг активности
    protected boolean isActive;

    /// Уровень заряда батареи
    protected double batteryLevel;

    /// Минимальный уровень батареи для проведения операций
    public static double minBatteryLevel = 0.2;

    public Satellite(String name, double batteryLevel){
        this.name = name;
        this.batteryLevel = batteryLevel;
        System.out.println("Создан спутник: " + name + " (заряд: " + (int)(batteryLevel * 100) + "%" + ")");
    }

    public boolean activate(){
        if (isActive){
            System.out.println(name + ": Уже активирован");
            return true;
        }
        if (batteryLevel <= minBatteryLevel){
            System.out.println(name + ": Невозможно активировать. Низкий заряд батареи. Заряд: "
                    + (int)(batteryLevel * 100) + "%");
            return false;
        }
        isActive = true;
        System.out.println(name + ": Активация успешна");
        return true;
    }

    public void deactivate(){
        if (isActive) {
            isActive = false;
        }
    }

    public void consumeBattery(double amount){
        if (amount >= 0) {
            batteryLevel -= amount;
            if (batteryLevel <= minBatteryLevel && isActive) {
                System.out.println(name + ": Низкий заряд батареи. Деактивация...");
                deactivate();
            }
        }
    }

    protected abstract void performMission();
}
