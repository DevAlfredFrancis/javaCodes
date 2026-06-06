/**
 * Ramos
 * */

public class motorcycle extends Vehicle{
    private String engineType;
    private String modelType;

    motorcycle() {
        this.engineType = "Four Stroke V4";
        this.modelType = "Sport Bike";
    }

    //getter
    public String getEngineType() {
        return engineType;
    }

    //getter
    public String getModelType() {
        return modelType;
    }

    //setter
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    //setter
    public void setModelType(String modelType) {
        this.engineType = engineType;
    }

    public void run() {
        System.out.println("Motorcycle running...");
    }

    public void consumeFuel() {
        System.out.println("consuming fuel...");
    }

    public void dogWheelie() {
        System.out.println("Motorcycle performs dog wheelie..   ");
    }

}
