package myUsacoSolutions.USACO.usaco2023jan;

import java.util.Scanner;

public class Leaders {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String cows = in.nextLine();

        int[] ranges = new int[N];
        for (int i = 0; i < N; i++) {
            ranges[i] = in.nextInt();
        }

        char leftmost = cows.charAt(0);
        int result = 0;
        boolean leftmostALeader = false;
        for (int i = 0; i < cows.length(); i++) {
            if (cows.charAt(i) != leftmost) {
                // That i'th cow must be the leader. So we trace backwards.
                for (int j = i - 1; j >= 0; j--) {
                    if (j == 0 && i + 1 <= ranges[j]) {
                        leftmostALeader = true;
                        result++;
                    } else if (j != 0 && i + 1 <= ranges[j]) {
                        result++;
                    }
                }
                // Leftmost a leader?
                for (int j = cows.length() - 1; j >= 0; j--) {
                    if (cows.charAt(j) == leftmost && j < ranges[0] && (j == 0 && !leftmostALeader)) {
                        result++;
                        System.out.println(result);
                        return;
                    } else if (j == 0 && cows.charAt(j) == leftmost){
                        System.out.println(result);
                        return;
                    }
                }
            }
        }
    }
}
