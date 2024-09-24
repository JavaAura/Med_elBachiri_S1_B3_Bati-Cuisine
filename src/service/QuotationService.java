package service;

import daoImpl.QuotationDaoImpl;
import model.Quotation;

public class QuotationService {
    private QuotationDaoImpl quotationDao = new QuotationDaoImpl();

    public boolean createQuotation(Quotation q){
        Integer addedQuoteId = quotationDao.create(q);
        if (addedQuoteId != null) {
            System.out.println("\t\t\n[+] Quote successfully saved!\n");
            return true;
        } else {
            System.out.println("\t\t\n[-] Failed saving quote.");
            return false;
        }
    }

    public boolean getAllWProjects(){
        return quotationDao.getAllQuotationsProjects();
    }

    public boolean accept(int quotationId){
        boolean accepted = quotationDao.accept(quotationId);
        System.out.println(accepted? "\n\t[+] Quotation now is accepted.\n" : "\n\t[-] Error accepting the quotations.\n");
        return accepted;
    }
}
