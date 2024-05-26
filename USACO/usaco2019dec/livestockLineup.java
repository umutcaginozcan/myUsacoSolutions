import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class livestockLineup {
    public static void main(String[] args) throws IOException {
        final int M = 8;
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));

        ArrayList<String> cows = new ArrayList<>(Arrays.asList("Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue"));
        Collections.sort(cows);
        int[] count = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<String> A = new ArrayList<>();
        ArrayList<String> B = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine(); // For ex. "Buttercup must be milked beside Bella"
            A.add(str.split(" ")[0]); // "Buttercup"
            B.add(str.split(" ")[5]); // "Bella"

            String cowName = A.get(i);
            int idx = cows.indexOf(cowName);
            count[idx]++;

            cowName = B.get(i);
            idx = cows.indexOf(cowName);
            count[idx]++;
        }

        ArrayList<String> result = new ArrayList<>();
        boolean[] visited = new boolean[M];
        for (int i = 0; i < M; i++) {
            String cowName = cows.get(i);
            /* pw.println(cowName);
            pw.println(count[2]);
            pw.println(visited[2]); */

            if (count[i] > 1 || visited[i]) {
                continue;
            }
            result.add(cowName);
            visited[i] = true;
            
            if (count[i] == 1) {
                count[i]--;
                int idx = A.indexOf(cowName);
                
                if (idx >= 0) {
                    String cowName2 = B.get(idx);
                    idx = cows.indexOf(cowName2);
                    if (!visited[idx]) {
                        result.add(cowName2);
                        count[idx]--;
                        visited[idx] = true;
                    }
                } else {
                    idx = B.indexOf(cowName);
                    String cowName2 = A.get(idx);
                    idx = cows.indexOf(cowName2);
                    if (!visited[idx]) {
                        result.add(cowName2);
                        count[idx]--;
                        visited[idx] = true;
                    }
                }
            }
        }
        
        for (int i = 0; i < result.size(); i++) {
            pw.println(result.get(i));
        }
        pw.close();
    }
}
