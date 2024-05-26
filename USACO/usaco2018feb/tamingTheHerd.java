import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class tamingTheHerd {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("taming.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] records = new int[N];
        for (int i = 0; i < N; i++) {
            records[i] = Integer.parseInt(st.nextToken());
        }

        if (records[0] > 0) {
            pw.println(-1);
            pw.close();
            return;
        }

        records[0] = 0;
        int expectedValue = -1;
        int minimumBreakouts = 0;
        int unresolvedEntries = 0;

        for (int i = N - 1; i >= 0; i--) {
            if (expectedValue != -1 && records[i] != -1 && records[i] != expectedValue) {
                System.out.println(-1);
                pw.println(-1);
                pw.close();
            }

            if (expectedValue == -1) {
                expectedValue = records[i];
            }

            if (records[i] == -1) {
                records[i] = expectedValue;
            }

            if (records[i] == 0) {
                minimumBreakouts++;
            }

            if (records[i] == -1) {
                unresolvedEntries++;
            }

            if (expectedValue > -1) {
                expectedValue--;
            }
        }

        pw.println(minimumBreakouts + " " + (minimumBreakouts + unresolvedEntries));
        pw.close();
    }
}

