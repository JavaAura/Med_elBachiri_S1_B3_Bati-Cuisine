package model;

public class Component {
    private String name;
    private String componentType;
    private double TVARate;

    public Component(String name, String componentType, double TVARate){
        this.name = name;
        this.componentType = componentType;
        this.TVARate = TVARate;
    }

    public String getName() { return name; }
    public String getComponentType() { return componentType; }
    public double getTVARate() { return TVARate; }
}
