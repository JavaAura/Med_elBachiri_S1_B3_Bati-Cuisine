package view.recourses.project;

import interfaces.View;
import service.ProjectService;
import utils.Input;

public class Delete implements View {
    private Input input = new Input();
    private ProjectService service = new ProjectService();

    public void display(Object... params) {
        service.delete(input.getNum("Enter project ID"));

    }
}
