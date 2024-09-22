package daoImpl;

import dao.ComponentDao;
import model.Material;
import utils.db.ModelCrud;

import java.util.HashMap;

public class MaterialDaoImpl implements ComponentDao<Material> {
    private final ModelCrud model = new ModelCrud(ModelCrud.Table.MATERIALS);

    public MaterialDaoImpl(){model.setColumns("name", "component_type", "project_id", "unit_cost", "quantity", "transport_cost", "coefficient_quality", "material_cost");}

    @Override
    public HashMap<String, Material> getAll() {
        return null;
    }

    @Override
    public Material get(int id) {
        return null;
    }

    @Override
    public Integer create(Material m) {
        model.setValues(m.getName(), m.getComponentType(), m.getProjectId(), m.getUnitCost(), m.getQuantity(), m.getTransportCost(), m.getCoefficientQuality(), m.getMaterialCost());
        return model.create();
    }

    @Override
    public void update(Material t) {

    }

    @Override
    public void delete(int id) {

    }
}
