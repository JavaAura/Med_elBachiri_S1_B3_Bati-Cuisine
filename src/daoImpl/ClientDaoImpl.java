package daoImpl;

import dao.ClientDao;
import model.Client;
import utils.db.ModelCrud;

import java.util.HashMap;
import java.util.List;
import model.Client;

public class ClientDaoImpl implements ClientDao {
    private ModelCrud Model = new ModelCrud(ModelCrud.Table.CLIENTS);

    @Override
    public HashMap<String, Client> getAll() {
        HashMap<String, Client> clientsMap = new HashMap<>();
        HashMap<Integer, List<Object>> fetchClients = Model.getAll();

        fetchClients.forEach((k, v) -> {
            clientsMap.put(v.get(1).toString(), new Client(v.get(0).toString(), v.get(1).toString(), v.get(2).toString(), Boolean.parseBoolean(v.get(3).toString())));
        });

        return clientsMap;
    }

    @Override
    public Client get(int id) {
        return null;
    }

    @Override
    public void create(Client client) {

    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(int id) {

    }
}
