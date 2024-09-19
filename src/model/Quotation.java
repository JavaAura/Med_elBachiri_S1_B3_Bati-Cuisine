package model;

import java.util.Date;

public class Quotation {
    private double estimatedAmount;
    private Date issueDate;
    private Date validUntil;
    private boolean isAccepted;

    public Quotation(double estimatedAmount, Date issueDate, Date validUntil, boolean isAccepted){
        this.estimatedAmount = estimatedAmount;
        this.issueDate = issueDate;
        this.validUntil = validUntil;
        this.isAccepted = isAccepted;
    }

    public double getEstimatedAmount() { return estimatedAmount; }
    public Date getIssueDate() { return issueDate; }
    public Date getValidUntil() { return validUntil; }
    public boolean getIsAccepted(){ return this.isAccepted; }
}
