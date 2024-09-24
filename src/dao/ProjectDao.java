package dao;

import model.Client;
import model.Labor;
import model.Material;
import model.Project;

import java.util.HashMap;
import java.util.List;

public interface ProjectDao {
    HashMap<String, Project> getAll();
    Project get(int id);
    Integer create(Project project);
    List<Material> getMaterials(int projectId);
    List<Labor> getLabors(int projectId);
    boolean setTva(int projectId, double tva);
    boolean setBenefitMargin(int projectId, double benefitMargin);
    HashMap<String, Object> projectNClient(int projectId);
    boolean delete(int projectId);
    boolean update(Project project);
}
