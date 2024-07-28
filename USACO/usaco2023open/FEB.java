import java.util.ArrayList;
import java.util.Scanner;

public class FEB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();

        int min = 0, max = 0; // Initialize minimum and maximum possible values
        int curIdx = 0; // Current index in the string

        // Loop through the string until we reach the end
        while (curIdx < n) {
            // If the current character is 'F', just continue to next character
            if (s.charAt(curIdx) == 'F') {
                curIdx++;
                continue;
            }

            // Find the next non-'F' character
            int nextIdx = curIdx + 1;
            while (nextIdx < n && s.charAt(nextIdx) == 'F') nextIdx++;
            // If we reach the end of string, break out of the loop
            if (nextIdx == n) break;

            // Calculate the number of 'F's between characters
            int num_F = nextIdx - curIdx - 1;

            // Check if the next character is the same as the current
            if (s.charAt(nextIdx) == s.charAt(curIdx)) {
                // Case 1: Same character as current, e.g., BFFFFFB
                int length = num_F + 2;

                // For minimum changes:
                if (length % 2 == 0) {
                    // For even length, make minimal changes, e.g., BEBEBB
                    min += 1;
                } else {
                    // For odd length, alternate, e.g., BEBEB
                    min += 0;
                }

                // For maximum changes:
                max += length - 1;
            } else {
                // Case 2: Different character, e.g., BFFFFFE
                int length = num_F + 2;

                // For minimum changes:
                if (length % 2 == 0) {
                    // For even length, alternate, e.g., BEBEBE
                    min += 0;
                } else {
                    // For odd length, make minimal changes, e.g., BEBEE
                    min += 1;
                }

                // For maximum changes:
                max += length - 2;
            }

            // Move the current index to next character
            curIdx = nextIdx;
        }

        // Check if the string starts or ends with 'F's
        int num_beginning_F = 0;
        while (num_beginning_F < n && s.charAt(num_beginning_F) == 'F') num_beginning_F++;
        int num_ending_F = 0;
        while (num_ending_F < n && s.charAt(n - 1 - num_ending_F) == 'F') num_ending_F++;

        if (num_beginning_F == n) {
            // Special case: entire string is 'F's
            min = 0;
            max = n - 1;
        } else {
            // Update maximum value considering starting and ending 'F's
            max += num_beginning_F;
            max += num_ending_F;
        }

        // Calculate all possible levels
        ArrayList<Integer> possible_levels = new ArrayList<>();
        if (num_beginning_F == 0 && num_ending_F == 0) {
            // If no beginning or ending 'F's, change in increments of two
            for (int i = min; i <= max; i += 2) possible_levels.add(i);
        } else {
            // Otherwise, consider all values from mn to mx
            for (int i = min; i <= max; i++) possible_levels.add(i);
        }

        System.out.println(possible_levels.size());
        for (int i : possible_levels) {
            System.out.println(i);
        }

        scanner.close();
    }
}
