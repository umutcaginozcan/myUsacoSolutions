import java.util.Scanner;

public class WalkingHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] g = new String[n];
        for (int i = 0; i < n; i++) {
            g[i] = sc.next();
        }
        int ret = 0;
        if (k >= 1) {
            boolean urcorner = true;
            boolean dlcorner = true;
            for (int i = 0; i < n; i++) {
                if (g[0].charAt(i) == 'H' || g[i].charAt(n - 1) == 'H') urcorner = false;
                if (g[i].charAt(0) == 'H' || g[n - 1].charAt(i) == 'H') dlcorner = false;
            }
            ret += urcorner ? 1 : 0;
            ret += dlcorner ? 1 : 0;
        }
        if (k >= 2) {
            // use column j
            for (int j = 1; j < n - 1; j++) {
                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    if (g[i].charAt(j) == 'H') valid = false;
                    if (i < j && g[0].charAt(i) == 'H') valid = false;
                    if (i > j && g[n - 1].charAt(i) == 'H') valid = false;
                }
                ret += valid ? 1 : 0;
            }
            // use row i
            for (int i = 1; i < n - 1; i++) {
                boolean valid = true;
                for (int j = 0; j < n; j++) {
                    if (g[i].charAt(j) == 'H') valid = false;
                    if (j < i && g[j].charAt(0) == 'H') valid = false;
                    if (j > i && g[j].charAt(n - 1) == 'H') valid = false;
                }
                ret += valid ? 1 : 0;
            }
        }
        if (k >= 3) {
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    // RDRD
                    boolean valid = g[i].charAt(j) == '.';
                    for (int a = 0; a < n; a++) {
                        if (a <= i && g[a].charAt(j) == 'H') valid = false;
                        if (a >= i && g[a].charAt(n - 1) == 'H') valid = false;
                        if (a <= j && g[0].charAt(a) == 'H') valid = false;
                        if (a >= j && g[i].charAt(a) == 'H') valid = false;
                    }
                    ret += valid ? 1 : 0;
                    valid = g[i].charAt(j) == '.';
                    // DRDR
                    for (int a = 0; a < n; a++) {
                        if (a <= i && g[a].charAt(0) == 'H') valid = false;
                        if (a >= i && g[a].charAt(j) == 'H') valid = false;
                        if (a <= j && g[i].charAt(a) == 'H') valid = false;
                        if (a >= j && g[n - 1].charAt(a) == 'H') valid = false;
                    }
                    ret += valid ? 1 : 0;
                }
            }
        }
        System.out.println(ret);
    }
}
