import java.io.*;
import java.util.*;

public class wordProcessor {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new FileReader("word.in"));
		StringTokenizer initial = new StringTokenizer(read.readLine());
		initial.nextToken();  // we won't need N
		int maxWidth = Integer.parseInt(initial.nextToken());

		String[] essay = read.readLine().split(" ");
		StringBuilder formatted = new StringBuilder();
		int rnLength = 0;
		for (String w : essay) {
			if (rnLength + w.length() > maxWidth) {
				formatted.deleteCharAt(formatted.length() - 1);
				formatted.append('\n');
				rnLength = 0;
			}
			formatted.append(w).append(' ');
			rnLength += w.length();
		}
		formatted.deleteCharAt(formatted.length() - 1);

		PrintWriter written = new PrintWriter("word.out");
		written.println(formatted);
		written.close();
	}
}