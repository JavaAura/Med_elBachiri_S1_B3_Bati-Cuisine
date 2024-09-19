package model;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class Project {
    private int id;
    private String name;
    private double benefitMargin;
    private double totalCost;
    public enum Status{ IN_PROGRESS, DONE, CANCELED };
    private final Status status;
    private static final Logger logger = LoggerFactory.getLogger(Project.class);

    public Project(String name, double benefitMargin, double totalCost, Status status){
        this.name = name;
        this.benefitMargin = benefitMargin;
        this.totalCost = totalCost;
        this.status = status;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public String getName() { return name; }
    public double getBenefitMargin() { return benefitMargin; }
    public double getTotalCost() { return totalCost; }

    public void setName(String name) { this.name = name; }
    public void setBenefitMargin(double benefitMargin) { this.benefitMargin = benefitMargin; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
    public Logger getLogger(){ return logger; }
    public Status getStatus(){ return this.status; }
}
