import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class loadBalancing {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int res = N;
        for (int i = 0; i < N; i++) {
            int dx = x[i] + 1;
            for (int j = 0; j < N; j++) {
                int dy = y[j] + 1;

                int A = 0;
                int B = 0;
                int C = 0;
                int D = 0;
                for (int k = 0; k < N; k++) {
                    if (x[k] < dx && y[k] < dy) {
                        A++;
                    } else if (x[k] > dx && y[k] < dy) {
                        B++;
                    } else if (x[k] > dx && y[k] > dy) {
                        C++;
                    } else {
                        D++;
                    }
                }
                res = Math.min(res, Math.max(Math.max(A, B), Math.max(C, D)));
            }
        }

        pw.println(res);
        pw.close();
    }
}
