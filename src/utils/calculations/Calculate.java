package utils.calculations;

public class Calculate {
    public static Double materialCost(double quantity, double unitCost, double coefficientQuality, double transportCost){
        return (quantity * unitCost * coefficientQuality) + transportCost;
    }
    public static Double laborCost(double hourlyRate, double hoursWorked, double workerProductivity){
        return hourlyRate * hoursWorked * workerProductivity;
    }
    public static double totalCostTVA(double tva, double totalComponentsCost){
        return totalComponentsCost + (totalComponentsCost * (tva/100));
    }
}
