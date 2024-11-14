import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        long[] cows = new long[N];
        for (int i = 0; i < N; i++) {
            cows[i] = in.nextInt();
        }

        long[][] candies = new long[M][2];
        for (int i = 0; i < M; i++) {
            candies[i][1] = in.nextInt();
        }

        // Simulate for each candy:
        for (int i = 0; i < M; i++) {
            // Iterate each cow
            for (int j = 0; j < N; j++) {
                // If cow is taller than candy:
                if (cows[j] > candies[i][0]) {
                    long amount = Math.min(cows[j] - candies[i][0], candies[i][1] - candies[i][0]);
                    candies[i][0] += amount; // Update lower bound of the candy
                    cows[j] += amount;
                    if ( candies[i][1] == candies[i][0]) break;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(cows[i]);
        }
    }
}