// package myUsacoSolutions.USACO.usaco2023dec;

import java.util.ArrayList;
import java.util.Scanner;

public class CowntactTracing2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // N cows
        String cows = in.next();

        // Calculate intervals.
        ArrayList<Integer> intervals = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (cows.charAt(i) == '0' && count > 0) {
                intervals.add(count);
                count = 0;
            } else if (cows.charAt(i) == '1') {
                count++;
            }
        }
        if (count > 0) intervals.add(count);

        if (intervals.size() == 0) {
            System.out.println(0);
            return;
        }

        // (DEALING WITH EDGE CASES) Calculate max days passed
        int L = intervals.size();
        boolean leftZero = cows.charAt(0) == '0';
        boolean rightZero = cows.charAt(N - 1) == '0';
        int maxDays = Math.min(intervals.get(0), intervals.get(L - 1)) - 1;
        if (leftZero) {
            maxDays = Math.min(maxDays, (intervals.get(0) - 1) / 2);
        }
        if (rightZero) {
            maxDays = Math.min(maxDays, (intervals.get(L - 1) - 1) / 2);
        }

        // The intervals which are in the middle.
        for (int i = 1; i < L - 1; i++) {
            maxDays = Math.min(maxDays, (intervals.get(i) - 1) / 2);
        }

        count = 0;
        for (int i = 0; i < L; i++) {
            count += intervals.get(i) / (2 * maxDays + 1);
            if (intervals.get(i) % (2 * maxDays + 1) != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
