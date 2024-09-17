package view.recourses.project;

import utils.Input;
import interfaces.View;

public class Create extends View {
    private Input input = new Input();

    public void display() {
        System.out.println("\t\t-Create Project-\n");

    }

    private void getProject() {
        String name = input.getStr("Enter project name", false);
        int surface = input.getNum("Entrez la surface de la cuisine (en m²)");
    }
}
