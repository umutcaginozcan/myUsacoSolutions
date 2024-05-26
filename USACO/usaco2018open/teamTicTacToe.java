import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class teamTicTacToe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                grid[i][j] = st.nextToken();
            }
        }

        int aloneWins = 0;
        int teamWins = 0;
        int charCount;

        // COW
        // XXO
        // ABC

        // Vertical
        for (int i = 0; i < N; i++) {
            charCount = 1;

            if (grid[0][i] != grid[1][i]) {
                charCount++;
                if (grid[2][i] != grid[1][i] && grid[2][i] != grid[0][i]) {
                    charCount++;
                }
            }

            if (charCount == 1) {
                aloneWins++;
            } else if (charCount == 2) {
                teamWins++;
            }
        }

        // Horizontal
        for (int i = 0; i < N; i++) {
            charCount = 1;

            if (grid[i][0] != grid[i][0]) {
                charCount++;
                if (grid[i][2] != grid[i][1] && grid[i][2] != grid[i][0]) {
                    charCount++;
                }
            }

            if (charCount == 1) {
                aloneWins++;
            } else if (charCount == 2) {
                teamWins++;
            }
        }

        // Diagonal 1
        charCount = 1;
        if (grid[0][0] != grid[1][1]) {
            charCount++;
            if (grid[2][2] != grid[1][1] && grid[2][2] != grid[0][0]) {
                charCount++;
            }
        }

        if (charCount == 1) {
            aloneWins++;
        } else if (charCount == 2) {
            teamWins++;
        }

        // Diagonal 2
        charCount = 1;
        if (grid[0][2] != grid[1][1]) {
            charCount++;
            if (grid[2][0] != grid[1][1] && grid[2][0] != grid[0][2]) {
                charCount++;
            }
        }

        if (charCount == 1) {
            aloneWins++;
        } else if (charCount == 2) {
            teamWins++;
        }

        pw.println(aloneWins);
        pw.println(teamWins);
        pw.close();
    }
}
