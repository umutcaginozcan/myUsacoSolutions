import java.util.Scanner;

public class ReverseEngineering {
    static String[] input = new String[100];
    static char[] out = new char[100];
    static int N, M;
    static boolean[] done = new boolean[100];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        while (T > 0) {
            T--;
            N = in.nextInt();
            M = in.nextInt();

            for (int i = 0; i < M; i++) {
                input[i] = in.next();
                out[i] = in.next().charAt(0);
                done[i] = false;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    go(j, 0, 0);
                    go(j, 0, 1);
                    go(j, 1, 0);
                    go(j, 1, 1);
                }
            }

            String res = "OK";
            char temp = 'x';
            for (int i = 0; i < M; i++) {
                if (done[i]) continue;
                if (temp == 'x') temp = out[i];
                else if (out[i] != temp) {
                    res = "LIE";
                    break;
                } 
            }

            System.out.println(res);
        }
    }

    public static void go(int j, int in, int out) {
        // TODO ...
    }
}
