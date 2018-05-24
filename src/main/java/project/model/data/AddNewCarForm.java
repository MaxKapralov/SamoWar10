package project.model.data;

public class AddNewCarForm {

    private String brand;
    private String model;
    private String number;
    private int numOfPass;
    private double fuelConsumption;
    private double engineVol;
    private boolean conditioner;
    private String interior;
    private String type;
    private int cost;

    public AddNewCarForm() {}

    public AddNewCarForm(String brand, String model, String number, int numOfPass, double fuelConsumption, double engineVol, boolean conditioner, String interior, String type, int cost) {
        this.brand = brand;
        this.model = model;
        this.number = number;
        this.numOfPass = numOfPass;
        this.fuelConsumption = fuelConsumption;
        this.engineVol = engineVol;
        this.conditioner = conditioner;
        this.interior = interior;
        this.type = type;
        this.cost = cost;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getNumOfPass() {
        return numOfPass;
    }

    public void setNumOfPass(int numOfPass) {
        this.numOfPass = numOfPass;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getEngineVol() {
        return engineVol;
    }

    public void setEngineVol(double egineVol) {
        this.engineVol = egineVol;
    }

    public boolean hasConditioner() {
        return conditioner;
    }

    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
