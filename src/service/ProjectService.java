package service;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import daoImpl.ProjectDaoImpl;
import model.Labor;
import model.Material;
import model.Project;
import utils.calculations.Calculate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectService {
    private static ProjectDaoImpl projectDao = new ProjectDaoImpl();
    private final Logger logger = LoggerFactory.getLogger(ProjectService.class);

    public static Integer create(Project p){
        return projectDao.create(p);
    }

    public Double getProjectClient(int projectId){
        HashMap<String, Object> pnc =  projectDao.projectNClient(projectId);
        System.out.println("\n\t\t--- Calculation Result ---\n");
        System.out.println("\t\tProject Name: " + pnc.get("project_name"));
        System.out.println("\t\tClient: " + pnc.get("name"));
        System.out.println("\t\tConstruction Site Address: " + pnc.get("address"));
        System.out.println("\t\tSurface: " + pnc.get("kitchen_area") + "m²");
        BigDecimal benefitMargin = (BigDecimal) pnc.get("benefit_margin");
        return benefitMargin == null ? null : benefitMargin.doubleValue();
    }

    public void setTva(int projectId, double tva){
        if (projectDao.setTva(projectId, tva)) System.out.println("\t\t" + tva + "% TVA applied.");else logger.error("ERROR applying TVA.");
    }
    public void setBenefitMargin(int projectId, double benefitMargin){
        if (projectDao.setBenefitMargin(projectId, benefitMargin)) System.out.println("\t\t" + benefitMargin + "% benefit margin applied."); else logger.error("ERROR applying benefit margin.");
    }

    /**
     * @param projectId
     * @return (double) total materials cost with or without TVA ( it's up to either there is a tva or not) , null if no materials linked to the project.
     */
    public Double getMaterials(int projectId){
        System.out.println("\n\t\t<1> Materials \n");
        List<Material> materials = projectDao.getMaterials(projectId);
        if(materials.isEmpty()) {System.out.println("\n\t\t Project with no materials.\n"); return null;}
        double materialsCost= 0;
        Double tva = materials.get(0).getTVARate();
        for(Material m : materials){
            m.display();
            materialsCost += m.getMaterialCost();
        };
        System.out.println("\t\t    **Total cost of materials without TVA: " + materialsCost + "MAD**");
        if (tva != null){
            double materialsCostTVA = Calculate.totalCostTVA(tva, materialsCost);
            System.out.println("\t\t    **Total cost of materials with TVA (" + tva + "%) : " + materialsCostTVA + "MAD**");
            return materialsCostTVA;
        } else return materialsCost;
    }

    /**
     * @param projectId
     * @return (double) total cost of materials with TVA or without ( up to either there is a tva or not ), null if no labors linked to the project.
     **/
    public Double getLabors(int projectId){
        System.out.println("\n\t\t<2> Labors \n");
        List<Labor> labors = projectDao.getLabors(projectId);
        if(labors.isEmpty()) {System.out.println("\n\t\tProject with no workforce.\n");return null;}
        double laborsCost = 0;
        Double tva = labors.get(0).getTVARate();
        for(Labor l : labors){
            l.display();
            laborsCost += l.getLaborCost();
        };
        System.out.println("\t\t    **Total cost of materials without TVA: " + laborsCost + "MAD **");
        if (tva != null){
            double laborsCostTVA = Calculate.totalCostTVA(tva, laborsCost);
            System.out.println("\t\t    **Total cost of materials with TVA (" + tva + "%) : " + laborsCostTVA + "MAD **");
            return laborsCostTVA;
        } else return laborsCost;
    }

    public void delete(int projectId){
        boolean deleted = projectDao.delete(projectId);
        System.out.println(deleted? "[+] Project deleted.\n" : "[-] Failed deleting project.\n");
    }
    public void update(Project p){
        boolean updated = projectDao.update(p);
        System.out.println(updated ? "[+] Project updated successfully.\n" : "[-] Project not found.\n");
    }
    public boolean get(int projectId){
        Project p = projectDao.get(projectId);
        return p != null;
    }
}
