import java.util.Arrays;

class SortThread extends Thread {
    private int[] arr;

    public SortThread(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        Arrays.sort(arr);
    }

    public int[] getSortedArray() {
        return arr;
    }
}

public class MultiThreadSorting {
    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 1, 4, 7, 2, 6};
        SortThread sortThread = new SortThread(arr);
        sortThread.start();
        
        try {
            sortThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sorted Array: " + Arrays.toString(sortThread.getSortedArray()));
    }
}
