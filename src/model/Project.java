package model;

public class Project {
    private int id;
    private String name;
    private double benefitMargin;
    private double totalCost;
    private final Status status;
    private double kitchenAreaM2;

    public enum Status{ IN_PROGRESS, DONE, CANCELED };

    public Project(String name, double kitchenAreaM2, double benefitMargin, double totalCost, Status status){
        this.name = name;
        this.kitchenAreaM2 = kitchenAreaM2;
        this.benefitMargin = benefitMargin;
        this.totalCost = totalCost;
        this.status = status;
    }


    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getKitchenAreaM2() { return kitchenAreaM2; }
    public double getBenefitMargin() { return benefitMargin; }
    public double getTotalCost() { return totalCost; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setKitchenAreaM2(double kitchenAreaM2) { this.kitchenAreaM2 = kitchenAreaM2; }
    public void setBenefitMargin(double benefitMargin) { this.benefitMargin = benefitMargin; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
}
