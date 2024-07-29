package myUsacoSolutions.USACO.usaco2023feb;

import java.util.Scanner;

public class StampGrid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        String[] results = new String[T];
        int counter = 0;
        while (T > 0) {
            int N = in.nextInt();
            in.nextLine();  // Consume the newline after reading N
            char[][] grid = new char[N][N];
            for (int i = 0; i < N; i++) {
                grid[i] = in.nextLine().toCharArray();
            }

            int K = in.nextInt();
            in.nextLine();  // Consume the newline after reading K
            char[][] stamp = new char[K][K];
            for (int i = 0; i < K; i++) {
                stamp[i] = in.nextLine().toCharArray();
            }

            // Rotate the stamp 3 times
            for (int k = 1; k <= 3; k++) {
                outerloop:
                for (int i = 0; i < K; i++) {
                    for (int j = 0; j < K; j++) {
                        if (stamp[i][j] == '.') continue outerloop;
                        stamp[j][K - 1 - i] = stamp[i][j];
                    }
                }
            }

            boolean ans = true;
            // Check if stamp can paint the grid fully
            // The spots where we can place our stamp:
            for (int i = 0; i <= N - K; i++) {
                for (int j = 0; j <= N - K; j++) {
                    // Traverse through our stamp
                    for (int ii = 0; ii < K; ii++) {
                        for (int jj = 0; jj < K; jj++) {
                            if (grid[i + ii][j + jj] == '.' && stamp[ii][jj] == '*') {
                                grid[i + ii][j + jj] = '*';
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // Traverse through our stamp
                    if (grid[i][j] == '.') {
                        ans = false;
                    }
                }
            }

            if (ans) {
                results[counter] = "YES";
            } else {
                results[counter] = "NO";
            }
            T--;
            counter++;
        }

        for (int i = 0; i < results.length; i++) {
            System.out.println(results[i]);
        }
    }
}
