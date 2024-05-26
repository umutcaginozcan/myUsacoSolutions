import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class photoshoot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("photo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

        int N = Integer.parseInt(br.readLine().trim()); // Correctly parse the number of cows N
        int[] bessieNumbers = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine()); // Create tokenizer for the second line

        for (int i = 0; i < bessieNumbers.length; i++) {
            bessieNumbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] fjNumbers = new int[N];
        boolean validConfigurationFound = false;

        // Trying different starting values for a1
        for (int a1 = 1; a1 <= N && !validConfigurationFound; a1++) {
            fjNumbers[0] = a1;
            boolean isValid = true;
            
            for (int j = 1; j < N && isValid; j++) {
                fjNumbers[j] = bessieNumbers[j - 1] - fjNumbers[j - 1];
                // Check if fjNumbers[j] is out of bounds or already in the array
                if (fjNumbers[j] <= 0 || fjNumbers[j] > N || contains(fjNumbers, fjNumbers[j], j)) {
                    isValid = false;
                }
            }
            
            if (isValid) {
                validConfigurationFound = true;
            }
        }

        for (int i = 0; i < N - 1; i++) {
            pw.print(fjNumbers[i] + " ");
        }
        pw.println(fjNumbers[N - 1]); // Ensure newline after the last number
        pw.close();
    }

    public static boolean contains(int[] arr, int value, int end) {
        for (int i = 0; i < end; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
}
