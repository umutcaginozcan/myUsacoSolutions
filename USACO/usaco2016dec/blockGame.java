import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class blockGame {
    public static void main(String[] args) throws IOException {
        // Initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] blocksNeeded = new int[26]; // Only one array needed for final counts

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String firstWord = st.nextToken();
            String secondWord = st.nextToken();

            int[] firstWordCounts = new int[26];
            int[] secondWordCounts = new int[26];

            // Count frequency of each letter in the first word
            for (int j = 0; j < firstWord.length(); j++) {
                firstWordCounts[firstWord.charAt(j) - 'a']++;
            }

            // Count frequency of each letter in the second word
            for (int j = 0; j < secondWord.length(); j++) {
                secondWordCounts[secondWord.charAt(j) - 'a']++;
            }

            // Update blocksNeeded with the maximum count for each letter from both words
            for (int j = 0; j < 26; j++) {
                blocksNeeded[j] += Math.max(firstWordCounts[j], secondWordCounts[j]);
            }
        }

        // Write the result to the output file
        for (int i = 0; i < 26; i++) {
            pw.println(blocksNeeded[i]);
        }

        pw.close();
    }
}
