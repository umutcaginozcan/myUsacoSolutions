package usaco2024;

import java.util.Arrays;
import java.util.Scanner;

public class maximizingProductivity {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();

        int[] closing = new int[N];
        for (int i = 0; i < N; i++) {
            closing[i] = in.nextInt();
        }

        final int SIZE = 10;
        int[] S = new int[SIZE];
        for (int i = 0; i < N; i++) {
            int t = in.nextInt();
            int x = closing[i] - t - 1;
            if (x > 0) {
                S[x]++;
            }
        }

        for (int i = SIZE - 2; i >= 0; i--) {
            S[i] += S[i + 1];
        }

        while (Q > 0) {
            Q--;
            int v = in.nextInt();
            int s = in.nextInt();
            System.out.println(S[s] >= v ? "YES" : "NO");
        }
    }
}

/*
SAMPLE INPUT:

5 5
3 5 7 9 12               3 5 7 9 12
4 2 3 3 8
1 5                      9 7 8 8 13         0 0 0 1 0   YES
1 6                     10 8 9 9 14         0 0 0 0 0   NO
3 3                      7 5 6 6 11         0 0 1 1 1   YES
4 2                      6 4 5 5 10         0 1 1 1 1   YES
5 1                      5 3 4 4 9          0 1 1 1 1   NO
SAMPLE OUTPUT:

YES
NO
YES
YES
NO 

3 5 7 9 12
4 2 3 3 8

-2 2 3 5 3 
0 1 2 3 4 5 6 7 8 9 10   i
4 4 4 3 1 1 0 0 0 0 0    S[i]

1 5   YES          
1 6   NO                  
3 3   YES                  
4 2   YES                   
5 1   NO                

*/