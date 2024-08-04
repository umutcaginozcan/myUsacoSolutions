import java.util.Arrays;
import java.util.Scanner;

public class FarmerJohnActuallyFarms {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        while (--T >= 0) {
            int N = in.nextInt(); // Number of Plants
            long[][] plantTable = new long[3][N];
            
            // Read first row: Initial heights of plants
            for (int i = 0; i < N; i++) {
                plantTable[0][i] = in.nextInt();
            }

            // Read second row: How much plants grow?
            for (int i = 0; i < N; i++) {
                plantTable[1][i] = in.nextInt();
            }

            // Read third row: FJ's array
            for (int i = 0; i < N; i++) {
                plantTable[2][i] = in.nextInt();
            }

            if (plantTable[0].length == 1) {
                System.out.println(0);
                continue;
            }

            transposeAndSort(plantTable);
            boolean alreadySorted = true;
            for (int i = 0; i < N - 1; i++) {
                if (plantTable[0][i] <= plantTable[0][i + 1]) alreadySorted = false;
            }
            if (alreadySorted) {
                System.out.println(0);
                continue;
            }
            
            // Check pairs. Compare 0 with 1 for example.
            long ans = 0;
            for (int i = 0; i < N - 1; i++) {
                // Calculate height difference:
                long heightDifference = plantTable[0][i + 1] - plantTable[0][i];
                // Calculate their difference in growing
                long growingDifference = plantTable[1][i] - plantTable[1][i + 1];

                // CHECK BUGS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                if (heightDifference >= 0 && growingDifference <= 0) {
                    ans = -1;
                    break;
                }
                if (heightDifference < 0 && growingDifference <= 0) continue;

                long days = (heightDifference / growingDifference) + 1;
                ans = Math.max(ans, days);
            }

            for (int i = 0; i < N; i++) {
                plantTable[0][i] += ans * plantTable[1][i];
            }

            for (int i = 0; i < N - 1; i++) {
                if (plantTable[0][i] <= plantTable[0][i + 1]) ans = -1;
            }
            System.out.println(ans);
        }
    }

    public static void transposeAndSort(long[][] table) {
        // Transpose the matrix to easily sort by columns
        long[][] transposed = new long[table[0].length][table.length];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                transposed[j][i] = table[i][j];
            }
        }

        // Sorting the transposed matrix based on what was originally the third row
        Arrays.sort(transposed, (a, b) -> Long.compare(a[2], b[2]));

        // Transposing back to the original form
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[0].length; j++) {
                table[i][j] = transposed[j][i];
            }
        }
    }
}