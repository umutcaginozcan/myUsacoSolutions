import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class outOfPlace {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // Read the inputs.
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // Find Wrong Position - Bessie's index.
        int currentPos = -1;
        for (int i = 1; i < N; i++) {
            if (heights[i] < heights[i - 1]) {
                currentPos = i;
            } 
        }

        // Find Bessie's Original Position
        int initialPos = -1;
        int equalCount = 0;
        for (int i = 0; i < N; i++) {
            if (heights[i] > heights[currentPos] || equalCount == 1) {
                initialPos = i;
                break;
            } else if (heights[i] == heights[currentPos]) {
                equalCount++;
            }
        }

        // How many different heights between the positions?
        int count = 1;
        if (currentPos > initialPos) {
            for (int i = initialPos + 1; i < currentPos; i++) {
                if (heights[i] != heights[i - 1]) count++;
            }
        } else {
            for (int i = currentPos + 1; i < initialPos; i++) {
                if (heights[i] != heights[i - 1]) count++;
            }
        }

        pw.println(count);
		pw.close();
    }
}

// 20
// 12176
// 12176
// 77332
// 77332
// 89409
// 219681
// 219681
// 219681
// 641974   CURRENT
// 322749
// 335453
// 358690
// 378611
// 426076
// 507349
// 593080
// 641974   INITIAL
// 681596
// 681596
// 681596

// 2
// 4
// 7
// 7
// 9
// 3    CURRENT