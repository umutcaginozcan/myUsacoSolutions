import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class squarePasture {
    public static void main(String[] args) throws IOException {
        // Initialize file I/O
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        // Read x1, y1, x2, y2
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        // Read x3, y3, x4, y4
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st2.nextToken());
        int y3 = Integer.parseInt(st2.nextToken());
        int x4 = Integer.parseInt(st2.nextToken());
        int y4 = Integer.parseInt(st2.nextToken());

        // An array for the base to avoid case work.
        int[] base = new int[11];
        int[] height = new int[11];

        // Fill the base array.
        for (int i = 0; i <= 10; i++) {
            if ((x1 <= i && i <= x2) || (x3 <= i && i <= x4)) {
                base[i] = 1; 
            }
        }
        unifyOnes(base);

        // Fill the height array.
        for (int i = 0; i <= 10; i++) {
            if ((y1 <= i && i <= y2) || (y3 <= i && i <= y4)) {
                height[i] = 1; 
            }
        }
        unifyOnes(height);

        // Count the length.
        int baseLength = 0;
        for (int i = 0; i <= 10; i++) {
            if (base[i] == 1) {
                baseLength++;
            }
        }

        int heightLength = 0;
        for (int i = 0; i <= 10; i++) {
            if (height[i] == 1) {
                heightLength++;
            }
        }

        int squareLength = Math.max(baseLength - 1, heightLength - 1);
        pw.println(squareLength * squareLength);
        pw.close();
    }

    public static void unifyOnes(int[] arr) {
        int smallest = Integer.MAX_VALUE;
        int biggest = -Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (i < smallest) smallest = i;
                if (i > biggest) biggest = i;
            }
        }

        for (int i = smallest; i <= biggest; i++) {
            arr[i] = 1;
        }
    }
}
