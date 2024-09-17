package view.recourses.client;

import utils.Input;
import view.routing.Router;
import interfaces.View;

public class Index extends View {
    private Input input = new Input();

    public void display() {
        System.out.println("\t\t-Client Index-\t<1>\n");
        System.out.println("\t1. Create new clinet.");
        System.out.println("\t2. Search existent client.");
        // router.get(1+(input.getNum("")/10));
        Router.get(1, input.getNum("Enter your choice")).display();
    }
}
