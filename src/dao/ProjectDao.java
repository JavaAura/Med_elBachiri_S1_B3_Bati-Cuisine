package dao;

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
}
