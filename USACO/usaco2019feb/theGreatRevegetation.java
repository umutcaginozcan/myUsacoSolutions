import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class theGreatRevegetation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));

        // Read the input: 3 cow positions.
        // Read N: Pastures, M: Number of cows.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Store the data (Positions).
        int[][] data = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());

            int temp = data[i][1];
            if (data[i][0] > data[i][1]) {
                data[i][1] = data[i][0];
                data[i][0] = temp;
            }
        }

        int[] result = new int[N]; 
        for (int i = 0; i < N; i++) {
			// g indicates the current color type
			int g;
			// loop iterates through the 4 color types
			for (g = 1; g <= 4; g++) {
				// ok indicates whether the current color type works on the current pasture.
				boolean ok = true;
				// j indicates the current pair of pastures data[j][0 or 1]
				for (int j = 0; j < M; j++) {
					// if higher pasture number in the pair is the current
					// pasture number and the other pasture in the pair is
					// already assigned the current color type this means the
					// current color type won't work on the current pasture, so
					// ok is set to false
					if (data[j][1] == i + 1 && result[data[j][0] - 1] == g) ok = false;
                }
				// if ok is true, we can move on to the next pasture
				// otherwise, we have to try the next color type
				if (ok) break;
			}
			// sets color type to the current pasture
			result[i] = g;
			pw.print(g);
		}
        pw.close();
    }
}

// SAMPLE INPUT:

// 5 6
// 4 1
// 4 2
// 4 3
// 2 5
// 1 2
// 1 5
// SAMPLE OUTPUT:

// 12133


