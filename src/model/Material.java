package model;

public class Material extends Component {
    private double unitCost;
    private double quantity;
    private double transportCost;
    private double coefficientQuality;
    private double materialCost;

    public Material(String name, String componentType, double unitCost, double quantity, double transportCost, double coefficientQuality) {
        super(name, componentType);
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
    public double getMaterialCost() { return materialCost; }

    // setters

    public void setMaterialCost(double materialCost) { this.materialCost = materialCost; }

    public void display(){
        System.out.println(
                "\t\t- " + this.getName() + ": " + this.materialCost + " MAD (quantity: " + quantity + " m², unit cost: " + unitCost + " MAD/m², coefficient quality: " + coefficientQuality + ", transport cost: " + transportCost + "MAD)"
        );
    }
}
