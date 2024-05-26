import java.io.*;
import java.util.*;

public class cowntactTracing {
    static boolean[] cowEndsInfected;
    static int n;
    static int maxT = 250;
    static int maxN = 100;
    static int[] cowX = new int[maxT + 1];
    static int[] cowY = new int[maxT + 1];

    // this function simulates handshakes over time to see if data agrees
    // with this choice of patient_zero and K
    static boolean consistentWithData(int patientZero, int k) {
        boolean[] infected = new boolean[maxN + 1];
        int[] numHandshakes = new int[maxN + 1];

        infected[patientZero] = true;

        for (int t = 0; t <= maxT; t++) {
            int x = cowX[t];
            int y = cowY[t];

            if (x > 0) {
                if (infected[x]) { numHandshakes[x]++; }
                if (infected[y]) { numHandshakes[y]++; }
                if (numHandshakes[x] <= k && infected[x]) {
                    infected[y] = true;
                }
                if (numHandshakes[y] <= k && infected[y]) {
                    infected[x] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (infected[i] != cowEndsInfected[i]) { return false; }
        }

        return true;  // return true at the end
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tracing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // Number of cows
        int T = Integer.parseInt(st.nextToken()); // Number of handshakes
        String s = br.readLine();  // Next line contains the initial infection statuses

        cowEndsInfected = new boolean[n + 1];

        for (int x = 1; x <= n; x++) {
            cowEndsInfected[x] = (s.charAt(x - 1) == '1');  // marks infected cows as true
        }

        for (int i = 0; i < T; i++) {  // read input and store into array
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            cowX[t] = Integer.parseInt(st.nextToken());
            cowY[t] = Integer.parseInt(st.nextToken());
        }

        boolean[] possibleI = new boolean[maxN + 1];
        boolean[] possibleK = new boolean[maxT + 2];

        for (int i = 1; i <= n; i++) {  // loop through each pair
            for (int k = 0; k <= 251; k++) {
                if (consistentWithData(i, k)) {
                    possibleI[i] = true;
                    possibleK[k] = true;
                }
            }
        }

        int lowerK = maxT + 1;
        int upperK = 0;
        int numPatientZero = 0;

        for (int k = 0; k <= maxT + 1; k++) {
            if (possibleK[k]) { upperK = k; }
        }

        for (int k = maxT + 1; k >= 0; k--) {
            if (possibleK[k]) { lowerK = k; }
        }

        for (int i = 0; i <= n; i++) {  // count number of patient zeros
            if (possibleI[i]) { numPatientZero++; }
        }

        pw.print(numPatientZero + " " + lowerK + " ");  // possible patient zeros, minimum of K
        if (upperK == maxT + 1) {
            pw.println("Infinity");  // infinity if K = T is possible
        } else {
            pw.println(upperK);
        }

        br.close();
        pw.close();
    }
}
