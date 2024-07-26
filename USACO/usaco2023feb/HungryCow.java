import java.util.Scanner;

public class HungryCow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading the number of deliveries N and the final time T
        long N = scanner.nextLong();  // N as long
        long T = scanner.nextLong();  // T as long

        // Variables to keep track of remaining items and totals
        long remaining = 0, total = 0, lastTime = 0;

        for (long i = 0; i < N; i++) {
            long currentTime = scanner.nextLong();
            long currentQuantity = scanner.nextLong();

            total += currentQuantity;
            remaining -= (currentTime - lastTime);
            remaining = Math.max(remaining, 0) + currentQuantity;
            lastTime = currentTime;
        }

        // Consider final time T + 1 with zero quantity
        if (lastTime <= T) {
            remaining -= (T + 1 - lastTime);
            remaining = Math.max(remaining, 0);
        }

        // Printing the total deliveries minus remaining items
        System.out.println(total - remaining);
        scanner.close();
    }
}
