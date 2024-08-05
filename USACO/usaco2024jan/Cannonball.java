// package myUsacoSolutions.USACO.usaco2024jan;

import java.util.Scanner;

public class Cannonball {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int S = in.nextInt();

        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            data[i][0] = in.nextInt();
            data[i][1] = in.nextInt();
        }

        int power = 1, direction = 1;
        int[] visited = new int[N];
        int time = 0;
        
        while (S >= 1 && S <= N && time <= N * Math.log(N)) {
            time += 1;
            if (data[S - 1][0] == 0) {
                power += data[S - 1][1];
                direction *= -1;
            } else {
                if (power >= data[S - 1][1]) {
                    visited[S - 1] = 1;
                }
            }
            S = S + power * direction;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += visited[i];
        }

        System.out.println(ans);
    }
}
