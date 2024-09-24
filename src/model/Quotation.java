package model;

import java.time.LocalDate;

public class Quotation {
    private LocalDate issueDate;
    private LocalDate validUntil;
    private double estimatedAmount;
    private boolean accepted;
    private int projectId;

    public Quotation(LocalDate issueDate, LocalDate validUntil, double estimatedAmount){
        this.issueDate = issueDate;
        this.validUntil = validUntil;
        this.estimatedAmount = estimatedAmount;
    }

    // getters
    public double getEstimatedAmount() { return estimatedAmount; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getValidUntil() { return validUntil; }
    public boolean getIsAccepted(){ return this.accepted; }
    public int getProjectId() { return projectId; }

    // setters
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    public void setValidUntil(LocalDate validUntil) { this.validUntil = validUntil; }
    public void setEstimatedAmount(double estimatedAmount) { this.estimatedAmount = estimatedAmount; }
    public void setAccepted(boolean accepted) { this.accepted = accepted; }
    public void setProjectId(int projectId) { this.projectId = projectId; }
}
