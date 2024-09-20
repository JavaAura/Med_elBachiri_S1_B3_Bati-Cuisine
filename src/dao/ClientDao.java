package dao;

import java.util.HashMap;
import model.Client;

public interface ClientDao {
    public HashMap<String, Client> getAll();
    public Client get(int id);
    public void create(Client user);
    public void update(Client client);
    public void delete(int id);

}
