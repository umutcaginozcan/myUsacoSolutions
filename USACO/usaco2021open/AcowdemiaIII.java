import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class AcowdemiaIII {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] pasture = new char[n + 2][];
        pasture[0] = new char[m + 2];
        Arrays.fill(pasture[0], '.');
        pasture[n + 1] = pasture[0];
        for (int y = 1; y <= n; y++) {
            pasture[y] = ('.' + br.readLine() + '.').toCharArray();
        }
        int answer = 0;
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (pasture[y][x] == 'G' && ((pasture[y][x - 1] == 'C' && pasture[y][x + 1] == 'C') || (pasture[y - 1][x] == 'C' && pasture[y + 1][x] == 'C'))) {
                    pasture[y][x] = '.';
                    answer++;
                }
            }
        }
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                if (pasture[y][x] == 'C') {
                    if (pasture[y + 1][x - 1] == 'C') {
                        if (pasture[y][x - 1] == 'G') {
                            pasture[y][x - 1] = '.';
                            answer++;
                        } else if (pasture[y + 1][x] == 'G') {
                            pasture[y + 1][x] = '.';
                            answer++;
                        }
                    }
                    if (pasture[y + 1][x + 1] == 'C') {
                        if (pasture[y][x + 1] == 'G') {
                            pasture[y][x + 1] = '.';
                            answer++;
                        } else if (pasture[y + 1][x] == 'G') {
                            pasture[y + 1][x] = '.';
                            answer++;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}