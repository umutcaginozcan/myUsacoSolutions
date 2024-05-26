import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dontBeLast {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

        String[] cows = {"Bessie", "Elsie", "Daisy", "Gertie", "Annabelle", "Maggie", "Henrietta"};
        int[] milks = new int[7]; // Stores total milk for each cow

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int milk = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cows.length; j++) {
                if (name.equals(cows[j])) {
                    milks[j] += milk;
                }
            }
        }

        int smallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for (int milk : milks) {
            if (milk < smallest) {
                secondSmallest = smallest;
                smallest = milk;
            } else if (milk > smallest && milk < secondSmallest) {
                secondSmallest = milk;
            }
        }

        int count = 0;
        String secondSmallestCow = "Tie";
        for (int i = 0; i < milks.length; i++) {
            if (milks[i] == secondSmallest) {
                count++;
                if (count > 1) { // More than one cow has the second smallest amount
                    secondSmallestCow = "Tie";
                    break;
                }
                secondSmallestCow = cows[i];
            }
        }

        pw.println(secondSmallestCow.equals("Tie") || count == 0 ? "Tie" : secondSmallestCow);
        pw.close();
        br.close();
    }
}
