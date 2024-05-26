import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class measuringTraffic {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));

        // N: number of segments
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        // Ramps: on-off-none
        // Flow: [lower, upper]
        String[] ramps = new String[N];
        int[] lowerFlow = new int[N];
        int[] upperFlow = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ramps[i] = st.nextToken();
            lowerFlow[i] = Integer.parseInt(st.nextToken());
            upperFlow[i] = Integer.parseInt(st.nextToken());
        }

        int lowerBound = 0;
        int upperBound = (int) 1e9;
        for (int i = N - 1; i >= 0; i--) {
            if (ramps[i].equals("on")) {
                lowerBound -= upperFlow[i];
                upperBound -= lowerFlow[i];
                lowerBound = Math.max(0, lowerBound);
            } else if (ramps[i].equals("none")) {
                lowerBound = Math.max(lowerBound, lowerFlow[i]);
				upperBound = Math.min(upperBound, upperFlow[i]);
            } else if (ramps[i].equals("off")) {
                lowerBound += lowerFlow[i];
                upperBound += upperFlow[i];
            }
        }
        pw.println(lowerBound + " " + upperBound);

        lowerBound = 0;
        upperBound = (int) 1e9;
        for (int i = 0; i < N; i++) {
            if (ramps[i].equals("on")) {
                lowerBound += lowerFlow[i];
                upperBound += upperFlow[i];
            } else if (ramps[i].equals("none")) {
                lowerBound = Math.max(lowerBound, lowerFlow[i]);
				upperBound = Math.min(upperBound, upperFlow[i]);
            } else if (ramps[i].equals("off")) {
                lowerBound -= upperFlow[i];
                upperBound -= lowerFlow[i];
                lowerBound = Math.max(0, lowerBound);
            }
        }
        pw.println(lowerBound + " " + upperBound);
        pw.close();
    }
}

// SAMPLE INPUT:

// 3
// on 3 7
// none 5 5
// off 3 7


// SAMPLE OUTPUT:
// 10 13
// 8 12