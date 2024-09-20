package view.recourses.client;

import daoImpl.ClientDaoImpl;
import model.Client;
import service.ClientService;
import utils.Input;
import interfaces.View;

public class Search extends View {
    private Input input = new Input();
    private ClientService service = new ClientService();

    public void display(){
        System.out.println("\t\t-Client Search-\n");
        Client client = service.searchByName(input.getStr("Enter client name"));
    }
}
