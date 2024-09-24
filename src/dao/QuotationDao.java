package dao;

import model.Quotation;

import java.util.List;

public interface QuotationDao {
    public Integer create(Quotation quotation);
    public boolean getAllQuotationsProjects(); // indicate if empty records
    public boolean accept(int quotationId);
}
