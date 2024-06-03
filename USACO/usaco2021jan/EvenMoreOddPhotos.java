import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EvenMoreOddPhotos {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int evenCount = 0, oddCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int ID = Integer.parseInt(st.nextToken());
            if (ID % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Loop until no numbers left
        int result = 0;
        while (true) {
            if (result % 2 == 0) {
                // Even group
                // First place an even number if you have it.
                if (evenCount > 0) {
                    evenCount--;
                    result++;
                } else if (oddCount > 1) {
                    // Place two odd numbers otherwise.
                    oddCount = oddCount - 2;
                    result++;
                } else { 
                    if (oddCount == 0 && evenCount == 0) {
                        break;
                    }
                    result--;
                    break;
                }
            } else {
                // Odd group
                // First place an even number if you have it.
                if (oddCount > 0) {
                    oddCount--;
                    result++;
                } else {
                    break;
                }
            }
        }

        pw.println(result);
        pw.close();
    }
}
