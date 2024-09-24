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

    public ProjectDaoImpl() {
        model.setColumns("name", "kitchen_area_m2", "client_id");
    }

    @Override
    public HashMap<String, Project> getAll() {
        // Implement the logic for retrieving all projects
        return null;
    }

    @Override
    public Project get(int id) {
        model.activateWhere(true);
        model.where("id");
        model.equalsTo(id);

        HashMap<Integer, List<Object>> result = model.getAll();
        List<Object> obj = result.get(id);

        if (obj == null || obj.isEmpty()) {
            return null;
        }

        Project project = new Project((String) obj.get(1), ((BigDecimal) obj.get(5)).doubleValue());
        return project;
    }

    @Override
    public Integer create(Project p) {
        model.setValues(p.getName(), p.getKitchenAreaM2(), p.getClientId());
        return model.create();
    }

    @Override
    public List<Material> getMaterials(int projectId) {
        model.setQuery(null);
        model.setTable(ModelCrud.Table.MATERIALS);
        model.activateWhere(true);
        model.where("project_id");
        model.equalsTo(projectId);

        List<Material> materials = new ArrayList<>();
        model.getAll().forEach((k, v) -> {
            Material material = new Material(
                    v.get(1).toString(),
                    v.get(2).toString(),
                    ((BigDecimal) v.get(5)).doubleValue(),
                    ((BigDecimal) v.get(6)).doubleValue(),
                    ((BigDecimal) v.get(7)).doubleValue(),
                    ((BigDecimal) v.get(8)).doubleValue()
            );
            material.setMaterialCost(((BigDecimal) v.get(9)).doubleValue());
            BigDecimal tvaRateValue = (BigDecimal) v.get(3);
            if (tvaRateValue != null){
                material.setTVARate(((BigDecimal) v.get(3)).doubleValue());
            }
            material.setProjectId((int) v.get(0));
            materials.add(material);
        });

        return materials;
    }

    @Override
    public List<Labor> getLabors(int projectId) {
        model.setQuery(null);
        model.setTable(ModelCrud.Table.LABORS);
        model.activateWhere(true);
        model.where("project_id");
        model.equalsTo(projectId);

        List<Labor> labors = new ArrayList<>();
        model.getAll().forEach((k, v) -> {
            Labor labor = new Labor(
                    (String) v.get(1),
                    (String) v.get(2),
                    ((BigDecimal) v.get(5)).doubleValue(),
                    ((BigDecimal) v.get(6)).doubleValue(),
                    ((BigDecimal) v.get(7)).doubleValue()
            );
            labor.setLaborCost(((BigDecimal) v.get(8)).doubleValue());
            BigDecimal tvaRateValue = (BigDecimal) v.get(3);
            if (tvaRateValue != null){
                labor.setTVARate(((BigDecimal) v.get(3)).doubleValue());
            }
            labor.setProjectId((int) v.get(0));
            labors.add(labor);
        });

        return labors;
    }

    @Override
    public boolean setTva(int projectId, double tva) {
        model.setTable(ModelCrud.Table.COMPONENTS);
        model.setColumns("tva_rate");
        model.where("project_id");
        model.equalsTo(projectId);
        model.setValues(tva);
        model.setThroughMsg(false);
        return model.update();
    }

    @Override
    public boolean setBenefitMargin(int projectId, double benefitMargin) {
        model.setTable(ModelCrud.Table.PROJECTS);
        model.setColumns("benefit_margin");
        model.where("id");
        model.equalsTo(projectId);
        model.setValues(benefitMargin);
        model.setThroughMsg(false);
        return model.update();
    }

    @Override
    public HashMap<String, Object> projectNClient(int projectId) {
        model.activateWhere(true);
        model.setQuery(
                "SELECT p.id, p.name, p.benefit_margin, p.total_cost, p.status, p.kitchen_area_m2, c.name, c.address, c.phone, c.is_professional " +
                        "FROM projects p " +
                        "JOIN clients c ON c.id = p.client_id " +
                        "WHERE p.id = ?"
        );
        model.equalsTo(projectId);

        HashMap<String, Object> pnc = new HashMap<>();
        List<Object> c = model.getAll().get(projectId);

        if (c == null || c.isEmpty()) {
            return pnc;
        }

        pnc.put("project_name", c.get(1));
        pnc.put("benefit_margin", c.get(2));
        pnc.put("total_cost", c.get(3));
        pnc.put("status", c.get(4));
        pnc.put("kitchen_area_m2", c.get(5));
        pnc.put("name", c.get(6));
        pnc.put("address", c.get(7));
        pnc.put("phone", c.get(8));
        pnc.put("is_professional", c.get(9));

        return pnc;
    }

    @Override
    public boolean delete(int projectId){
        model.setTable(ModelCrud.Table.PROJECTS);
        model.setThroughMsg(false);
        model.activateWhere(true);
        model.where("id"); model.equalsTo(projectId);
        return model.delete();
    }

    @Override
    public boolean update(Project p){
        model.activateWhere(true);
        model.setColumns("name", "kitchen_area_m2", "status");
        model.setValues(p.getName(), p.getKitchenAreaM2(), p.getStatus().name());
        model.where("id"); model.equalsTo(p.getId());
        model.setThroughMsg(false);
        model.setIsStatus(true);
        return model.update();
    }

}
