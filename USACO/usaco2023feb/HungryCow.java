import java.util.Scanner;

public class HungryCow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long N = scanner.nextLong();  
        long T = scanner.nextLong();  

        long waitingBales = 0, total = 0, lastTime = 0;

        for (long i = 0; i < N; i++) {
            long currentTime = scanner.nextLong();
            long deliveredNow = scanner.nextLong();

            total += deliveredNow;
            waitingBales -= (currentTime - lastTime);
            waitingBales = Math.max(waitingBales, 0) + deliveredNow;
            lastTime = currentTime;
        }

        if (lastTime <= T) {
            waitingBales -= (T + 1 - lastTime);
            waitingBales = Math.max(waitingBales, 0);
        }

        System.out.println(total - waitingBales);
        scanner.close();
    }
}
