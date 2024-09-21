package view.recourses.client;

import interfaces.View;
import model.Client;
import service.ClientService;
import utils.Input;
import view.routing.Router;

public class Create extends View {
    private Input input = new Input();

    public void display(Object... params){
        System.out.println("\t\t-Create new client-\n");
        Integer cId = ClientService.create(getClient());
        if(cId != null){
            boolean keepThis = input.getYesNo("do you want to continue with this client?");
            if (keepThis) Router.get("project_create").display(cId); else display(); // Router.get("client").display();
        } else display();
    }

    private Client getClient(){
        String name = input.getStr("Enter the name of the client");
        String address = input.getStr("Enter address of the client", true);
        String phone = input.getPhone("Enter phone number of the client (+2127000000)");
        boolean isProfessional = input.getYesNo("Is this client professional?");
        return new Client(name, address, phone, isProfessional);
    }
}
