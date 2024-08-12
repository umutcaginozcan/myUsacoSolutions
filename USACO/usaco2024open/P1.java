import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int Q = in.nextInt();
        in.nextLine(); // To consume the newline after Q
        String[] statement = (in.nextLine() + " or false").split(" ");

        int[] start = new int[N];
        int[] end = new int[N];
        int minimum = Integer.MAX_VALUE;
        int maximum = 0;
        int last_false = -1;
        int interval_start = 0;

        // Process the statements
        for (int i = 0; i <= N; i++) {
            if (last_false == -1 && i < N) {
                start[i] = 1;
            }
            if (statement[i].equals("false")) {
                last_false = i;
            }
            if (statement[i].equals("or")) {
                if (last_false == -1) {
                    minimum = Math.min(i - 1, minimum);
                    maximum = Math.max(interval_start, maximum);
                }
                for (int j = Math.max(interval_start, last_false); j < i; j++) {
                    end[j] = 1;
                }
                last_false = -1;
                interval_start = i + 1;
            }
        }

        // Process the queries
        for (int q = 0; q < Q; q++) {
            int l = in.nextInt() - 1;
            int r = in.nextInt() - 1;
            String goal = in.next();

            // Case 1: goal is true
            if (goal.equals("true") && (start[l] == 1 && end[r] == 1 || l > minimum || r < maximum)) {
                System.out.print("Y");
            } else if (goal.equals("false") && l <= minimum && r >= maximum) {
                // Case 2: goal is false
                System.out.print("Y");
            } else {
                System.out.print("N");
            }
        }
        in.close();
    }
}
