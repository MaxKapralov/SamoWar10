package project.model.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_info")
public class CarInfo {

    @Id
    @Column(name = "id_car", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(name = "num_of_pass", nullable = false)
    private int numOfPass;

    @Column(name="fuel_consumption", nullable = false)
    private double fuelConsumption;

    @Column(name = "engine_vol", nullable = false)
    private double engineVol;

    @Column(nullable = false)
    private boolean conditioner;

    @Column(nullable = false)
    private String interior;

    @Column(nullable = false)
    private String type;

    @Column(name = "cost_per_day", nullable = false)
    private int cost;

    public CarInfo(){}

    public CarInfo(Long id, String number, int numOfPass, double fuelConsumption, double engineVol, boolean conditioner, String interior, String type, int cost)
    {
        this.id = id;
        this.number = number;
        this.numOfPass = numOfPass;
        this.fuelConsumption = fuelConsumption;
        this.engineVol = engineVol;
        this.conditioner = conditioner;
        this.interior = interior;
        this.type = type;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setEngineVol(double engineVol) {
        this.engineVol = engineVol;
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
