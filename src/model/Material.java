package model;

public class Material extends Component {
    private double unitCost;
    private double quantity;
    private double transportCost;
    private double coefficientQuality;

    public Material(String name, String componentType, double TVARate, double unitCost, double quantity, double transportCost, double coefficientQuality) {
        super(name, componentType, TVARate);
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.transportCost = transportCost;
        this.coefficientQuality = coefficientQuality;
    }

    // getters
    public double getUnitCost() { return unitCost; }
    public double getQuantity() { return quantity; }
    public double getTransportCost() { return transportCost; }
    public double getCoefficientQuality() { return coefficientQuality; }
}
