import java.util.Scanner;

public class Photoshoot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); in.nextLine();
        String cows = in.nextLine();

        StringBuilder result = new StringBuilder();
        char[] lastAdded = new char[1];
        lastAdded[0] = 'X';
        for (int i = 0; i < (N / 2); i++) {
            if (cows.substring(2 * i, 2 * i + 2).equals("HG") && lastAdded[0] != 'A') {
                result.append("A");
                lastAdded[0] = 'A';
            } else if (cows.substring(2 * i, 2 * i + 2).equals("GH") && lastAdded[0] != 'B') {
                result.append("B");
                lastAdded[0] = 'B';
            } 
        }

        if (result.charAt(result.length() - 1) == 'A') result.deleteCharAt(result.length() - 1);
        System.out.println(result.length());
    }
}
