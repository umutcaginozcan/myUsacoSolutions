import java.util.*;
import java.io.*;
 
public class WatchingMooloo {
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(tokenizer.nextToken());
		long K = Long.parseLong(tokenizer.nextToken());
 
		long[] days = new long[N];
		tokenizer = new StringTokenizer(in.readLine());
 
		for (int i = 0; i < N; i++) {
			days[i] = Long.parseLong(tokenizer.nextToken());
		}
 
		long ans = K+1;
 
		for (int i = 1; i < N; i++) {
			ans += Math.min(K+1, days[i] - days[i-1]);
		}
 
		System.out.println(ans);
	}
}