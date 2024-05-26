import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class modernArt {
    static final int MAX_N = 10;
    static int N;
    static int[][] B = new int[MAX_N][MAX_N];

    /**
     * Find if the color exist in the grid.
     * @param c
     * @return
     */
    static boolean colorAppears(int c) {
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                if (B[i][j] == c) return true;
            }
        }
        return false;
    }

    /**
     * Find if c1 is on top of c2.
     * @param c1
     * @param c2
     * @return
     */
    static boolean onTopOf(int c1, int c2) {
        int top = N, bottom = 0, left = N, right = 0;
        
        // Borders of c2.
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i].length; j++) {
                if (B[i][j] == c2) {
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }

        // Compare c1 with borders of c2.
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (B[i][j] == c1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("art.in"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));
        N = Integer.parseInt(fin.readLine());
        for (int i = 0; i < N; i++) {
            String s = fin.readLine();
            // Fill the B[][] array.
            for (int j = 0; j < s.length(); j++) {
                B[i][j] = s.charAt(j) - '0';
            }
        }

        int answer = 0;
        // Compare the collors.
        for (int i = 1; i <= 9; i++) {
            if (colorAppears(i)) {
                boolean couldBeFirst = true;
                for (int j = 1; j <= 9; j++) {
                    if (i != j && colorAppears(j) && onTopOf(i, j)) {
                        couldBeFirst = false;
                    }
                }
                if (couldBeFirst) answer++;
            }
        }

        fout.println(answer);
        fout.close();
    }
}
