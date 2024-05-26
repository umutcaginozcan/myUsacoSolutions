import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class bovineGenomics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cownomics.out"));

        // Read N and M
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        char[][] spotty = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            spotty[i] = line.toCharArray();
        }

        char[][] plain = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            plain[i] = line.toCharArray();
        }

        int possibleLocations = 0;
        outerloop:
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (plain[j][i] == spotty[k][i]) {
                        continue outerloop;
                    }
                }
            }
            possibleLocations++;
        }

        pw.println(possibleLocations);
        pw.close();
        br.close();
    }
}
