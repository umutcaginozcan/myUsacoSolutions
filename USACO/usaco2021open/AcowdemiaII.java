import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
 
public class AcowdemiaII {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int k = Integer.parseInt(tokenizer.nextToken());
        int n = Integer.parseInt(tokenizer.nextToken());
        Map<String, Integer> members = new HashMap<>();
        tokenizer = new StringTokenizer(in.readLine());
        for (int a = 0; a < n; a++) {
            members.put(tokenizer.nextToken(), a);
        }
        char[][] answer = new char[n][n];
        for (int a = 0; a < n; a++) {
            Arrays.fill(answer[a], '?');
            answer[a][a] = 'B';
        }
        for (int j = 0; j < k; j++) {
            tokenizer = new StringTokenizer(in.readLine());
            String[] publication = new String[n];
            for (int x = 0; x < n; x++) {
                publication[x] = tokenizer.nextToken();
            }
            for (int x = 0; x < n; x++) {
                boolean alphabetical = true;
                for (int y = x + 1; y < n; y++) {
                    if (publication[y - 1].compareTo(publication[y]) > 0) {
                        alphabetical = false;
                    }
                    if (!alphabetical) {
                        int a = members.get(publication[x]);
                        int b = members.get(publication[y]);
                        answer[a][b] = '0';
                        answer[b][a] = '1';
                    }
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int a = 0; a < n; a++) {
            out.append(answer[a]).append('\n');
        }
        System.out.print(out);
    }
}