import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class theLostCow {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        long ans = 0; // Total distance traveled
        long by = 1; // Distance to move in the current step
        long dir = 1; // Direction of movement, 1 for right, -1 for left

        while (true) {
            if ((dir == 1 && x <= y && y <= x + by) || (dir == -1 && x - by <= y && y <= x)) {
                // Found Bessie
                ans += Math.abs(y - x);
                pw.println(ans);
                break;
            } else {
                // Bessie not found in this step, add the distance traveled in this step to the total
                ans += by * 2;
                by *= 2; // Double the distance for the next step
                dir *= -1; // Change direction
            }
        }
        pw.close();
    }
}
