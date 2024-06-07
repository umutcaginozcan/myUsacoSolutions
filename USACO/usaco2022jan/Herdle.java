import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Herdle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder correctAns = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            correctAns.append(br.readLine());
        }
        
        StringBuilder initialAns = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            initialAns.append(br.readLine());
        }

        int[] correctChars = new int[26];
        int[] initialChars = new int[26];
        int greenCount = 0;
        for (int j = 0; j < 9; j++) {
            if (correctAns.charAt(j) == initialAns.charAt(j)) {
                greenCount++;
            }
            correctChars[correctAns.charAt(j) - 'A']++;
            initialChars[initialAns.charAt(j) - 'A']++;
        }
        System.out.println(greenCount);

        int yellowCount = 0;
        for (int j = 0; j < 26; j++) {
            yellowCount += Math.min(correctChars[j], initialChars[j]);
        }
        yellowCount -= greenCount;
        System.out.println(yellowCount);
    }
}
