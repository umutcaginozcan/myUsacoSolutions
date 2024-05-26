import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class teleportation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int teleportation1 = Integer.parseInt(st.nextToken());
        int teleportation2 = Integer.parseInt(st.nextToken());

        // Case 1: Do not use teleportation.
        int distanceNonTeleportation = Math.abs(end - start);

        // Case 2: Use teleportation.
        // We need to choose the closest teleportation station.
        int distanceTeleportation = 0;
        if (Math.abs(teleportation1 - start) < Math.abs(teleportation2 - start)) {
            distanceTeleportation += Math.abs(teleportation1 - start);
            distanceTeleportation += Math.abs(teleportation2 - end);
        } else {
            distanceTeleportation += Math.abs(teleportation2 - start);
            distanceTeleportation += Math.abs(teleportation1 - end);
        }

        pw.println(Math.min(distanceNonTeleportation, distanceTeleportation));
        pw.close();
    }
}

// SAMPLE INPUT:
// 3 10 8 2

// OUTPUT: 3