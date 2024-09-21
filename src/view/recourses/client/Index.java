package view.recourses.client;

import daoImpl.ClientDaoImpl;
import utils.Input;
import view.routing.Router;
import interfaces.View;

public class Index extends View {
    private Input input = new Input();

    public void display(Object... params) {
        System.out.println("\t\t-Client Index-\t<1>\n");
        System.out.println("\t1. Create new client.");
        System.out.println("\t2. Search existent client.");
        System.out.println("\t3. Back Home.");
        Router.get(1, input.getNum("Enter your choice")).display();
    }

}
