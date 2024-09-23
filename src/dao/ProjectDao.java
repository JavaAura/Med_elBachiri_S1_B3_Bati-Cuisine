package dao;

import model.Client;
import model.Labor;
import model.Material;
import model.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectDao {
    public HashMap<String, Project> getAll();
    public Project get(int id);
    public Integer create(Project project);
    public List<Material> getMaterials(int projectId);
    public List<Labor> getLabors(int projectId);
    public boolean setTva(int projectId, double tva);
    public boolean setBenefitMargin(int projectId, double benefitMargin);
    public HashMap<String, Object> projectNClient(int projectId);
}
