import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class circularBarn {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] rooms = new int[n];
        int distance;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            rooms[i] = Integer.parseInt(st.nextToken());
        }

        // Brute Force.
        for (int i = 0; i < n; i++) {
            distance = 0;
            int entryRoom = i;
            
            for (int j = 0; j < n; j++) {
                // Case Work.
                if (j >= entryRoom) {
                    distance += (j - entryRoom) * rooms[j];
                } else {
                    distance += (rooms.length - entryRoom + j) * rooms[j];
                }
            }
            if (distance < minDistance) minDistance = distance;
        }

        pw.println(minDistance);
        pw.close();
    }
}