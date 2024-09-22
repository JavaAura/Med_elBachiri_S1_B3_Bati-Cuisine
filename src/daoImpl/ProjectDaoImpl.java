package daoImpl;

import dao.ProjectDao;
import model.Client;
import model.Labor;
import model.Material;
import model.Project;
import utils.db.ModelCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectDaoImpl implements ProjectDao {
    private final ModelCrud model = new ModelCrud(ModelCrud.Table.PROJECTS);

    public ProjectDaoImpl(){model.setColumns("name", "kitchen_area_m2", "client_id");}

    @Override
    public HashMap<String, Project> getAll() {
        return null;
    }

    @Override
    public Project get(int id) {
        return null;
    }

    @Override
    public Integer create(Project p) {
        model.setValues(p.getName(), p.getKitchenAreaM2(), p.getClientId());
        return model.create();
    }

    @Override
    public List<Material> getMaterials(int projectId) {
        List<Material> materials = new ArrayList<>();
        model.where("project_id");
        model.equalsTo(projectId);
        model.getAll().forEach((k, v) -> {
            Material material = new Material((String) v.get(1), (String) v.get(2), (double) v.get(5), (double) v.get(6), (double) v.get(7), (double) v.get(8));
            material.setMaterialCost((double) v.get(9));
            material.setTVARate((double) v.get(3));
            material.setProjectId((int) v.get(0));
        });
        return materials;
    }

    @Override
    public List<Labor> getLabors(int projectId){
        List<Labor> labors = new ArrayList<>();
        model.where("project_id");
        model.equalsTo(projectId);
        model.getAll().forEach((k, v) -> {
            Labor labor = new Labor((String) v.get(1), (String) v.get(2), (double) v.get(5), (double) v.get(6), (double) v.get(7));
            labor.setLaborCost((double) v.get(8));
            labor.setTVARate((double) v.get(3));
            labor.setProjectId((int) v.get(0));
        });
        return labors;
    }

}
