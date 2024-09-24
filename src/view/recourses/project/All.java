package view.recourses.project;

import interfaces.View;
import service.QuotationService;
import utils.Input;
import view.routing.Router;

public class All implements View {
    private QuotationService service = new QuotationService();
    private Input input = new Input();

    public void display(Object... params) {
        System.out.println("\t\t-All Projects with Quotations-\n");
        boolean isEmpty = service.getAllWProjects(); // display all projects with their quotations
        if (isEmpty){
            System.out.println("\t\tNo record.\n\n");
            Router.get("entry").display();
        } else {
            System.out.println("\t1. Update project.");
            System.out.println("\t2. Accept a quotation");
            System.out.println("\t3. Delete project.");
            Router.get(2, input.getNum("Enter your choice")).display();
        }
    }
}
