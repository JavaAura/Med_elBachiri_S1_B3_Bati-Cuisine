package view.recourses.quotation;

import interfaces.View;
import service.QuotationService;
import utils.Input;
import view.routing.Router;

public class Accept implements View {
    private Input input = new Input();
    private QuotationService service = new QuotationService();

    public void display(Object... params) {
        int qId = input.getNum("Enter quotation ID");
        service.accept(qId);
        Router.get("entry").display();
    }
}
