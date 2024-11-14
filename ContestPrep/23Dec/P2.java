import java.util.ArrayList;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] cows = new int[N];

        // Compute max possible age of our system. t(max)
        // For that, I need to know which group of 1s limit t(max)
        ArrayList<Integer> sizes = new ArrayList<>();
        int leftmostsize = 0;
        if (cows[0] == 1) {
            for (int i = 0; i < N; i++) {
                if (cows[i] == 0)
                    break;
                if (cows[i] == 1) 
                    leftmostsize++;
            }
            sizes.add(leftmostsize);
        }
        
        int rightmostsize = 0;
        if (cows[cows.length - 1] == 1) {
            for (int i = N - 1; i >= 0; i--) {
                if (cows[i] == 0)
                    break;
                if (cows[i] == 1) 
                    rightmostsize++;
            }
        }

        int cursize = 0;
        int minsize = Integer.MAX_VALUE;
        for (int i = leftmostsize; i < N - rightmostsize; i++) {
            if (cows[i] == 1) {
                int j;
                for (j = i; j < N - rightmostsize; j++) {
                    if (cows[j] == 0)
                        break;
                    if (cows[j] == 1) 
                        cursize++;
                }
                sizes.add(cursize);
                minsize = Math.min(minsize, cursize);
                cursize = 0;
                i = j;
            }
        }
        sizes.add(rightmostsize);

    }
}
