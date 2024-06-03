import java.io.*;
import java.util.StringTokenizer;

public class StuckInARut {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        int N = Integer.parseInt(br.readLine()); // Number of cows
        
        // Store inputs
        char[] directions = new char[N];
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            directions[i] = st.nextToken().charAt(0);
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        int[] results = new int[N];
        boolean[] stopped = new boolean[N];
        
        // Initialize results
        for (int i = 0; i < N; i++) {
            results[i] = Integer.MAX_VALUE;
        }

        // Determine stop conditions
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                
                if (directions[i] == 'N' && directions[j] == 'E' && x[i] > x[j] && y[i] < y[j]) {
                    // Cow i (north) crosses path of cow j (east)
                    int ti = y[j] - y[i]; // Time for north-facing cow i to reach y-coordinate of j
                    int tj = x[i] - x[j]; // Time for east-facing cow j to reach x-coordinate of i
                    if (ti < tj && (tj < results[j])) {
                        results[j] = tj;
                        stopped[j] = true;
                    } else if (tj < ti && (ti < results[i])) {
                        results[i] = ti;
                        stopped[i] = true;
                    }
                }
            }
        }

        // Output results
        for (int i = 0; i < N; i++) {
            if (!stopped[i] || results[i] == Integer.MAX_VALUE) {
                pw.println("Infinity");
            } else {
                pw.println(results[i]);
            }
        }
        pw.close();
    }
}
