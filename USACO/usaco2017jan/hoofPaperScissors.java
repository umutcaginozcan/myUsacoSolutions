import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hoofPaperScissors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));

        // Read N.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] firstCow = new int[N];
        int[] secondCow = new int[N];
        // Play N Games. Store data.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            firstCow[i] = Integer.parseInt(st.nextToken());
            secondCow[i] = Integer.parseInt(st.nextToken());
        }

        // All possibilities:
        int winCount1 = 0; 
        int winCount2 = 0;
        for (int i = 0; i < N; i++) {
            // If 1 beats 2, 2 beats 3.
            if (firstCow[i] == 1 && secondCow[i] == 2 || firstCow[i] == 2 && secondCow[i] == 3 || firstCow[i] == 3 && secondCow[i] == 1) {
                winCount1++;
            }
            // If 1 beats 3, 2 beats 1.
            if (firstCow[i] == 1 && secondCow[i] == 3 || firstCow[i] == 2 && secondCow[i] == 1 || firstCow[i] == 3 && secondCow[i] == 2) {
                winCount2++;
            }
        }

        pw.println(Math.max(winCount1, winCount2));
        pw.close();
    }
}
