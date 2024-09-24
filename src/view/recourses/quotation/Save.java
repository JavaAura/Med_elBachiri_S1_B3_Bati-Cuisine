package view.recourses.quotation;

import interfaces.View;
import model.Quotation;
import service.QuotationService;
import utils.Input;
import view.routing.Router;

import java.time.LocalDate;
import java.util.Date;

public class Save implements View {
    private Input input = new Input();
    private QuotationService service = new QuotationService();

    public void display(Object... params) {
        int projectId = (int) params[0];
        double estimatedAmount = (double) params[1];

        System.out.println("\n\t\t--- Saving Quotation ---\n");
        Quotation q = getQuotation(estimatedAmount, projectId);
        if (q == null) {backHome();} else {
            boolean added = service.createQuotation(q);
            if (!added) display(projectId, estimatedAmount);
            backHome();
        }
    }

    private Quotation getQuotation(double esAm, int projectId){
        LocalDate issueDate = input.getLocalDate("Enter the date of issue for the quotation", false);
        LocalDate validUntil = input.getLocalDate("Enter the validity date of the quote: ", true);
        Quotation q =  new Quotation(issueDate, validUntil, esAm);
        q.setProjectId(projectId);
        return input.getYesNo("Would you like to save the quote") ?  q :  null;
    }
    private void backHome(){
        System.out.println("\t\t\n--- End of the project ---\n\n\n");
        Router.get("entry").display();
    }
}
