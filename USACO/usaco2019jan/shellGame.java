import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shellGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] shells = new int[4];
        shells[1] = 1;
        shells[2] = 2;
        shells[3] = 3;

        int find1 = 0;
        int find2 = 0;
        int find3 = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // for ex: swap 1 and 3
            int b = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            int temp = shells[a];
            shells[a] = shells[b];
            shells[b] = temp;

            if (shells[g] == 1) {
                find1++;
            } else if (shells[g] == 2) {
                find2++;
            } else if (shells[g] == 3) {
                find3++;
            }
        }

        pw.println(Math.max(Math.max(find1, find2), find3));
        pw.close();
    }
}
