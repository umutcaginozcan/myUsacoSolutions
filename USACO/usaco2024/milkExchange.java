import java.util.Scanner;

public class milkExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int N = scanner.nextInt(); // Number of cows
        int M = scanner.nextInt(); // Maximum milk loss allowed
        scanner.nextLine(); // Consume the newline after reading integer
        
        String S = scanner.nextLine(); // Directions of cows
        
        long[] a = new long[N]; // Milk production of each cow
        long ans = 0;
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextLong();
            ans += a[i];
        }
        
        // Identify bad left and right cows
        boolean[] badL = new boolean[N];
        boolean[] badR = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'R' && S.charAt((i + 1) % N) == 'L') {
                badL[i] = true;
                badR[(i + 1) % N] = true;
            }
        }
        
        // Calculate milk loss due to bad cows
        for (int i = 0; i < N; i++) {
            long sum = 0;
            if (badL[i]) {
                int j = (i - 1 + N) % N;
                while (S.charAt(j) == 'R') {
                    sum += a[j];
                    j--;
                    if (j < 0) j += N;
                }
            }
            if (badR[i]) {
                int j = (i + 1) % N;
                while (S.charAt(j) == 'L') {
                    sum += a[j];
                    j++;
                    if (j >= N) j -= N;
                }
            }
            ans -= Math.min(sum, M);
        }
        
        System.out.println(ans);
        
        scanner.close();
    }
}
