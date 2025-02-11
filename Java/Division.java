public class DivisionWithoutOperator {

    public static void main(String[] args) {
        int dividend = 17;
        int divisor = 3;

        int quotient = 0;
        int remainder = dividend;

        // Division logic using subtraction
        while (remainder >= divisor) {
            remainder -= divisor;
            quotient++;
        }

        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}
