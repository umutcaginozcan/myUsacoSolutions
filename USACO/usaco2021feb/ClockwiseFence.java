import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ClockwiseFence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String fence = br.readLine();
            isClockWise(fence);
        }
    }

    /**
     * Calculates if given string is clockwise or not. Calculate two consequtive points' angles. i.e. N-W will be -90, N-E will be 90.
     * If total sum is 360, string is clockwise.
     */
    public static void isClockWise(String fence) {
        int angle = 0;
        int i = 0;
        for (i = 0; i < fence.length(); i++) {
            if ((fence.charAt(i) == 'N' && fence.charAt((i + 1) % fence.length()) == 'E') || (fence.charAt(i) == 'E' && fence.charAt((i + 1) % fence.length()) == 'S') || 
            (fence.charAt(i) == 'S' && fence.charAt((i + 1) % fence.length()) == 'W') || (fence.charAt(i) == 'W' && fence.charAt((i + 1) % fence.length()) == 'N')) angle += 90;
            
            else if ((fence.charAt(i) == 'N' && fence.charAt((i + 1) % fence.length()) == 'W') || (fence.charAt(i) == 'W' && fence.charAt((i + 1) % fence.length()) == 'S') || 
            (fence.charAt(i) == 'S' && fence.charAt((i + 1) % fence.length()) == 'E') || (fence.charAt(i) == 'E' && fence.charAt((i + 1) % fence.length()) == 'N')) angle -= 90;
        }

        if (angle == 360) System.out.println("CW");
        else if (angle == -360) System.out.println("CCW");
    }
}
