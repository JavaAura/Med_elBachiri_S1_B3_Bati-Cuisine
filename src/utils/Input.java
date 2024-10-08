package utils;


import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import model.Project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;


public class Input {
    private Scanner scan = new Scanner(System.in);
    private Logger logger = LoggerFactory.getLogger(Input.class);

    private <T> T numTemplate(String message, Supplier<T> supplier){
        while (true) {
            try {
                System.out.println(message != "" ? (">>> " + message + ":") : ">>> Enter number: ");
                return supplier.get();
            } catch (InputMismatchException e) {
                logger.error("[-] Please enter valid number.\n");
                scan.nextLine();
            }
        }
    }
    public int getNum(String message) {
        return numTemplate(message, () -> scan.nextInt());
    }
    public double getDouble(String message) {
        return numTemplate(message, () -> scan.nextDouble());
    }

    public String getStr(String message){
        while (true) {
            System.out.println(message != "" ? (">>> " + message + ":") : ">>> Enter text:");
            String input = scan.nextLine();
            if(input.replaceAll(" ", "").matches("[a-zA-Z]+")) return input; else logger.error("[-] Inpute must contain only letters.");
        }
    }
    public String getStr(String message, boolean includeNumbers){
        if(!includeNumbers) return getStr(message);
        while (true) {
            System.out.println(message != "" ? (">>> " + message + ":") : ">>> Enter text:");
            String input = scan.nextLine();
            if (input.replaceAll(" ", "").matches("[\\w&&[^_]]+")) return input; else logger.error("[-] Inpute must contain only letters and numbers.\n");
        }
    }
    public LocalDate getLocalDate(String message, boolean mustBeAboveNow){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        while (true) {
            try{
                System.out.println(message != "" ? (">>> " + message + " (format: DD/MM/YYYY):") : ">>> Enter date (format: DD/MM/YYYY):");
                String input = scan.nextLine();
                LocalDate inputDate = LocalDate.parse(input, form);

                if (mustBeAboveNow && inputDate.isAfter(now)){ return inputDate; }
                else if (!mustBeAboveNow && inputDate.isBefore(now)){ return inputDate; }
                else { logger.error("[-] Please enter a date that is before " + now + "\n"); }

            } catch (DateTimeParseException e){
                logger.error("[-] Invalid date, please enter a date in this format (DD/MM/YYYY)\n");
            }
        }
    }

    public boolean getYesNo(String message){
        while (true) {
            System.out.println(message != "" ? (">>> " + message + " ? (y/n) : ") : ">>> You want ? (y/n) : ");
            String input = scan.nextLine();
            if (input.toLowerCase().matches("y||n")) return input.equalsIgnoreCase("y");
            else logger.error("[-] Input must be either \"y/Y\" or \"n/N\"\n");
        }
    }

    public String getPhone(String message){
        while (true) {
            System.out.println(message != "" ? (">>> " + message + ":") : ">>> Enter phone number (+212700000000) : ");
            String input = scan.nextLine();
            if (input.replaceAll("[\\s\\-]", "").matches("\\+[0-9]{10,14}")) return input.replaceAll("[\\s\\-]", ""); else logger.error("[-] Input must be like +XXXXXXXXXX (10 to 14 numbers, note: can contain \" \" or \"-\").\n");
        }
    }
    public Project.Status getProjectStatus(String message){
        Project.Status[] status = new Project.Status[]{Project.Status.IN_PROGRESS, Project.Status.DONE, Project.Status.CANCELED};
        while (true){
            String input = getStr(message).toUpperCase();
            Optional<Project.Status> matchedStatus = Arrays.stream(status).filter(s -> s.name().matches(input)).findFirst();
            if (matchedStatus.isPresent()){
                return matchedStatus.get();
            } else logger.warn("[-] Choice must be one of the following (IN_PROGRESS, DONE, CANCELED),\n Note: case ignored.");
        }
    }
    public void cleanBuffer(){
        scan.nextLine();
    }
}