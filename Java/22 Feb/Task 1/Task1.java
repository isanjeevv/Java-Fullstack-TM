import java.util.Arrays;

public class Task1 {
    public static int[] copyAlternativeElements(int[] arr) {
        int[] result = new int[(arr.length + 1) / 2];
        for (int i = 0, j = 0; i < arr.length; i += 2, j++) {
            result[j] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] newArray = copyAlternativeElements(array);
        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Alternative Elements Copied: " + Arrays.toString(newArray));
    }
}
