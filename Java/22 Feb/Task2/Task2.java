import java.util.Scanner;

class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsOfService;

    public void setEmployeeDetails(int empId, String empName, double sal, int yearsOfService) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsOfService = yearsOfService;
    }

  
    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Annual Salary: " + sal);
        System.out.println("Years of Service: " + yearsOfService);
    }

    
    public void getLoanEligibility() {
        if (yearsOfService <= 5) {
            System.out.println("Not eligible for a loan (Service years must be greater than 5).");
            return;
        }
        
        double loanAmount = 0;
        if (sal >= 15_00_000) {
            loanAmount = 7_00_000;
        } else if (sal >= 10_00_000) {
            loanAmount = 5_00_000;
        } else if (sal >= 6_00_000) {
            loanAmount = 2_00_000;
        } else {
            System.out.println("Not eligible for a loan (Salary below 6 lakhs). ");
            return;
        }
        
        System.out.println("Eligible for a loan of Rs. " + loanAmount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp = new Employee();

        System.out.print("Enter Employee ID: ");
        int empId = sc.nextInt();
        sc.nextLine();  // Consume newline

        System.out.print("Enter Employee Name: ");
        String empName = sc.nextLine();

        System.out.print("Enter Annual Salary: ");
        double sal = sc.nextDouble();

        System.out.print("Enter Years of Service: ");
        int yearsOfService = sc.nextInt();

        emp.setEmployeeDetails(empId, empName, sal, yearsOfService);
        System.out.println("\nEmployee Details:");
        emp.getEmployeeDetails();

        System.out.println("\nLoan Eligibility:");
        emp.getLoanEligibility();
    }
}
