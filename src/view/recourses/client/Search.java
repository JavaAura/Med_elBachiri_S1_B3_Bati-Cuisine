package view.recourses.client;

import model.Client;
import service.ClientService;
import utils.Input;
import interfaces.View;
import view.routing.Router;

public class Search extends View {
    private Input input = new Input();
    private ClientService service = new ClientService();

    public void display(Object... params){
        System.out.println("\t\t-Client Search-\n");
        Client client = service.searchByName(input.getStr("Enter client name"));
        if(client == null) System.out.println("\t[-] client not found.\n"); Router.get("clients").display();
        assert client != null;
        client.display();
        if(input.getYesNo("do you want to continue with this client?"))
            Router.get("project_create").display(client.getId());
        else display();
    }
}
