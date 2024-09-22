package view.recourses.project;

import interfaces.View;
import service.MaterialService;
import service.ProjectService;
import utils.Input;
import view.routing.Router;

public class CalculateCost implements View{
    private Input input = new Input();
    private ProjectService service = new ProjectService();


    private Double tva = null;
    private Double benefitMargin = null;

    public void display(Object... params){
        int projectId = (Integer) params[0];

        System.out.println("\t\t-Calculate Project Cost-\n\n");
        if(input.getYesNo("Do you want to apply VAT to the project")) {
            tva = input.getDouble("Enter the TVA percentage (%) ");
            input.cleanBuffer();
            
        }
        if(input.getYesNo("Do you want to apply a profit margin to the project")){

            input.cleanBuffer();
        }
        MaterialService.get(1);

        Router.get("project_details").display();
    }


}
