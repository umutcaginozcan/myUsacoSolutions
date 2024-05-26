import java.io.*;
import java.util.*;

public class race {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("race.in"));
		int dist = sc.nextInt();
		int queryNum = sc.nextInt();

		PrintWriter pw = new PrintWriter(new File("race.out"));
		for (int q = 0; q < queryNum; q++) {
			int maxSpeed = sc.nextInt();
			pw.println(fastestTime(dist, maxSpeed));
		}
		pw.close();
	}

	static int fastestTime(int dist, int maxSpeed) {
		int speedUpDist = 0;   // Amount of distance where Bessie's speeding up
		int slowDownDist = 0;  // and slowing down respectively
		int time = 0;

		// Gradually speed up until we achieve our distance
		for (int currSpeed = 1;; currSpeed++) {
			speedUpDist += currSpeed;
			time++;
			if (speedUpDist + slowDownDist >= dist) { return time; }

			/*
			 * If we're above the speed limit, add the current speed
			 * to the part where we slow down as well.
			 */
			if (currSpeed >= maxSpeed) {
				slowDownDist += currSpeed;
				time++;
				// Check again if we've achieved our distance
				if (speedUpDist + slowDownDist >= dist) { return time; }
			}
		}
	}
}