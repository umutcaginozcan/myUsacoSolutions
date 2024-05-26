package usaco2015;
import java.io.*;
import java.util.*;
public class fencePainting2015Dec {
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		BufferedReader br = new BufferedReader(new FileReader("paint.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        
		// read in the first line, store a and b
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());

		// read in the second line, store c and d
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());

        int res = -1;
		if ((x1 > x4) || (x3 > x2)) { // No overlap
            res = (x2 - x1) + (x4 - x3);
        } else { // Overlapping segments
            res = Math.max(x4, x2) - Math.min(x1, x3);
        }

		// print the answer!
		pw.println(res);

		// close output stream
		pw.close();
	}
}