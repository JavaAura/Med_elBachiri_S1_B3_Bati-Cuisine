package view.recourses.material;

import interfaces.View;
import model.Material;
import service.MaterialService;
import utils.Input;
import utils.calculations.Calculate;


public class Create implements View {
    private final Input input = new Input();

    public void display(Object... params){
        Integer projectId = (Integer) params[0];
        System.out.println("\t\t-Add Material-\n");

        Material material = getMaterial();
        material.setProjectId(projectId);

        // create material
        MaterialService.create(material);
        if(input.getYesNo("Would you like to add another material")) display(projectId); else return;
    }
    public Material getMaterial(){
        String name = input.getStr("Enter the name of the material");
        double quantity = input.getDouble("Enter the quantity of this material (in m²)");
        double unitCost = input.getDouble("Enter the unit cost of this material (€/m²)");
        double transportCost = input.getDouble("Enter the transportation cost of this material (€)");
        double coefficientQuality = input.getDouble("Enter the material quality coefficient (1.0 = standard, > 1.0 = high quality)");
        input.cleanBuffer(); // clear buffer
        Material material = new Material(name, "material", unitCost, quantity, transportCost, coefficientQuality);
        material.setMaterialCost(Calculate.materialCost(quantity, unitCost, coefficientQuality, transportCost));
        return material;
    }
}
