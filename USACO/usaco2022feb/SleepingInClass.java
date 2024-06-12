import java.io.IOException;
import java.util.Scanner;

public class SleepingInClass {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        while (T > 0) {
            T--;

            int N = in.nextInt();
            int[] nums = new int[N];
            int maxVal = 0, sum = 0;
            for (int i = 0; i < N; i++) {
                nums[i] = in.nextInt();
                maxVal = Math.max(maxVal, nums[i]);
                sum += nums[i];
            }

            int result = -1;
            if (maxVal == 0) {
                result = 0;
            } else {
                for (int i = maxVal; i <= sum; i++) {
                    if (sum % i != 0) continue;
    
                    int count = 0, sum2 = 0;
                    boolean ok = true;
                    for (int j = 0; j < N; j++) {
                        sum2 += nums[j];
    
                        if (sum2 > i) {
                            ok = false;
                            break;
                        } 
                        if (sum2 == i) {
                            sum2 = 0;
                        } else {
                            count++;
                        }
                    }
    
                    if (ok) {
                        result = count;
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
