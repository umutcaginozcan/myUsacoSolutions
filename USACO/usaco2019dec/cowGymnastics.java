// package usaco2019dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class cowGymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // Number of practice sessions.
        int N = Integer.parseInt(st.nextToken()); // Number of cows.

        int[][] sessions = new int[K][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sessions[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int pairCount = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                boolean consistent = true;
                for (int y = 0; y < K; y++) {
                    int indexOfI = -1;
                    int indexOfJ = -1;
                    for (int x = 0; x < N; x++) {
                        if (sessions[y][x] == i) {
                            indexOfI = x;
                        }
                        if (sessions[y][x] == j) {
                            indexOfJ = x;
                        }
                    }
                    if (indexOfI > indexOfJ) { // Cow j ranks better than cow i in this session
                        consistent = false;
                        break;
                    }
                }
                if (consistent) {
                    pairCount++;
                }
            }
        }

        pw.println(pairCount);
        pw.close();
    }
}
