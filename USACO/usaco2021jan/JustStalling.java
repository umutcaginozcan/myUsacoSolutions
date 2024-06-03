import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JustStalling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long[] cowHeights = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cowHeights[i] = Long.parseLong(st.nextToken());
        }

        long[] stallHeights = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stallHeights[i] = Long.parseLong(st.nextToken());
        }

        // How many options does cow[i] have?
        long[] stallOptions = new long[N];
        for (int i = 0; i < cowHeights.length; i++) {
            for (int j = 0; j < stallHeights.length; j++) {
                if (cowHeights[i] <= stallHeights[j]) {
                    stallOptions[i]++;
                }
            }
        }

        Arrays.sort(stallOptions);
        long result = 1;
        for (int i = 0; i < stallOptions.length; i++) {
            result *= stallOptions[i];
            if (i < stallOptions.length - 1) {
                stallOptions[i + 1] -= i + 1;
            }
        }

        pw.println(result);
        pw.close();
    }
}
