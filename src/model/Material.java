package model;

public class Material extends Component {
    private double transportCost;
    private double coefficientQuality;

    public Material(String name, double unitCost, double quantity, String type, double TVARate, double transportCost, double coefficientQuality) {
        super(name, unitCost, quantity, type, TVARate);
        this.transportCost = transportCost;
        this.coefficientQuality = coefficientQuality;
    }

    public double getTransportCost() { return transportCost; }
    public double getCoefficientQuality() { return coefficientQuality; }
}
