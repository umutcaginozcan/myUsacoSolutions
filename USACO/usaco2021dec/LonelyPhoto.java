import java.util.Scanner;

public class LonelyPhoto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            long left = 0;
            if (i > 0 && s.charAt(i - 1) != s.charAt(i)) {
                left++;
                for (int k = i - 2; k >= 0 && s.charAt(k) == s.charAt(i - 1); k--) left++;
            }
            long right = 0;
            if (i + 1 < n && s.charAt(i + 1) != s.charAt(i)) {
                right++;
                for (int k = i + 2; k < n && s.charAt(k) == s.charAt(i + 1); k++) right++;
            }
            ans += left * right + Math.max(left - 1, 0) + Math.max(right - 1, 0);
        }

        System.out.println(ans);
        scanner.close();
    }
}
