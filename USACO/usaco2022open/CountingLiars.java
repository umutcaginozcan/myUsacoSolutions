import java.util.Scanner;

public class CountingLiars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        String[] directions = new String[N];
        long[] locations = new long[N];
        for (int i = 0; i < N; i++) {
            directions[i] = in.next();
            locations[i] = in.nextLong();
        }

        long correctIndex = -1;
        int minLiarCount = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int liarsCount = 0;
            correctIndex = directions[i].equals("G") ? locations[i] : locations[i];
            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                if (directions[j].equals("L") && correctIndex > locations[j] || 
                    directions[j].equals("G") && correctIndex < locations[j]) liarsCount++;
            }
            minLiarCount = Math.min(minLiarCount, liarsCount);
        }

        if (minLiarCount == Integer.MAX_VALUE) {
            System.out.println("0");
        } else {
            System.out.println(minLiarCount);
        }
    }
}
