import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class fieldReduction {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] x = new int[N];
        int[] y = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < N; i++) {
            minX = Math.min(x[i], minX);
            minY = Math.min(y[i], minY);
            maxX = Math.max(x[i], maxX);
            maxY = Math.max(y[i], maxY);
        }

        for (int i = 0; i < N; i++) {
            if (x[i] == minX || x[i] == maxX ||y[i] == minY || y[i] == maxY) {
                int x1 = Integer.MAX_VALUE;
                int x2 = 0;
                int y1 = Integer.MAX_VALUE;
                int y2 = 0;

                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        x1 = Math.min(x1, x[j]);
                        x2 = Math.max(x2, x[j]);
                        y1 = Math.min(y1, y[j]);
                        y2 = Math.max(y2, y[j]);
                    }
                }
                int tempArea = (x2 - x1) * (y2 - y1);
                result = Math.min(result, tempArea);
            }
        }

        pw.println(result);
        pw.close();
    }
}
    