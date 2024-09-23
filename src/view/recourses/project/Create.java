package view.recourses.project;

import model.Project;
import service.ProjectService;
import utils.Input;
import interfaces.View;
import view.routing.Router;

public class Create implements View {
    private final Input input = new Input();

    public void display(Object ... params) {
        int clientId = (Integer) params[0];
        System.out.println("\t\t-Create Project-\n");
        Project p = getProject();
        p.setClientId(clientId);
        Integer projectId = ProjectService.create(p);

        Router.get("material_create").display(projectId);
        Router.get("labor_create").display(projectId);
        Router.get("project_calculate_cost").display(projectId, clientId);
    }

    private Project getProject() {
        String name = input.getStr("Enter project name");
        double kitchenArea = input.getDouble("Enter the kitchen area (in m²)");
        return new Project(name, kitchenArea);
    }
}
