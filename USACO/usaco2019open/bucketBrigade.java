
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class bucketBrigade {
    public static void main(String[] args) {
        // Using try-with-resources to ensure all resources are closed properly
        try (BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")))) {

            int barnI = 0, barnJ = 0, rockI = 0, rockJ = 0, lakeI = 0, lakeJ = 0;
            for (int i = 0; i < 10; i++) {
                String row = br.readLine(); // Read each row of the farm
                for (int j = 0; j < 10; j++) {
                    char location = row.charAt(j);
                    if (location == 'B') {
                        barnI = i;
                        barnJ = j;
                    } else if (location == 'R') {
                        rockI = i;
                        rockJ = j;
                    } else if (location == 'L') {
                        lakeI = i;
                        lakeJ = j;
                    }
                }
            }

            // Calculate the minimal number of moves
            int moves = Math.abs(barnI - lakeI) + Math.abs(barnJ - lakeJ) - 1;

            // Check if there's a rock in line between barn and lake
            if ((barnI == rockI && rockI == lakeI && ((lakeJ < rockJ && rockJ < barnJ) || (barnJ < rockJ && rockJ < lakeJ))) ||
                (barnJ == rockJ && rockJ == lakeJ && ((lakeI < rockI && rockI < barnI) || (barnI < rockI && rockI < lakeI)))) {
                moves += 2;
            }

            pw.println(moves); // Output the result
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
