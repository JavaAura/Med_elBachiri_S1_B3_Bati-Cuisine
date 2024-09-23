package view.recourses.project;


import interfaces.View;
import service.ClientService;
import service.ProjectService;


public class Details implements View{
    private ProjectService service = new ProjectService();

    public void display(Object... params){
        int projectId = (int) params[0]; // project id

        // get project and client, method return benefit margin
        double benefitMargin = service.getProjectClient(projectId);

        System.out.println("\n\t\t--- Cost Breakdown ---\n");
        double materialsCostTVA = service.getMaterials(projectId);
        double laborsCostTVA = service.getLabors(projectId);
        double totalCostBeforeMargin = materialsCostTVA + laborsCostTVA;
        double benefitMarginCost = totalCostBeforeMargin * (benefitMargin/100);

        System.out.println("\n\t\t<3> Total cost before margin: \n\t\t" + totalCostBeforeMargin + "MAD");
        System.out.println("\n\t\t<4> Profit margin ("+benefitMargin+"%): \n\t\t" + benefitMarginCost + "MAD");
        System.out.println("\n\t\t**Final total cost of the project: \n\t\t" + (totalCostBeforeMargin + benefitMarginCost) + "MAD**");


    }
}
