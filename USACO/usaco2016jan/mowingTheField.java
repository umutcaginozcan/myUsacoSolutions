import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class mowingTheField {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));

        int N = Integer.parseInt(br.readLine());

        int[][] field = new int[2001][2001]; // To track the last time each cell was visited
        for (int[] row : field) {
            Arrays.fill(row, -1); // Initialize with -1 since 0 will be a valid time step
        }
        
        int x = 1000, y = 1000; // Starting position
        int time = 0; // Starting time
        field[x][y] = time; // Mark starting position as visited at time 0
        int answer = Integer.MAX_VALUE; // Initialize with max value to find minimum later

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int steps = Integer.parseInt(st.nextToken());

            int dx = 0, dy = 0;
            if (direction.equals("N")) dy = 1;
            else if (direction.equals("S")) dy = -1;
            else if (direction.equals("E")) dx = 1;
            else if (direction.equals("W")) dx = -1;

            for (int j = 0; j < steps; j++) {
                x += dx;
                y += dy;
                time++;
                if (field[x][y] >= 0) { // If visited before
                    answer = Math.min(answer, time - field[x][y]); // Update answer if this revisit is sooner
                }
                field[x][y] = time; // Update last visit time
            }
        }

        // If answer was not updated, set to -1 indicating no square was revisited
        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }

        pw.println(answer);
        pw.close();
        br.close();
    }
}
