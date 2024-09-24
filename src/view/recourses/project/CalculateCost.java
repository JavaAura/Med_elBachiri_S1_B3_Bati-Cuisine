package view.recourses.project;

import interfaces.View;
import utils.Input;
import view.routing.Router;

public class CalculateCost implements View {
    private Input input = new Input();

    public void display(Object... params) {
        System.out.println("\t\t-Calculate the Cost of a Certain Project");
        int projectId = input.getNum("Enter project ID");
        Router.get("project_details").display(projectId, false);
    }
}
