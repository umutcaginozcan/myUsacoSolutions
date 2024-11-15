import java.util.Arrays;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); 
        while (T-- > 0) {
            int N = in.nextInt(); 
            int[][] matrix = new int[3][N]; 
            for (int i = 0; i < 3; i++) { 
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = in.nextInt(); // 1st row: height, 2: speed, 3: final placement
                }
            }

            // Create an array of column indices
            Integer[] indices = new Integer[N];
            for (int i = 0; i < N; i++) {
                indices[i] = i;
            }

            // Sort the indices array based on values in the third row of the matrix
            Arrays.sort(indices, (i1, i2) -> Integer.compare(matrix[2][i1], matrix[2][i2]));

            
        }
        
    }
}
