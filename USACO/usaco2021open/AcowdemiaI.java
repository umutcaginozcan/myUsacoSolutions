package myUsacoSolutions.USACO.usaco2021open;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AcowdemiaI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // Paper count.
        int L = Integer.parseInt(st.nextToken()); // Citation count.

        st = new StringTokenizer(br.readLine());
        int[] papers = new int[N];
        for (int i = 0; i < N; i++) {
            papers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(papers);
        pw.flush();  // Ensure the buffer is flushed and the message is printed

        int hIndex = 0;
        boolean[] isCited = new boolean[N];
        for (int i = N - 1; i >= 0; i--) {
            hIndex++;
            if (hIndex <= papers[i]) continue;
            if (L == 0) {
                pw.println(--hIndex);
                pw.close();
                return;
            }
            L--;
            papers[i]++;
            isCited[i] = true;
            if (hIndex > papers[i]) {
                pw.println(--hIndex);
                pw.close();
                return;
            }
            for (int j = i + 1; j < N; j++) {  // Changed condition to j < N
                if (papers[j] >= hIndex) continue;
                if (L == 0) {
                    pw.println(--hIndex);
                    pw.close();
                    return;
                }
                else if (hIndex > papers[j] && isCited[j]) {
                    pw.println(--hIndex);
                    pw.close();
                    return;
                }
                L--;
                papers[j]++;
                isCited[j] = true;
                if (papers[j] >= hIndex) continue;
                pw.println(--hIndex);
                pw.close();
                return;
            }
        }

        pw.print(hIndex);
        pw.close();  // Ensure to close the PrintWriter to flush and close the stream
    }
}
