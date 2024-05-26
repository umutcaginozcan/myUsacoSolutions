import java.util.Scanner;

/**
 * palindromeGame
 */
public class palindromeGame {
    public static void main(String[] args) {
        // Read T
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            String S = in.next();
            if (S.charAt(S.length() - 1) == '0') 
                System.out.println('E');
            else 
                System.out.println('B');
        }
    }
}
    