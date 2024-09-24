package model;

public class Component {
    private String name;
    private String componentType;
    private Double TVARate;
    private int projectId;

    public Component(String name, String componentType){
        this.name = name;
        this.componentType = componentType;
    }

    // getters
    public String getName() { return name; }
    public String getComponentType() { return componentType; }
    public Double getTVARate() { return TVARate; }
    public int getProjectId() { return projectId; }

    // setters
    public void setTVARate(Double TVARate) { this.TVARate = TVARate; }
    public void setProjectId(int projectId) { this.projectId = projectId; }
}
