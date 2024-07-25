import java.util.Scanner;

public class MooOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        in.nextLine();

        while (Q > 0) {
            String wordToBeTransformed = in.nextLine();
            int MOOcount = 0, OOOcount = 0, MOMcount = 0, OOMcount = 0;
            int wordLength = wordToBeTransformed.length();

            for (int i = 0; i < wordLength - 2; i++) {
                if (wordToBeTransformed.substring(i, i + 3).equals("MOO")) MOOcount++;
                else if (wordToBeTransformed.substring(i, i + 3).equals("OOO")) OOOcount++;
                else if (wordToBeTransformed.substring(i, i + 3).equals("MOM")) MOMcount++;
                else if (wordToBeTransformed.substring(i, i + 3).equals("OOM")) OOMcount++;
            }

            if (MOOcount != 0) {
                System.out.println(wordLength - 3);
            } else if (OOOcount != 0) {
                System.out.println(wordLength - 2);
            } else if (MOMcount != 0) {
                System.out.println(wordLength - 2);
            } else if (OOMcount != 0) {
                System.out.println(wordLength - 1);
            } else {
                System.out.println(-1);
            }

            Q--;
        }
    }
}
