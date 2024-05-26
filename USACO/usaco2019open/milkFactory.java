// package usaco2019open;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milkFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] from = new int[N + 1];
        int[] to = new int[N + 1];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            from[i] = Integer.parseInt(st.nextToken());
            to[i] = Integer.parseInt(st.nextToken());
        }

        int result = -1; // Default solution when no single sink is found.
        for (int y = 1; y <= N; y++) {
            int count = 0;
            for (int x = 1; x <= N; x++) {
                if (x == y) {
                    continue;
                }
                int[] steps = new int[N + 1]; // +1 to handle the 1-based index
                steps[x] = 1; // Mark starting point

                for (int i = 1; i < N; i++) {
                    for (int ii = 1; ii <= N; ii++) {
                        if (steps[ii] == i) {
                            for (int iii = 1; iii < N; iii++) {
                                if (from[iii] == ii) {
                                    steps[to[iii]] = i + 1;
                                }
                            }
                        }
                    }
                }
                if (steps[y] > 0) {
                    count++;
                }
            }
            if (count == N - 1) {
                result = y; // Set result to y if y can be reached from N-1 other nodes
                break;
            }
        }

        pw.println(result);
        pw.close(); // Properly close the PrintWriter
    }
}
