import java.io.*;
import java.util.*;

public class SocialDistancing2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("socdist2.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));

        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, Comparator.comparingInt(a -> a[0]));

        int range = Integer.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            if (cows[i][1] != cows[i - 1][1]) {
                range = Math.min(range, cows[i][0] - cows[i - 1][0] - 1);
            }
        }

        // Handle the case when no range is found (i.e., all cows are sick or healthy)
        if (range == Integer.MAX_VALUE) {
            range = 0;
        }

        int count = 0; 
        boolean inCluster = false;
        for (int i = 0; i < N; i++) {
            if (cows[i][1] == 1) { // Check for sick cow
                if (!inCluster) {
                    count++;
                    inCluster = true;
                } else if (i > 0 && cows[i][0] - cows[i - 1][0] > range) {
                    count++;
                }
            } else {
                inCluster = false; // End of current sick cow cluster
            }
        }

        pw.println(count);
        pw.close();
        br.close();
    }
}
