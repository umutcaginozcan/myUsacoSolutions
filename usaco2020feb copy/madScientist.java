// package usaco2020feb;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * O(n) solution
 */
public class madScientist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String A = br.readLine();
        String B = br.readLine();

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (i < N - 1 && A.charAt(i) != B.charAt(i)) {
                if (A.charAt(i + 1) == B.charAt(i + 1)) {
                    count++;
                } else if (A.charAt(i + 1) != B.charAt(i + 1)) {
                    continue;
                }
            } else if (A.charAt(i) != B.charAt(i)) {
                count++;
            } else {
                continue;
            }
        }

        pw.println(count);
        pw.close();
    }
}
