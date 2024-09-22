package model;

public class Project {
    private int id;
    private String name;
    private double benefitMargin;
    private double totalCost;
    private Status status;
    private double kitchenAreaM2;
    private int clientId;

    public enum Status{ IN_PROGRESS, DONE, CANCELED };

    public Project(String name, double kitchenAreaM2){
        this.name = name;
        this.kitchenAreaM2 = kitchenAreaM2;
    }


    // getters
    public int getId() { return id; }
    public String getName() { return name; }
    public double getKitchenAreaM2() { return kitchenAreaM2; }
    public double getBenefitMargin() { return benefitMargin; }
    public double getTotalCost() { return totalCost; }
    public Status getStatus() { return status; }
    public int getClientId() { return clientId; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setKitchenAreaM2(double kitchenAreaM2) { this.kitchenAreaM2 = kitchenAreaM2; }
    public void setBenefitMargin(double benefitMargin) { this.benefitMargin = benefitMargin; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public void setStatus(Status status){ this.status = status;}
    public void setClientId(int clientId) { this.clientId = clientId; }

    public void display(){
        System.out.println(
                "\n\tID: " + id + " | Name: " + name + " | Benefit Margin: " + benefitMargin + " | Status: " + status.name() + " | Kitchen Area: " + kitchenAreaM2 + " | Total Cost: " + totalCost + "\n"
        );
    }
}
