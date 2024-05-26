import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class whyDidTheCowCrossTheRoad {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        // N: Observations
        // 1 <= ID <= 10
        // 0 or 1. The side of the road

        // Read N
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // Read cows and their locations.
        int[] cows = new int[N];
        int[] locations = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
            locations[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (cows[i] == cows[j] && locations[i] != locations[j]) {
                    answer++;
                    break;
                } else if (cows[i] == cows[j]) break;
            }
        }

        pw.println(answer);
        pw.close();
    }
}

// 8
// 3 1
// 3 0
// 6 0
// 2 1
// 4 1
// 3 0
// 4 0
// 3 1
