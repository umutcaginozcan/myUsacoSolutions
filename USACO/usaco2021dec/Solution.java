import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
        // Read inputs: N, initialTemp, goalTemp.
        int N = Integer.parseInt(in.readLine());

        int[] goalTemp = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            goalTemp[i] = Integer.parseInt(st.nextToken());    
        } 
        
        int[] initialTemp = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            initialTemp[i] = Integer.parseInt(st.nextToken());
        }

        // Define an ArrayList for differences.
        ArrayList<Integer> differences = new ArrayList<>();
        // Fill the ArrayList.
        for (int i = 0; i < N; i++) {
            int difference = goalTemp[i] - initialTemp[i];
            differences.add(difference);
        }

        int result = 0;
        // While loop. Will continue until ArrayList is empty.
        while (!differences.isEmpty()) {
            // We will start by the last element. If the last element is zero, meaning we do not need to change the temp any further, remove it.
            if (differences.get(differences.size() - 1) == 0) {
                differences.remove(differences.size() - 1);
                continue;
            }
    
            // Then check if the last element is positive.
            boolean isPositive = differences.get(differences.size() - 1) > 0;
    
            // Define amtChange: How many consecutive elements will be affected? Start by 1.
            int amtChange = 1;
    
            // Define delta: The smallest absolute value in the subsegment.
            int delta = Math.abs(differences.get(differences.size() - 1));
    
            // While loop. While elements affected < size, break if: we face a difference == 0, or the positive row is broken or otherwise.
            while (amtChange < differences.size()) {
                if (differences.get(differences.size() - 1 - amtChange) == 0) {
                    break;
                }
                if ((differences.get(differences.size() - 1 - amtChange) > 0) != isPositive) {
                    break;
                }
                delta = Math.min(delta, Math.abs(differences.get(differences.size() - 1 - amtChange)));
                amtChange++;
            }
    
            // Result will increase by delta.
            result += delta;
    
            // For loop. To improve efficiency decrease the values by delta.
            for (int i = 0; i < amtChange; i++) {
                if (differences.get(differences.size() - 1 - i) > 0) {
                    differences.set(differences.size() - 1 - i, differences.get(differences.size() - 1 - i) - delta);
                } else {
                    differences.set(differences.size() - 1 - i, differences.get(differences.size() - 1 - i) + delta);
                }
            }
        }

        // Print the answer.
        System.out.println(result);
    }
}
