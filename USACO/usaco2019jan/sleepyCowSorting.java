import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sleepyCowSorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] cows = new int[N];
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }

        int i = N - 1;
        while (i > 0 && cows[i] > cows[i - 1]) {
            i--;
        }

        pw.println(i);
        pw.close();
    }
}

