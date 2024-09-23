package model;

public class Labor extends Component {
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;
    private double laborCost;

    public Labor(String name, String componentType, double hourlyRate, double hoursWorked, double workerProductivity) {
        super(name, componentType);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }

    // getters
    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public double getWorkerProductivity() { return workerProductivity; }
    public double getLaborCost() { return laborCost; }
    // setters
    public void setLaborCost(double laborCost) { this.laborCost = laborCost; }

    public void display(){
        System.out.println(
                "\t\t- " + this.getName() + ": " + this.laborCost + " MAD (hourly rate: " + hourlyRate + " MAD/h, worked hours: " + hoursWorked + " h, productivity: " + workerProductivity  + ")"
        );
    }
}
