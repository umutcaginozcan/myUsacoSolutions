import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * milkMixing
 */
public class milkMixing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

        int[] totalCapacities = new int[3];
        int[] currentMilk = new int[3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            totalCapacities[i] = Integer.parseInt(st.nextToken());
            currentMilk[i] = Integer.parseInt(st.nextToken());
        }

        // 100 Pour Operations.
        for (int i = 1; i <= 33; i++) {
            for (int j = 0; j < 3; j++) {
                int amount = Math.min(currentMilk[j], (totalCapacities[(j + 1) % 3] - currentMilk[(j + 1) % 3]));
                currentMilk[j] -= amount;
                currentMilk[(j + 1) % 3] += amount; 
            }
        }
        int amount = Math.min(currentMilk[0], (totalCapacities[1] - currentMilk[1]));
        currentMilk[0] -= amount;
        currentMilk[1] += amount;

        for (int k = 0; k < 3; k++) {
            pw.println((currentMilk[k]));
        }
        pw.close();
    }
}

// Initial State: 3  4  5
// 1. Pour 1->2:  0  7  5
// 2. Pour 2->3:  0  0  12
// 3. Pour 3->1:  10 0  2
// 4. Pour 1->2:  0  10 2
// 5. Pour 2->3:  0  0  12