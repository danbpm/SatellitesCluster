package app;
public class ImagingSatellite extends Satellite{
    double resolution;
    int photosTaken;

    public final static double takePhotoOperationCost = 0.08;

    public ImagingSatellite(String name, double batteryLevel, double resolution){
        super(name, batteryLevel);
        this.resolution = resolution;
    }

    public double getResolution(){
        return resolution;
    }

    public int getPhotosTaken(){
        return photosTaken;
    }

    private void takePhoto(){
        if (state.isActive()) {
            photosTaken += 1;
            System.out.println(name + ": Cнимок #" + photosTaken + " сделан");
        }
    }

    @Override
    public void performMission(){
        if (!state.isActive()) {
            System.out.println(name + ": Не может сделать фото - не активен");
            return;
        }
        if (energySystem.getBatteryLevel() < takePhotoOperationCost){
            System.out.println(name + ": Не может сделать фото - низкий заряд батареи. Заряд: " +
                    energySystem.getBatteryLevel() + "% " + "(затраты на фото: " +
                    (int)(takePhotoOperationCost * 100)  + "%)");
            return;
        }
        takePhoto();
        energySystem.consume(takePhotoOperationCost);
    }

    @Override
    public String toString(){
        return "ImagingSatellite{" +
                "name= " + name +
                ", resolution=" + resolution +
                ", photosTaken=" + photosTaken +
                ", energySystem=" + energySystem +
                ", satelliteState=" + state +
                "}";
    }

}
