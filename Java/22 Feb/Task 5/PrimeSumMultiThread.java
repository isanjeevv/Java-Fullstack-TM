class PrimeSumThread extends Thread {
    private int start, end;
    private long sum;

    public PrimeSumThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
    }

    public long getSum() {
        return sum;
    }
}

public class PrimeSumMultiThread {
    public static void main(String[] args) {
        int limit = 100;
        PrimeSumThread thread1 = new PrimeSumThread(1, limit / 2);
        PrimeSumThread thread2 = new PrimeSumThread(limit / 2 + 1, limit);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long totalSum = thread1.getSum() + thread2.getSum();
        System.out.println("Sum of prime numbers up to " + limit + " is: " + totalSum);
    }
}
