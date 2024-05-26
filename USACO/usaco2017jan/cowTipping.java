import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class cowTipping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    toggleMap(map, i, j);
                    count++;
                }
            }
        }

        pw.println(count);
        pw.close();
        br.close();
    }

    private static void toggleMap(int[][] map, int x, int y) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                map[i][j] = map[i][j] == 0 ? 1 : 0;
            }
        }
    }
}
