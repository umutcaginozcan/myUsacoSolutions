import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of posts (P) and cows (N)
        String[] firstLine = scanner.nextLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int P = Integer.parseInt(firstLine[1]);

        // Read posts coordinates
        int[][] posts = new int[P][2];
        for (int i = 0; i < P; i++) {
            String[] postInput = scanner.nextLine().split(" ");
            posts[i][0] = Integer.parseInt(postInput[0]);
            posts[i][1] = Integer.parseInt(postInput[1]);
        }

        // Read cows coordinates
        int[][] cows = new int[N][4];
        for (int i = 0; i < N; i++) {
            String[] cowInput = scanner.nextLine().split(" ");
            for (int j = 0; j < 4; j++) {
                cows[i][j] = Integer.parseInt(cowInput[j]);
            }
        }

        // Create a 1001x1001 grid initialized to 0
        int[][] grid = new int[1001][1001];
        
        int time = 0;
        for (int i = 0; i < P; i++) {
            int[] curr = posts[i];
            int[] next = posts[(i + 1) % P];
            
            if (curr[0] < next[0]) {
                for (int x = curr[0]; x < next[0]; x++) {
                    grid[x][curr[1]] = time++;
                }
            } else if (curr[0] > next[0]) {
                for (int x = curr[0]; x > next[0]; x--) {
                    grid[x][curr[1]] = time++;
                }
            }

            if (curr[1] < next[1]) {
                for (int y = curr[1]; y < next[1]; y++) {
                    grid[curr[0]][y] = time++;
                }
            } else if (curr[1] > next[1]) {
                for (int y = curr[1]; y > next[1]; y--) {
                    grid[curr[0]][y] = time++;
                }
            }
        }

        // Calculate and print distances based on grid time values
        for (int[] cow : cows) {
            int t1 = grid[cow[0]][cow[1]];
            int t2 = grid[cow[2]][cow[3]];
            System.out.println(Math.min(((t1 - t2) % time + time) % time, ((t2 - t1) % time + time) % time));
        }

        scanner.close();
    }
}
