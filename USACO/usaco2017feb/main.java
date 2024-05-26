import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
        
        int N = Integer.parseInt(br.readLine());
        final int MAX = 101000000;
        boolean[] times = new boolean[MAX];
        int res = 0;

        while (N > 0) {
            N--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // Arrival time
            int b = Integer.parseInt(st.nextToken()); // Interrogation time

            int i = 0;
            int count = 0;
            while (count < b) {
                if(!times[a + i]) {
                    times[a + i] = true;
                    count++;
                    res = Math.max(res, a + i + 1);
                }
                i++;
            }
        }

        pw.println(res);
        pw.close();
    }
}
