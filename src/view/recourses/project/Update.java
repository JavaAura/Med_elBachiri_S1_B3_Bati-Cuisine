package view.recourses.project;

import interfaces.View;
import model.Project;
import service.ProjectService;
import utils.Input;
import view.routing.Router;

import java.util.Arrays;

public class Update implements View {
    private Input input = new Input();
    private ProjectService service = new ProjectService();

    public void display(Object... params) {
        Project p = getUpdatedProject();
        service.update(p);
        Router.get("entry").display();
    }

    public Project getUpdatedProject(){
        int id = input.getNum("Enter project ID to update");
        input.cleanBuffer();
        String name = input.getStr("Enter new name");
        double kitchenArea = input.getDouble("Enter kitchen area");
        input.cleanBuffer();
        Project.Status status = input.getProjectStatus("Enter project status (IN_PROGRESS, DONE, CANCELED) : ");
        Project p = new Project(name, kitchenArea);
        p.setStatus(status);
        p.setId(id);
        return p;
    }
}
