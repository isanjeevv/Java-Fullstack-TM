import java.util.Arrays;

public class Task3{
    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3};
        Integer[] arr2 = {1, 2, 3};

        System.out.println("Using equals(): " + Arrays.equals(arr1, arr2));
        System.out.println("Using deepEquals(): " + Arrays.deepEquals(arr1, arr2));
    }
}