import java.io.*;
import java.util.*;

public class SocialDistancing {
    // Returns size of largest gap between two 1s and also the index where it starts
    private static int findLargestInteriorGap(String s, int[] gapStart) {
        int biggestGap = 0, currentStart = -1, N = s.length();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '1') {
                if (currentStart != -1 && i - currentStart > biggestGap) {
                    biggestGap = i - currentStart;
                    gapStart[0] = currentStart;
                }
                currentStart = i;
            }
        }
        return biggestGap;
    }

    // Returns size of smallest gap between two 1s
    private static int findSmallestInteriorGap(String s) {
        int smallestGap = Integer.MAX_VALUE, currentStart = -1, N = s.length();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '1') {
                if (currentStart != -1 && i - currentStart < smallestGap) smallestGap = i - currentStart;
                currentStart = i;
            }
        }
        return smallestGap;
    }

    private static int tryCowInLargestGap(String s) {
        int[] gapStart = new int[1];
        int largestGap = findLargestInteriorGap(s, gapStart);
        if (largestGap >= 2) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(gapStart[0] + largestGap / 2, '1');
            return findSmallestInteriorGap(sb.toString());
        }
        return -1; // no gap!
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("socdist1.in"));
        int N = Integer.parseInt(fin.readLine());
        String s = fin.readLine();
        BufferedWriter fout = new BufferedWriter(new FileWriter("socdist1.out"));
        int answer = 0;

        // Possibility 1. put two cows in largest interior gap
        int[] gapStart = new int[1];
        int largestGap = findLargestInteriorGap(s, gapStart);
        if (largestGap >= 3) {
            StringBuilder tempS = new StringBuilder(s);
            tempS.setCharAt(gapStart[0] + largestGap / 3, '1');
            tempS.setCharAt(gapStart[0] + largestGap * 2 / 3, '1');
            answer = Math.max(answer, findSmallestInteriorGap(tempS.toString()));
        }

        // Possibility 2. cows at both ends
        if (s.charAt(0) == '0' && s.charAt(N - 1) == '0') {
            StringBuilder tempS = new StringBuilder(s);
            tempS.setCharAt(0, '1');
            tempS.setCharAt(N - 1, '1');
            answer = Math.max(answer, findSmallestInteriorGap(tempS.toString()));
        }

        // Possibility 3. cow at left + cow in largest interior gap
        if (s.charAt(0) == '0') {
            StringBuilder tempS = new StringBuilder(s);
            tempS.setCharAt(0, '1');
            answer = Math.max(answer, tryCowInLargestGap(tempS.toString()));
        }

        // Possibility 4. cow at right + cow in largest interior gap
        if (s.charAt(N - 1) == '0') {
            StringBuilder tempS = new StringBuilder(s);
            tempS.setCharAt(N - 1, '1');
            answer = Math.max(answer, tryCowInLargestGap(tempS.toString()));
        }

        // Possibility 5. cow at largest interior gap. done twice.
        if (largestGap >= 2) {
            StringBuilder tempS = new StringBuilder(s);
            tempS.setCharAt(gapStart[0] + largestGap / 2, '1');
            answer = Math.max(answer, tryCowInLargestGap(tempS.toString()));
        }

        fout.write(answer + "\n");
        fout.close();
    }
}