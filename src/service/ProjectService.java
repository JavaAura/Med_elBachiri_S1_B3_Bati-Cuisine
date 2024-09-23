package service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import daoImpl.ProjectDaoImpl;
import model.Labor;
import model.Material;
import model.Project;
import utils.calculations.Calculate;

import java.util.HashMap;
import java.util.List;

public class ProjectService {
    private static ProjectDaoImpl projectDao = new ProjectDaoImpl();
    private HashMap<String, Project> projects = new HashMap<>();
    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public ProjectService(){
        projects = projectDao.getAll();
    }
    public static Integer create(Project p){
        return projectDao.create(p);
    }

    public double getProjectClient(int projectId){
        HashMap<String, Object> pnc =  projectDao.projectNClient(projectId);
        System.out.println("\n\t\t--- Calculation Result ---\n");
        System.out.println("\t\tProject Name: " + pnc.get("project_name"));
        System.out.println("\t\tClient: " + pnc.get("name"));
        System.out.println("\t\tConstruction Site Address: " + pnc.get("address"));
        System.out.println("\t\tSurface: " + pnc.get("kitchen_area") + "m²");
        return (double) pnc.get("benefit_margin");
    }

    public void displayAllProjects(){
        projects.forEach((k, v) -> v.display());
    }

    public void setTva(int projectId, double tva){
        if (projectDao.setTva(projectId, tva)) System.out.println("\t\t" + tva + "% TVA applied.");else logger.error("ERROR applying TVA.");
    }
    public void setBenefitMargin(int projectId, double benefitMargin){
        if (projectDao.setBenefitMargin(projectId, benefitMargin)) System.out.println("\t\t" + benefitMargin + "% benefit margin applied."); else logger.error("ERROR applying benefit margin.");
    }

    /**
     * @param projectId
     * @return (double) total materials cost with TVA, null if no materials linked to the project.
     */
    public Double getMaterials(int projectId){
        System.out.println("\n\t\t<1> Materials \n");
        List<Material> materials = projectDao.getMaterials(projectId);
        if(materials.isEmpty()) {System.out.println("\n\t\t Project with no materials.\n"); return null;}
        double materialsCost= 0;
        double tva = materials.get(0).getTVARate();
        for(Material m : materials){
            m.display();
            materialsCost += m.getMaterialCost();
        };
        double materialsCostTVA = Calculate.totalCostTVA(tva, materialsCost);
        System.out.println("\t\t    **Total cost of materials before TVA: " + materialsCost + "MAD**");
        System.out.println("\t\t    **Total cost of materials with TVA (" + tva + "%) : " + materialsCostTVA + "MAD**");
        return materialsCostTVA;
    }

    /**
     * @param projectId
     * @return (double) total cost of materials with TVA, null if no labors linked to the project.
     **/
    public Double getLabors(int projectId){
        System.out.println("\n\t\t<2> Labors \n");
        List<Labor> labors = projectDao.getLabors(projectId);
        if(labors.isEmpty()) {System.out.println("\n\t\tProject with no workforce.\n");return null;}
        double laborsCost = 0;
        double tva = labors.get(0).getTVARate();
        for(Labor l : labors){
            l.display();
            laborsCost += l.getLaborCost();
        };
        double laborsCostTVA = Calculate.totalCostTVA(tva, laborsCost);
        System.out.println("\t\t    **Total cost of materials before TVA: " + laborsCost + "MAD **");
        System.out.println("\t\t    **Total cost of materials with TVA (" + tva + "%) : " + laborsCostTVA + "MAD **");
        return laborsCostTVA;
    }

}
