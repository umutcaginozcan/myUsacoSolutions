import java.util.Scanner;

public class HungryCow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();  
        long T = scanner.nextLong();  

        long nonDelivered = 0, total = 0, lastTime = 0;

        for (long i = 0; i < N; i++) {
            long currentTime = scanner.nextLong();
            long deliveredNow = scanner.nextLong();

            total += deliveredNow;
            nonDelivered -= (currentTime - lastTime);
            nonDelivered = Math.max(nonDelivered, 0) + deliveredNow;
            lastTime = currentTime;
        }

        if (lastTime <= T) {
            nonDelivered -= (T + 1 - lastTime);
            nonDelivered = Math.max(nonDelivered, 0);
        }

        System.out.println(total - nonDelivered);
        scanner.close();
    }
}
