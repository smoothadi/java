import java.util.Scanner;


class EmployeeMain 
{
    	private int empNumber;
   	private double basicPay;

    	public EmployeeMain(int empNumber) 
	{
        	this.empNumber = empNumber;
   	}

    
    	public void setBasicPay(double pay) 	
	{
        	this.basicPay = pay;
    	}

    	public void displayEmployeeDetails() 
	{
        	System.out.println("Employee Number: " + empNumber);
        	System.out.println("Basic Pay: " + basicPay);
    	}
    
    
    	public static void main(String[] args) 
	{
        	Scanner scanner = new Scanner(System.in);

       
        	System.out.print("Enter Employee Number: ");
        	int empNum = scanner.nextInt();

        	System.out.print("Enter Basic Pay: ");
        	double basicPay = scanner.nextDouble();

       
        	EmployeeMain emp = new EmployeeMain(empNum); 
        	emp.setBasicPay(basicPay);

       
        	System.out.println("\nEmployee Details:");
        	emp.displayEmployeeDetails();

        	scanner.close();
    	}
}
