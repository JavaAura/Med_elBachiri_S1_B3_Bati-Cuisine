# Bati-Cuisine

## Title: Kitchen Construction Cost Estimation Application

### Quick Description:
An application for estimating kitchen construction costs.

### Context:
Bati-Cuisine is a Java application designed for professionals in kitchen construction and renovation. The application calculates the total cost of a project by factoring in the materials used and the cost of labor, billed hourly.  
The program includes advanced features such as client management, personalized quote generation, and a comprehensive overview of the financial and logistical aspects of renovation projects.  
This project aims to provide professionals with a powerful and practical tool for accurately estimating costs and efficiently managing kitchen renovation projects.

---

## Functional Requirements:

### 1. Project Management
- Add a client associated with the project.
- Add and manage components (materials, labor).
- Associate a quote with the project to estimate costs before starting the work.
- A project is characterized by:
    - `projectName` (String): The name of the construction or renovation project.
    - `profitMargin` (double): Profit margin applied to the total cost.
    - `totalCost` (double): Total calculated cost for the project.
    - `projectStatus` (Enum): The status of the project (In Progress, Completed, Canceled).

### 2. Component Management
#### Materials:
- Manage the cost of materials.
- Materials are characterized by:
    - `name` (String): The name of the component.
    - `unitCost` (double): Unit cost of the component.
    - `quantity` (double): Quantity of components used.
    - `componentType` (String): Type of component (Material or Labor).
    - `taxRate` (double): Applicable tax rate (VAT) for the component.
    - `transportCost` (double): Transport cost for the material.
    - `qualityCoefficient` (double): Coefficient reflecting the quality of the material.

#### Labor:
- Calculate labor costs based on hourly rates, hours worked, and worker productivity.
    - `name` (String): The name of the component.
    - `componentType` (String): Type of component (Material or Labor).
    - `taxRate` (double): Applicable tax rate (VAT) for the component.
    - `hourlyRate` (double): Hourly rate for labor.
    - `workHours` (double): Number of hours worked.
    - `workerProductivity` (double): Factor reflecting the productivity of the workers.

### 3. Client Management
- Register basic client information.
- Differentiate between professional and individual clients, which can affect discounts or applicable taxes.
- Calculate and apply specific discounts based on the client type (e.g., discounts for regular or professional clients).
    - `name` (String): Client's name.
    - `address` (String): Client's address.
    - `phone` (String): Client's phone number.
    - `isProfessional` (boolean): Indicates if the client is a professional.

### 4. Quote Generation
- Generate a quote before starting the work, including an estimate of material costs, labor, equipment, and taxes.
- Include an issue date and a validity date for the quote.
- Indicate whether the quote has been accepted by the client.
    - `estimatedAmount` (double): Estimated project amount based on the quote.
    - `issueDate` (Date): Issue date of the quote.
    - `validityDate` (Date): Validity date of the quote.
    - `accepted` (boolean): Indicates if the quote has been accepted by the client.

### 5. Cost Calculation
- Integrate the cost of components (materials, labor) into the total project cost calculation.
- Apply a profit margin to get the final project cost.
- Account for applicable taxes (VAT) and discounts.
- Manage cost adjustments based on material quality or labor productivity.

### 6. Display Details and Results
- Display complete project details (client, components, total cost).
- Display client information, quotes.
- Generate a detailed summary of the total cost, including labor, materials, taxes, and profit margin.

---

## User Stories:

1. **As a construction professional**, I want to create a new renovation or construction project so that I can track all project details and associated costs.
2. **As a professional**, I want to associate a client with each project so that I can keep track of client information for billing and quotes.
3. **As a user**, I want to add materials to a project with their unit cost, quantity, and transport fees so that I can accurately estimate the material costs for the project.
4. **As a professional**, I want to record worker hours with their hourly rates and productivity so that I can calculate the total labor cost.
5. **As a project manager**, I want to manage multiple types of materials and specialized workers so that I can calculate costs based on the level of quality or expertise required.
6. **As a professional**, I want to generate a quote based on the estimated costs of materials, labor, and equipment so that I can provide a clear and transparent estimate to the client.
7. **As a user**, I want to specify an issue date and a validity date for the quote so that the client knows how long the offer is valid.
8. **As a client**, I want to accept or reject a quote so that the project can proceed with my approval.
9. **As a professional**, I want to store my client information so that I can easily contact them for project follow-up and billing.
10. **As a user**, I want to differentiate between professional and individual clients so that I can apply specific discounts or conditions based on the client type.
11. **As a professional**, I want to calculate the total project cost, including materials, labor, equipment, and taxes, so that I have a clear view of the costs before and after applying the profit margin.
12. **As a manager**, I want to adjust costs based on the quality of materials or worker productivity so that the final estimate accurately reflects variations.
13. **As a professional**, I want to see the taxes applied to each project component so that I can include VAT and other charges in the final estimate.

---

## Example of Usage:

    === Welcome to the Kitchen Renovation Project Management Application === 
    === Main Menu ===

    1. Create a new project
    2. View existing projects
    3. Calculate project cost
    4. Exit Choose an option: 1

## How to Run the Application:
- 1. Clone the repository 
```bash 
   git clone https://github.com/JavaAura/Med_elBachiri_S1_B3_Bati-Cuisine
   cd Med_elBachiri_S1_B3_Bati-Cuisine
   ```

- 2. Compile the Java files

    Use the javac command to compile all the Java files in the project.
```bash
    javac -d out src/**/*.java
```
3. Run the application

    After compiling, run the application from the out directory.
```bash
    java -cp out Main
```
4. Additional Configuration

    - Make sure you have the necessary Java Development Kit (JDK) installed, preferably JDK 8 or higher.

    - If you encounter issues, ensure that the dependencies and environment variables are correctly set up for the project.
5. Run the JAR file: Navigate to the `artifacts/Bati_Cuisine_jar` directory and run the `Bati_Cuisine.jar` file using the following command:
```bash
    java -jar artifacts/Bati_Cuisine_jar/Bati_Cuisine.jar
```

#### Note: No authentication/authorization handling is required for this application.

---
This markdown file includes instructions for running the application, from cloning the repository to running the compiled Java files, Enjoy ^^.
