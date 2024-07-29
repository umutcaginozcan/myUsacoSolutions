// package myUsacoSolutions.USACO.usaco2023open;
import java.util.Scanner;

public class RotateAndShift {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of cows
        int K = in.nextInt(); // Number of active spots
        int T = in.nextInt(); // Time

        int[] activeSpots = new int[K]; // Indices where cows shift their positions circularly
        for (int i = 0; i < K; i++) {
            activeSpots[i] = in.nextInt();
        }

        int[] cows = new int[N]; // Initialize cows' positions
        int[] initialCows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = i;
            initialCows[i] = i;
        }

        int period = 0;
        // Perform T shifts
        for (int i = 0; i < T; i++) {
            // Perform the rotation among the active spots
            int temp = cows[activeSpots[K - 1]]; // Temporarily store the last active cow's position
            for (int j = K - 1; j > 0; j--) {
                cows[activeSpots[j]] = cows[activeSpots[j - 1]]; // Shift each cow to the next spot
            }
            cows[activeSpots[0]] = temp; // Place the last active cow's position into the first spot

            for (int j = 0; j < K; j++) {
                activeSpots[j] = (activeSpots[j] + 1) % N;
            }

            boolean equal = true;
            for (int j = 0; j < N; j++) {
                if (initialCows[j] != cows[j]) {
                    equal = false;
                    break;
                }
            }

            if (equal) {
                T = T % period;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            System.out.print(cows[i] + " ");
        }
        System.out.print(cows[N - 1]);
    }
}