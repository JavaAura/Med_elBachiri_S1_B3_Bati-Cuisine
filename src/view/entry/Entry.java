package view.entry;

import utils.Input;
import view.routing.Router;
import interfaces.View;

public class Entry implements View {
    private Input input = new Input();

    public void display(Object... params) {
        System.out.println("\t\t-Principal Menu-\t<0>\n");
        System.out.println("\t1. Create new project.");
        System.out.println("\t2. View all projects.");
        System.out.println("\t3. Calculate the cost of a project.");
        System.out.println("\t4. Quite.");
        Router.get(input.getNum("Enter your choice")).display();
    }
}