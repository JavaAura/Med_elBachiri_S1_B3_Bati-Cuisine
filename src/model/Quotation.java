package model;

import java.util.Date;

public class Quotation {
    private double estimatedAmount;
    private Date issueDate;
    private Date validUntil;
    private boolean accepted;

    public Quotation(double estimatedAmount, Date issueDate, Date validUntil, boolean accepted){
        this.estimatedAmount = estimatedAmount;
        this.issueDate = issueDate;
        this.validUntil = validUntil;
        this.accepted = accepted;
    }

    public double getEstimatedAmount() { return estimatedAmount; }
    public Date getIssueDate() { return issueDate; }
    public Date getValidUntil() { return validUntil; }
    public boolean getIsAccepted(){ return this.accepted; }
}
