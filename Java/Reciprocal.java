import java.util.Scanner;

public class ReciprocalCalculator {

    public static void processInput() {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user for input
            System.out.print("Enter a number to calculate its reciprocal: ");
            String userInput = scanner.nextLine();
            
            // Attempt to parse input to double
            double number = Double.parseDouble(userInput);

            // Check for division by zero
            if (number == 0) {
                throw new ArithmeticException("Cannot calculate the reciprocal of zero.");
            }

            // Calculate reciprocal
            double reciprocal = 1 / number;
            System.out.println("The reciprocal of " + number + " is " + reciprocal);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            // Close the scanner and clean up
            scanner.close();
            System.out.println("Thank you for using the reciprocal calculator.");
        }
    }

    public static void main(String[] args) {
        processInput();
    }
}
