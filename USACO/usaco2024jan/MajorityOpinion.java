// package myUsacoSolutions.USACO.usaco2024jan;

import java.util.Scanner;

public class MajorityOpinion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            
            int N = in.nextInt();
            int[] cows = new int[N];
            for (int i = 0; i < N; i++) {
                cows[i] = in.nextInt();
            }

            if (cows.length == 1) {
                System.out.println(cows[0]);
                continue;
            } 
            if (cows.length == 2) {
                if (cows[0] == cows[1]) {
                    System.out.println(cows[0]);
                } else {
                    System.out.println(-1);
                }
                continue;
            }

            int[] result = new int[N];
            int indexToBeMarked = -1;
            for (int i = 0; i < N - 2; i++) {
                if (cows[i] == cows[i + 1]) indexToBeMarked = cows[i];
                if (cows[i] == cows[i + 2]) indexToBeMarked = cows[i];
                if (cows[i + 1] == cows[i + 2]) indexToBeMarked = cows[i + 1];

                if (indexToBeMarked < 0) continue;
                result[indexToBeMarked - 1] = 1;
            }
            if (indexToBeMarked < 0) {
                System.out.println(-1);
                continue;
            }

            int last = -1;
            for (int i = N - 1; i >= 0; i--) {
                if (result[i] > 0) {
                    last = i;
                    break;
                }
            }

            for (int i = 0; i < N; i++) {
                if (result[i] > 0) {
                    System.out.print(i + 1);
                    if (i != last) System.out.print(" ");
                    if (i == last) System.out.println();
                }
            }
        }
    }
}
