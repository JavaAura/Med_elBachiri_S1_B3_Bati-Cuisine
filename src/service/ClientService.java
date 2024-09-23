package service;

import daoImpl.ClientDaoImpl;
import model.Client;

import java.util.HashMap;

public class ClientService {
    private static ClientDaoImpl clientDao = new ClientDaoImpl();
    private HashMap<String, Client> clients = new HashMap<>();

    public ClientService(){
        clients = clientDao.getAll();
    }
    public Client searchByName(String name){
        return clients.get(name);
    }

    public static Integer create(Client client){
        return clientDao.create(client);
    }
}
