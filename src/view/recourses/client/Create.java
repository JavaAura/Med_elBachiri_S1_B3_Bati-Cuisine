package view.recourses.client;

import interfaces.View;
import utils.Input;
import view.routing.Router;

public class Create extends View {
    private Input input = new Input();
    public void display(){
        System.out.println("\t\t-Create new client-\t<1.1>\n");
        getClient();
        System.out.println("[+] client added.");
        boolean continueWclient = input.getYesNo("want to continue with this client");
        if (continueWclient) Router.get("project_create").display(); else Router.get("client").display();
    }
    private void getClient(){
        String name = input.getStr("Enter the name of the client");
        String address = input.getStr("Enter address of the client", true);
        String phone = input.getPhone("Enter phone number of the client (+2127000000)");
    }
}
