import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class angryCows {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int[] arr = new int[x1];
        int maxExplosionCount = 0;

        for (int i = 1; i <= arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i - 1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int rightExplosionIndex = calculateExplosionIndex(arr, i, true);
            int leftExplosionIndex = calculateExplosionIndex(arr, i, false);
            int explosionCount = rightExplosionIndex - leftExplosionIndex + 1;
            
            if (explosionCount > maxExplosionCount) {
                maxExplosionCount = explosionCount;
            }
        }

        pw.println(maxExplosionCount);
        pw.close();
    }

    public static int calculateExplosionIndex(int[] arr, int currentPosition, boolean toRight) {
        int finalPosition = currentPosition;
        int explosionRadius = 1; // Start with an explosion radius of 1
    
        while (true) {
            int nextPosition = finalPosition; // Track the next position that would explode
            if (toRight) {
                // Look for the next hay bale to the right within the explosion radius
                while (nextPosition + 1 < arr.length && arr[nextPosition + 1] - arr[finalPosition] <= explosionRadius) {
                    nextPosition++;
                }
            } else {
                // Look for the next hay bale to the left within the explosion radius
                while (nextPosition - 1 >= 0 && arr[finalPosition] - arr[nextPosition - 1] <= explosionRadius) {
                    nextPosition--;
                }
            }
    
            // If no new hay bales would explode, stop the loop
            if (nextPosition == finalPosition) {
                break;
            }
    
            // Prepare for the next iteration
            finalPosition = nextPosition;
            explosionRadius++; // Increase the explosion radius for the next round
        }
    
        return finalPosition;
    }
    
    
}