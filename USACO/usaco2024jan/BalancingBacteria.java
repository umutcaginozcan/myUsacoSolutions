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

        long ans = 0;
        for (int i = 0; i < N; i++)  {
            ans += Math.abs(numbers[i]);
            for (int j = i + 1; j < N; j++) {
                if (numbers[i] > 0) {
                    numbers[j] -= (j - i + 1) * Math.abs(numbers[i]);
                } else {
                    numbers[j] += (j - i + 1) * Math.abs(numbers[i]);
                }
            }
        }

        System.out.println(ans);
    }
}

// 2
// -1 3