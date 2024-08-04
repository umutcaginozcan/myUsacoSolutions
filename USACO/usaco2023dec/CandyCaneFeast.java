// package myUsacoSolutions.USACO.usaco2023dec;

import java.util.Scanner;

public class CandyCaneFeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of cows
        int M = in.nextInt(); // Number of canes

        long[] cowHeights = new long[N];
        for (int i = 0; i < N; i++) {
            cowHeights[i] = in.nextInt();
        }

        long[][] caneHeights = new long[M][2];
        for (int i = 0; i < M; i++) {
            caneHeights[i][0] = 0; // Lower height bound
            caneHeights[i][1] = in.nextInt(); // Upper height bound
        }

        outerloop:
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (cowHeights[j] < caneHeights[i][0]) continue; // Jth cow can not reach
                long temp = cowHeights[j];
                cowHeights[j] += Math.min(cowHeights[j] - caneHeights[i][0], caneHeights[i][1] - caneHeights[i][0]);
                caneHeights[i][0] = Math.min(temp, caneHeights[i][1]); 

                if (caneHeights[i][0] == caneHeights[i][1]) continue outerloop;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(cowHeights[i]);
        }
    }
}
