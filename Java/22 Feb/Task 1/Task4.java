import java.util.Arrays;

public class Task4 {
    public static void main(String[] args) {
        int[] originalArray = {10, 20, 30, 40, 50, 60};
        int[] copiedArray = Arrays.copyOfRange(originalArray, 1, 4);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Copied Range: " + Arrays.toString(copiedArray));
    }
}
