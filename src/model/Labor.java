package model;

public class Labor extends Component {
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;

    public Labor(String name, double unitCost, double quantity, String type, double TVARate, double hourlyRate, double hoursWorked, double workerProductivity) {
        super(name, unitCost, quantity, type, TVARate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }

    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public double getWorkerProductivity() { return workerProductivity; }
}
