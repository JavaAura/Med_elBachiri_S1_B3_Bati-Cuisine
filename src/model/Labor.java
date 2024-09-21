package model;

public class Labor extends Component {
    private double hourlyRate;
    private double hoursWorked;
    private double workerProductivity;

    public Labor(String name, String componentType, double TVARate, double hourlyRate, double hoursWorked, double workerProductivity) {
        super(name, componentType, TVARate);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.workerProductivity = workerProductivity;
    }

    // getters
    public double getHourlyRate() { return hourlyRate; }
    public double getHoursWorked() { return hoursWorked; }
    public double getWorkerProductivity() { return workerProductivity; }
}
