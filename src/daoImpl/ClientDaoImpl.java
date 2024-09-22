package daoImpl;

import dao.ClientDao;
import model.Client;
import utils.db.ModelCrud;

import java.util.HashMap;
import java.util.List;
import model.Client;

public class ClientDaoImpl implements ClientDao {
    private final ModelCrud Model = new ModelCrud(ModelCrud.Table.CLIENTS);
    private  HashMap<String, Client> nameClientsMap = new HashMap<>();
//    private HashMap<Integer, Client> idClientMap = new HashMap<>();
    private HashMap<Integer, List<Object>> fetchedClients = new HashMap<>();

    public ClientDaoImpl(){
        Model.setColumns("name", "address", "phone", "is_professional");
        if (fetchedClients.isEmpty()) fetchedClients = Model.getAll();
    }

    @Override
    public HashMap<String, Client> getAll() {
        if (fetchedClients.isEmpty()) return null;
        fetchedClients.forEach((k, v) -> {
            Client cl = new Client(v.get(1).toString(), v.get(2).toString(), v.get(3).toString(), Boolean.parseBoolean(v.get(4).toString()));
            cl.setId((int) v.get(0));
            nameClientsMap.put((String) v.get(1), cl);
//            idClientMap.put((Integer) v.get(0), cl);
        });
        return nameClientsMap;
    }

    @Override
    public Client get(int id) {
        return null;
    }

    @Override
    public Integer create(Client client) {
        Model.setValues(client.getName(), client.getAddress(), client.getPhone(), client.getIsProfessional());
        return Model.create();
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(int id) {

    }
}
