package model;

public class Component {
    private String name;
    private double unitCost;
    private double quantity;
    private String type;
    private double TVARate;

    public Component(String name, double unitCost, double quantity, String type, double TVARate){
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.type = type;
        this.TVARate = TVARate;
    }

    public String getName() { return name; }
    public double getUnitCost() { return unitCost; }
    public double getQuantity() { return quantity; }
    public String getType() { return type; }
    public double getTVARate() { return TVARate; }
}
