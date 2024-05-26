import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class theBucketList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blist.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blist.out")));

        int N = Integer.parseInt(br.readLine());
        int[] buckets = new int[1002];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            buckets[s] += b;
            buckets[t + 1] -= b;
        }

        // *** PREFIX SUM ***
        int result = 0;
        for (int i = 1; i <= 1000; i++) {
            buckets[i] += buckets[i - 1];
            result = Math.max(buckets[i], result);
        }

        pw.println(result);
        pw.close();
    }
}

// SAMPLE INPUT:

// 3
// 4 10 1
// 8 13 3
// 2 6 2

// SAMPLE OUTPUT:

// 4