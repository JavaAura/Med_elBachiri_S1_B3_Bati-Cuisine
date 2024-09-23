package daoImpl;

import dao.ProjectDao;
import model.Client;
import model.Labor;
import model.Material;
import model.Project;
import utils.db.ModelCrud;

import java.math.BigDecimal;
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
        HashMap<Integer, List<Object>> p = new HashMap<>();
        model.activateWhere(true); model.where("id"); model.equalsTo(id);
        p = model.getAll();
        List<Object> obj = p.get(id);
        Project project = new Project((String) obj.get(1), (double) obj.get(5));
        project.setBenefitMargin((double) obj.get(2));
        project.setTotalCost((double) obj.get(3));
        project.setClientId((int) obj.get(6));
        return project;
    }

    @Override
    public Integer create(Project p) {
        model.setValues(p.getName(), p.getKitchenAreaM2(), p.getClientId());
        return model.create();
    }

    @Override
    public List<Material> getMaterials(int projectId) {
        model.setTable(ModelCrud.Table.MATERIALS);
        List<Material> materials = new ArrayList<>();
        model.activateWhere(true);
        model.where("project_id");
        model.equalsTo(projectId);
        model.getAll().forEach((k, v) -> {
            Material material = new Material(
                    (String) v.get(1),
                    (String) v.get(2),
                    ((BigDecimal) v.get(5)).doubleValue(),
                    ((BigDecimal) v.get(6)).doubleValue(),
                    ((BigDecimal) v.get(7)).doubleValue(),
                    ((BigDecimal) v.get(8)).doubleValue()
            );
            material.setMaterialCost(((BigDecimal) v.get(9)).doubleValue());
            material.setTVARate(((BigDecimal) v.get(3)).doubleValue());
            material.setProjectId((int) v.get(0));
            materials.add(material);

        });
        return materials;
    }

    @Override
    public List<Labor> getLabors(int projectId){
        model.setTable(ModelCrud.Table.LABORS);
        List<Labor> labors = new ArrayList<>();
        model.activateWhere(true);
        model.where("project_id");
        model.equalsTo(projectId);
        model.getAll().forEach((k, v) -> {
            Labor labor = new Labor(
                    (String) v.get(1),
                    (String) v.get(2),
                    ((BigDecimal) v.get(5)).doubleValue(), // up to tables column order
                    ((BigDecimal) v.get(6)).doubleValue(),
                    ((BigDecimal) v.get(7)).doubleValue()
            );
            labor.setLaborCost(((BigDecimal) v.get(8)).doubleValue());
            labor.setTVARate(((BigDecimal) v.get(3)).doubleValue());
            labor.setProjectId((int) v.get(0));
            labors.add(labor);
        });

        return labors;
    }
    @Override
    public boolean setTva(int projectId, double tva){
        model.setTable(ModelCrud.Table.COMPONENTS);
        model.setColumns("tva_rate");
        model.where("project_id"); model.equalsTo(projectId);
        model.setValues(tva);
        model.setThroughMsg(false);
        return model.update();
    }

    @Override
    public boolean setBenefitMargin(int projectId, double benefitMargin){
        model.setTable(ModelCrud.Table.PROJECTS);
        model.setColumns("benefit_margin");
        model.where("id"); model.equalsTo(projectId);
        model.setValues(benefitMargin);
        model.setThroughMsg(false);
        return model.update();
    }

    @Override
    public HashMap<String, Object> projectNClient(int projectId){
        HashMap<String, Object> pnc = new HashMap<>();
        model.activateWhere(true); model.join("clients"); model.on("clients.id = projects.client_id");
        model.where("projects.id"); model.equalsTo(projectId);
        List<Object> c =  model.getAll().get(projectId);

        pnc.put("project_name", c.get(1));
        pnc.put("benefit_margin", c.get(2));
        pnc.put("total_cost", c.get(3));
        pnc.put("status", c.get(4));
        pnc.put("kitchen_area", c.get(5));
        pnc.put("name", c.get(8));
        pnc.put("address", c.get(9));
        pnc.put("phone", c.get(10));
        pnc.put("is_professional", c.get(11));
        return pnc;
    }
}
