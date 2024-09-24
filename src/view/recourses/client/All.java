package view.recourses.client;

import interfaces.View;
import service.ClientService;
import view.routing.Router;

public class All implements View {
    private ClientService service = new ClientService();

    public void display(Object... params) {
        System.out.println("\t\t-All Clients-\n");
        service.displayClients();
        Router.get("clients").display();
    }
}
