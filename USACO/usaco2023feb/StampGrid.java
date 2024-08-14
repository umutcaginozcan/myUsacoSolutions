import java.util.Scanner;

public class StampGrid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        
        while (T-- > 0) {
            scanner.nextLine(); // To consume the empty line input
            int N = Integer.parseInt(scanner.nextLine());
            char[][] grid = new char[N][N];
            
            for (int i = 0; i < N; i++) {
                grid[i] = scanner.nextLine().toCharArray();
            }
            
            int K = Integer.parseInt(scanner.nextLine());
            char[][] stamp = new char[K][K];
            
            for (int i = 0; i < K; i++) {
                stamp[i] = scanner.nextLine().toCharArray();
            }
            
            char[][] ans = new char[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans[i][j] = '.';
                }
            }
            
            for (int rot = 0; rot < 4; rot++) {
                for (int i = 0; i <= N - K; i++) {
                    for (int j = 0; j <= N - K; j++) {
                        boolean valid = true;
                        for (int a = 0; a < K && valid; a++) {
                            for (int b = 0; b < K; b++) {
                                if (!(grid[i + a][j + b] == '*' || stamp[a][b] == '.')) {
                                    valid = false;
                                    break;
                                }
                            }
                        }
                        
                        if (valid) {
                            for (int a = 0; a < K; a++) {
                                for (int b = 0; b < K; b++) {
                                    if (stamp[a][b] == '*') {
                                        ans[i + a][j + b] = '*';
                                    }
                                }
                            }
                        }
                    }
                }
                
                // Rotate the stamp 90 degrees clockwise
                stamp = rotateClockwise(stamp, K);
            }
            
            if (areEqual(grid, ans, N)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        scanner.close();
    }

    private static char[][] rotateClockwise(char[][] matrix, int size) {
        char[][] rotated = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rotated[j][size - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    private static boolean areEqual(char[][] grid1, char[][] grid2, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid1[i][j] != grid2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
