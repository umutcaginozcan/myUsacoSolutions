import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class whyDidTheCowCrossTheRoad3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

        // N: Cows in the queue.
        int N = Integer.parseInt(br.readLine());

        int[][] cows = new int[N][2]; // Each cow's data is stored in an array [arrivalTime, interrogationTime]
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken()); // Arrival time
            cows[i][1] = Integer.parseInt(st.nextToken()); // Interrogation time
        }

        // Sort the cows array based on arrival time
        Arrays.sort(cows, (a, b) -> Integer.compare(a[0], b[0]));

        // Now, process the sorted cows to determine the total time
        int currentTime = 0;
        for (int i = 0; i < N; i++) {
            if (currentTime < cows[i][0]) {
                // If the current time is before the next cow's arrival, move the time forward to the cow's arrival
                currentTime = cows[i][0];
            }
            // Add the interrogation time for the current cow
            currentTime += cows[i][1];
        }

        // Write the final current time to the output file
        pw.println(currentTime);
        pw.close();
    }
}
