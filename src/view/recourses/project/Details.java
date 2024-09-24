package view.recourses.project;

import interfaces.View;
import service.ProjectService;
import view.routing.Router;

import java.util.HashMap;

public class Details implements View {
    private ProjectService service = new ProjectService();
    private Double benefitMargin;
    private Double tva;

    public void display(Object... params) {
        int projectId = (int) params[0];
        boolean saveQuotation = (boolean) params[1];

        benefitMargin = service.getProjectClient(projectId);

        double materialsCost = service.getMaterials(projectId);
        double laborsCost = service.getLabors(projectId);
        double totalCostBeforeMargin = materialsCost + laborsCost;

        System.out.println("\n\t\t--- Cost Breakdown ---\n");
        System.out.printf("\n\t\t<3> Total cost without margin: \n\t\t%.2f MAD", totalCostBeforeMargin);

        double benefitMarginCost = (benefitMargin != null) ? totalCostBeforeMargin * (benefitMargin / 100) : 0;
        double projectTotalCost = totalCostBeforeMargin + benefitMarginCost;

        if (benefitMargin != null) {
            System.out.printf("\n\t\t<4> Profit margin (%.2f%%): \n\t\t%.2f MAD", benefitMargin, benefitMarginCost);
        }

        System.out.printf("\n\t\t**Final total cost of the project: \n\t\t%.2f MAD**", projectTotalCost);
        if (saveQuotation){
            Router.get("project_save_quotation").display(projectId, projectTotalCost);
        } else Router.get("entry").display();
    }
}
