// package myUsacoSolutions.USACO.usaco2024jan;

import java.util.Scanner;

public class BalancingBacteria {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        long[] numbers = new long[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = in.nextLong();
        }

        long increase = 0, decrease = 0, adjustment = 0;
        for (int i = 0; i < N; i++)  {
            numbers[i] += adjustment;
            if (numbers[i] < 0) {
                increase -= numbers[i];
            } else {
                decrease += numbers[i];
            }
            adjustment = adjustment + increase - decrease - numbers[i];
        }

        System.out.println(increase + decrease);
    }
}

// 2
// -1 3