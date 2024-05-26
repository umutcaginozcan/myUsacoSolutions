import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * whDidTheCowCrossTheRoad2
 */
public class whyDidTheCowCrossTheRoad2 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();

        int[] enter = new int[26];
        int[] exit = new int[26];
        int count = 1;
        for (int i = 0; i < input.length(); i++) {
            if (enter[input.charAt(i) - 'A'] == 0) {
                enter[input.charAt(i) - 'A'] = count;
            } else {
                exit[input.charAt(i) - 'A'] = count;
            }
            count++;
        }

        int answer = 0;
        // Check if X and Y is a crossing-pair
        for (int i = 0; i < 26; i++) {
            for (int j = i + 1; j < 26; j++) {
                    if ((enter[i] < enter[j] && enter[j] < exit[i] && exit[i] < exit[j]) 
                    || (enter[j] < enter[i] && enter[i] < exit[j] && exit[j] < exit[i])) {
                    answer++;
                }
            }
        }

        pw.println(answer);
        pw.close();
    }
}

// Input: ABCCABDDEEFFGGHHIIJJKKLLMMNNOOPPQQRRSSTTUUVVWWXXYYZZ