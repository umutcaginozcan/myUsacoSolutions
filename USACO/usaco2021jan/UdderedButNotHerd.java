// package usaco2021jan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UdderedButNotHerd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        // Read the inputs
        String cowphabet = br.readLine();
        String fj = br.readLine();

        // Locate the characters.
        int[] charPositions = new int[fj.length()];
        for (int i = 0; i < fj.length(); i++) {
            for (int j = 0; j < cowphabet.length(); j++) {
                if (fj.charAt(i) == cowphabet.charAt(j)) {
                    charPositions[i] = j;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < charPositions.length; i++) {
            if (i < charPositions.length - 1 && charPositions[i] >= charPositions[i + 1]) {
                result++;
            }
        }
        result++;

        pw.println(result);
        pw.close();
    }
}
