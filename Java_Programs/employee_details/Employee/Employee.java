package employee;
public class Employee {
    private int empNumber;
    private double basicPay;
    // Constructor to initialize employee number
    public Employee(int empNumber, double pay ) {
        this.empNumber = empNumber;
        this.basicPay = pay;
    }
    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee Number: " + empNumber);
        System.out.println("Basic Pay: " + basicPay);
    }
}