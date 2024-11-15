import java.util.ArrayList;
import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();  // Read the number of cows
        in.nextLine();  // Consume the leftover newline character
        int[] cows = new int[N];

        String inp = in.nextLine();  // Read the line of cows' states
        for (int i = 0; i < N; i++) {
            cows[i] = inp.charAt(i) - '0';  // Convert each character to an integer ('1' -> 1, '0' -> 0)
        }

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
        boolean full1 = false;
        if (cows[cows.length - 1] == 1) {
            for (int i = N - 1; i >= 0; i--) {
                if (cows[i] == 0)
                    break;
                if (cows[i] == 1) 
                    rightmostsize++;
                if (i == 0)
                    full1 = true;
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
        if (!full1) sizes.add(rightmostsize);

        // Find t(max)
        int tmax = (minsize % 2 == 0) ? (minsize / 2) - 1 :  (minsize / 2);
        if (leftmostsize != 0) 
            tmax = Math.min(tmax, leftmostsize - 1);
        if (rightmostsize != 0) 
            tmax = Math.min(tmax, rightmostsize - 1);

        // Now we know the max time could have passed since the disease started.
        // Comptute min possible sick count
        int res = 0;
        for (int i = 0; i < sizes.size(); i++) {
            if (sizes.get(i) % (2 * tmax + 1) == 0) 
                res += sizes.get(i) / (2 * tmax + 1);
            else 
                res += sizes.get(i) / (2 * tmax + 1) + 1;
        }

        System.out.print(res);
    }
}
