import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class speedingTicket {
    public static void main(String[] args) throws IOException {
        // Initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        int maxExceeded = 0;

        // Read the first line of inputs.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Create road and Bettie's pattern.
        int[] road = new int[100];
        int roadTracker = 0;
        int[] bettieRoad = new int[100];
        int bettieTracker = 0;

        // Actual Pattern
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int miles = Integer.parseInt(st.nextToken());
            int speedLimit = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= miles; j++) {
                road[roadTracker] = speedLimit;
                roadTracker++;
            }
        }

        // Bettie's Pattern
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int miles = Integer.parseInt(st.nextToken());
            int bettieSpeed = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= miles; j++) {
                bettieRoad[bettieTracker] = bettieSpeed;
                bettieTracker++;
            }
        }

        // Compare both arrays to find the maximum exceeded speed.
        for (int i = 0; i < 100; i++) {
            if (bettieRoad[i] > road[i]) {
                int exceeded = bettieRoad[i] - road[i];
                if (exceeded > maxExceeded) {
                    maxExceeded = exceeded;
                }
            }
        }


        pw.println(maxExceeded);
        pw.close();
    }
}