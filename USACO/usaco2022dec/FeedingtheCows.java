import java.util.Scanner;

public class FeedingtheCows {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T > 0) {
            T--;
            int N = in.nextInt();
            int K = in.nextInt();

            String str = in.next();
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < N; i++) res.append('.');

            int lastG = - (K + 1), lastH = - (K + 1);
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (str.charAt(i) == 'G' && Math.abs(i - lastG) > K) {
                    int x = Math.min(i + K, N - 1);
                    if (res.charAt(x) != '.') x--;
                    res.setCharAt(x, 'G');
                    count++;
                    lastG = x;
                } 
                if (str.charAt(i) == 'H' && Math.abs(i - lastH) > K) {
                    int x = Math.min(i + K, N - 1);
                    if (res.charAt(x) != '.') x--;
                    res.setCharAt(x, 'H');
                    count++;
                    lastG = x;
                }
            }

            System.out.println(count);
            System.out.println(res);
        }
    }
}
