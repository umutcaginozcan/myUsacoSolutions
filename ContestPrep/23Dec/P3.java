import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long T = in.nextLong(); // Test cases as long
        while (T-- > 0) {
            long N = in.nextLong(); // Number of competitors as long
            long[][] matrix = new long[3][(int) N]; // Create matrix with long values, size N casted back to int for array index
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextLong(); // Input values as long
                }
            }

            // Create an array of column indices
            Integer[] indices = new Integer[(int) N]; // Size of indices array is casted back to int
            for (int i = 0; i < N; i++) {
                indices[i] = i;
            }

            // Sort the indices array based on values in the third row of the matrix
            Arrays.sort(indices, (i1, i2) -> Long.compare(matrix[2][i1], matrix[2][i2]));

            // Variables for calculations
            long tmin = 0;
            boolean impossible = false;

            for (int i = 0; i < N - 1; i++) {
                long curHeightDif = matrix[0][indices[i + 1]] - matrix[0][indices[i]]; // Corrected indices usage with long
                long curSpeedDif = matrix[1][indices[i]] - matrix[1][indices[i + 1]]; // Corrected indices usage with long

                if (curHeightDif < 0 && curSpeedDif < 0) continue;
                
                // Check for impossible conditions
                if (curHeightDif >= 0 && curSpeedDif <= 0) {
                    System.out.println(-1);
                    impossible = true;
                    break;
                }

                if (curSpeedDif != 0) {
                    long curt = curHeightDif / curSpeedDif + 1;
                    tmin = Math.max(tmin, curt);
                }
            }

            // Check if our calculations hold true at time tmin
            if (!impossible) {
                for (int i = 0; i < N - 1; i++) {
                    long c1Height = tmin * matrix[1][indices[i]] + matrix[0][indices[i]];
                    long c2Height = tmin * matrix[1][indices[i + 1]] + matrix[0][indices[i + 1]];

                    if (c1Height <= c2Height) {
                        System.out.println(-1);
                        impossible = true;
                        break;
                    }
                }

                if (!impossible) {
                    System.out.println(tmin);
                }
            }
        }
        in.close();
    }
}
