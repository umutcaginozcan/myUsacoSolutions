import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class diamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diamondSizes = new int[N];
        int count;
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int diamondSize = Integer.parseInt(st.nextToken());
            diamondSizes[i] = diamondSize;
        }

        for (int i = 0; i < N; i++) {
            count = 0;
            for (int j = 0; j < N; j++) {
                if (diamondSizes[j] <= diamondSizes[i] + K && diamondSizes[j] >= diamondSizes[i]) {
                    count++;
                }
            } 
            if (count > maxCount) maxCount = count;
        }

        pw.println(maxCount);
        pw.close();
    }
}