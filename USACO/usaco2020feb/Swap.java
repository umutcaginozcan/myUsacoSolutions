import java.io.*;
import java.util.*;

public class Swap {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("swap.in"));
		StringTokenizer st = new StringTokenizer(read.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(read.readLine());
		int a1 = Integer.parseInt(st.nextToken()) - 1;
		int a2 = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(read.readLine());
		int b1 = Integer.parseInt(st.nextToken()) - 1;
		int b2 = Integer.parseInt(st.nextToken()) - 1;
		read.close();

		List<Integer> cows = new ArrayList<>();
		List<Integer> initialCows = new ArrayList<>();
		for (int c = 1; c <= n; c++) { 
			cows.add(c); 
			initialCows.add(c);
		}

		int step = 0;
		while (true) {
			reverseSegment(cows, a1, a2);
			reverseSegment(cows, b1, b2);
			step++;
			if (initialCows.equals(cows)) { 
				break; 
			}
		}

		int swapsLeft = k % step;
		for (int s = 0; s < swapsLeft; s++) {
			reverseSegment(cows, a1, a2);
			reverseSegment(cows, b1, b2);
		}

		PrintWriter written = new PrintWriter("swap.out");
		for (int c : cows) { written.println(c); }
		written.close();
	}

	static <T> void reverseSegment(List<T> lst, int start, int end) {
		while (start < end) {
			T temp = lst.get(start);
			lst.set(start, lst.get(end));
			lst.set(end, temp);

			start++;
			end--;
		}
	}
}