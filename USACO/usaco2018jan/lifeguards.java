import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] starts = new int[N];
        int[] ends = new int[N];
        int[] times = new int[1000];

        int count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            starts[i] = Integer.parseInt(st.nextToken());
            ends[i] = Integer.parseInt(st.nextToken());
            for (int j = starts[i]; j < ends[i]; j++) {
                times[j]++;
                if (times[j] == 1) {
                    count++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            int temp = count;
            for (int j = starts[i]; j < ends[i]; j++) {
                times[j]--;
                if (times[j] == 0) {
                    temp--;
                }
            }
            result = Math.max(result, temp);
            for (int j = starts[i]; j < ends[i]; j++) {
                times[j]++;
            }
        }

        pw.println(result);
        pw.close();
    }    
}
