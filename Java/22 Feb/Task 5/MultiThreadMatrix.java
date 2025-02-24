class MatrixMultiplication extends Thread {
    private int[][] A, B, C;
    private int row, col, size;

    public MatrixMultiplication(int[][] A, int[][] B, int[][] C, int row, int col, int size) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
        this.col = col;
        this.size = size;
    }

    public void run() {
        for (int i = 0; i < size; i++) {
            C[row][col] += A[row][i] * B[i][col];
        }
    }
}

public class MultiThreadMatrix {
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};
        int[][] C = new int[2][2];

        Thread[][] threads = new Thread[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                threads[i][j] = new MatrixMultiplication(A, B, C, i, j, 2);
                threads[i][j].start();
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                try {
                    threads[i][j].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int[] row : C) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
