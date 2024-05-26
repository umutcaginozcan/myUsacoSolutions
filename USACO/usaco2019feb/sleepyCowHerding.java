import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sleepyCowHerding {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));

        // Read the input: 3 cow positions.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pos1 = Integer.parseInt(st.nextToken());
        int pos2 = Integer.parseInt(st.nextToken());
        int pos3 = Integer.parseInt(st.nextToken());

        // Print min then max.
        if (pos2 - pos1 == 1 && pos3 - pos2 == 1) {
            pw.println(0);

        } else {
            pw.println(Math.min(pos2 - pos1, pos3 - pos2) == 2 ? 1 : 2);
        }
        pw.println(Math.max(pos2 - pos1, pos3 - pos2) - 1);
        pw.close();
    }
}

// SAMPLE INPUT:

// 7 8 9 
// SAMPLE OUTPUT:

// 0
// 0