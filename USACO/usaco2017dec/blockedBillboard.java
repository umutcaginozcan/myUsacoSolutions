import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class blockedBillboard {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
		
		//first billboard
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		
		//second billboard
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		
		//truck
		st = new StringTokenizer(br.readLine());
		int x5 = Integer.parseInt(st.nextToken());
		int y5 = Integer.parseInt(st.nextToken());
		int x6 = Integer.parseInt(st.nextToken());
		int y6 = Integer.parseInt(st.nextToken());
		
		// the visible area is the sum of the visible area of the first billboard and the second billboard
		int combinedArea = visibleArea(x1, y1, x2, y2, x5, y5, x6, y6) + visibleArea(x3, y3, x4, y4, x5, y5, x6, y6);
		
		// print the answer
		pw.println(combinedArea);
		pw.close();
	}

	public static int areaOfRectangle(int x1, int y1, int x2, int y2) {
		return (x2-x1)*(y2-y1);
	}
	
	public static int visibleArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		// start by computing the area that would be visible if there were no second rectangle
		int visibleArea = areaOfRectangle(x1, y1, x2, y2);
		
		// compute the boundaries of the intersection
		int leftmostBlockedX = Math.max(x1, x3);
		int rightmostBlockedX = Math.min(x2, x4);
		int bottommostBlockedY = Math.max(y1, y3);
		int topmostBlockedY = Math.min(y2, y4);
		// if the second rectangle does exist, subtract out the area that it blocks
		if(leftmostBlockedX < rightmostBlockedX && bottommostBlockedY < topmostBlockedY) {
			visibleArea -= areaOfRectangle(leftmostBlockedX, bottommostBlockedY, rightmostBlockedX, topmostBlockedY);
		}
		
		return visibleArea;
	}
}
