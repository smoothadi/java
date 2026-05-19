import employee.Employee; // Import the Employee class
import java.util.Scanner; // Import Scanner for user input
public class EmployeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get details for a single employee
        System.out.print("Enter Employee Number: ");
        int empNum = scanner.nextInt();
        System.out.print("Enter Basic Pay: ");
        double basicPay = scanner.nextDouble();
        // Create an Employee object and set basic pay
        Employee emp = new Employee(empNum, basicPay);
        // Display Employee details
        System.out.println("\nEmployee Details:");
        emp.displayEmployeeDetails();
        // Close the scanner
        scanner.close();
    }
}