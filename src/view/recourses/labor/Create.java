package view.recourses.labor;

import interfaces.View;
import model.Labor;
import service.LaborService;
import utils.Input;
import utils.calculations.Calculate;

public class Create implements View {
    private Input input = new Input();

    public void display(Object... params) {
        Integer projectId = (Integer) params[0];

        System.out.println("\n\t\t-Add Labor(workers)-");
        Labor labor = getLabor();
        // set project id to material
        labor.setProjectId(projectId);

        // create
        LaborService.create(labor);
        if(input.getYesNo("Do you want to add another type of workforce")) display(projectId);
    }
    public Labor getLabor(){
        String name = input.getStr("Enter the type of workforce (e.g., Basic Worker, Specialist)");
        double hourlyRate = input.getDouble("Enter the hourly rate for this workforce (€ / h)");
        double hoursWorked = input.getDouble("Enter the number of hours worked");
        double workerProductivity = input.getDouble("Enter the productivity factor (1.0 = standard, > 1.0 = high productivity)");
        input.cleanBuffer();
        Labor labor = new Labor(name, "labor", hourlyRate, hoursWorked, workerProductivity);
        labor.setLaborCost(Calculate.laborCost(hourlyRate, hoursWorked, workerProductivity));
        return labor;
    }
}
