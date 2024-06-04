import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ComfortableCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[1001][1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int column = Integer.parseInt(st.nextToken());
            int row = Integer.parseInt(st.nextToken());
            map[row][column] = 1;
            System.out.println(countComfortables(map));
        }
    }

    public static int countComfortables(int[][] map) {
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0) continue;  // Skip when cell is empty

                // Ensure checks are within array bounds
                int neighborCount = 0;
                if (j > 0 && map[i][j - 1] == 1) neighborCount++;     // Check left
                if (j < map[i].length - 1 && map[i][j + 1] == 1) neighborCount++;  // Check right
                if (i > 0 && map[i - 1][j] == 1) neighborCount++;     // Check above
                if (i < map.length - 1 && map[i + 1][j] == 1) neighborCount++;  // Check below

                if (neighborCount == 3) count++;
            }
        }
        return count;
    }
}
