package view.recourses.project;

import utils.Input;
import interfaces.View;

public class Create extends View {
    private Input input = new Input();

    public void display(Object ... params) {
        int id = (Integer) params[0];
        System.out.println("\t\t-Create Project-\n");

    }

    private void getProject() {
        String name = input.getStr("Enter project name");
        double surface = input.getDouble("Enter the kitchen area (in m²)");
    }
}
