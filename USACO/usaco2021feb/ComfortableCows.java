import java.util.Scanner;

public class ComfortableCows {
    private static final int MAXN = 1001;
    private static int N;
    private static boolean[][] A = new boolean[MAXN][MAXN];
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static boolean validPosition(int x, int y) {
        return x >= 0 && x <= N && y >= 0 && y <= N;
    }

    private static boolean comfortable(int x, int y) {
        if (!A[x][y]) return false;
        int neighbors = 0;
        for (int d = 0; d < 4; d++) {
            if (validPosition(x + dx[d], y + dy[d]) && A[x + dx[d]][y + dy[d]]) {
                neighbors++;
            }
        }
        return neighbors == 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int nComfortable = 0;

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            for (int d = 0; d < 4; d++) {
                if (validPosition(x + dx[d], y + dy[d])) {
                    nComfortable -= comfortable(x + dx[d], y + dy[d]) ? 1 : 0;
                }
            }
            A[x][y] = true;
            for (int d = 0; d < 4; d++) {
                if (validPosition(x + dx[d], y + dy[d])) {
                    nComfortable += comfortable(x + dx[d], y + dy[d]) ? 1 : 0;
                }
            }
            nComfortable += comfortable(x, y) ? 1 : 0;
            System.out.println(nComfortable);
        }

        scanner.close();
    }
}
