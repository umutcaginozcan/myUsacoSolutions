import java.io.*;
import java.util.*;
import java.awt.Rectangle;

public class blockedBillboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        // Ensure width and height are positive
        Rectangle lawnmower = new Rectangle(x1, y1, x2 - x1, y2 - y1);

        st = new StringTokenizer(br.readLine());
        int xx1 = Integer.parseInt(st.nextToken());
        int yy1 = Integer.parseInt(st.nextToken());
        int xx2 = Integer.parseInt(st.nextToken());
        int yy2 = Integer.parseInt(st.nextToken());
        // Ensure width and height are positive
        Rectangle cowFeed = new Rectangle(xx1, yy1, xx2 - xx1, yy2 - yy1);

        Rectangle intersection = lawnmower.intersection(cowFeed);
        

        int result = lawnmower.width * lawnmower.height;
        if (intersection.height == lawnmower.height || intersection.width == lawnmower.width) {
            result -= intersection.width * intersection.height;
        } 
        if (!cowFeed.contains(x1, y1) && !cowFeed.contains(x2, y1) && !cowFeed.contains(x2, y2) && !cowFeed.contains(x1, y2)){
            result = lawnmower.width * lawnmower.height;
        }

        pw.println(result);
        pw.close();
    }
}
