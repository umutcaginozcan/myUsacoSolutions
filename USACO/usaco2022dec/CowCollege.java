import java.util.Arrays;
import java.util.Scanner;

public class CowCollege {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        long[] tuitions = new long[N];
        for (int i = 0; i < N; i++) {
            tuitions[i] = in.nextLong();
        }

        Arrays.sort(tuitions);
        
        long prevTuition = -1;
        long minTuition = Long.MAX_VALUE;
        long maxTotalMoney = 0;
        for (int i = 0; i < N; i++) {
            if (prevTuition == tuitions[i]) continue;
            
            long totalMoney = 0;
            totalMoney += (N - i) * tuitions[i];
            if (totalMoney > maxTotalMoney) {
                maxTotalMoney = totalMoney;
                minTuition = tuitions[i];
            }

            prevTuition = tuitions[i];
        }

        System.out.println(maxTotalMoney + " " + minTuition);
    }
}
