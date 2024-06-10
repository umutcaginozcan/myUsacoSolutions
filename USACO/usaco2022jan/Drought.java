import java.util.*;

public class Drought {
    
    public static long execute(Scanner scanner) {
        long ans = 0;
        int n = scanner.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        if (n == 1) return 0;
        
        for (int j = 0; j < 2; j++) {
            for (int i = 1; i < n - 1; i++) {
                if (h[i] > h[i - 1]) {
                    int dif = h[i] - h[i - 1];
                    ans += 2 * dif;
                    h[i + 1] -= dif;
                    h[i] = h[i - 1];
                }
            }
            if (h[n - 1] > h[n - 2]) return -1;
            reverseArray(h);
        }
        
        return h[0] < 0 ? -1 : ans;
    }
    
    private static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            System.out.println(execute(scanner));
        }
        scanner.close();
    }
}
