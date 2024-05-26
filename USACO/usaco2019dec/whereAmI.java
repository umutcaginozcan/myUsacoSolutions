// package usaco2019dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class whereAmI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numberOfMailboxes = Integer.parseInt(st.nextToken());
        String colorsOfMailboxes = br.readLine(); 

        // We need to determine the smallest substring length that uniquely identifies its location.
        int result = 0;
        boolean uniqueFound = false;
        
        for (int lengthOfSubstring = 1; lengthOfSubstring <= numberOfMailboxes; lengthOfSubstring++) {
            uniqueFound = true;
            for (int shift1 = 0; shift1 <= numberOfMailboxes - lengthOfSubstring; shift1++) {
                for (int shift2 = shift1 + 1; shift2 <= numberOfMailboxes - lengthOfSubstring; shift2++) {
                    String substring1 = colorsOfMailboxes.substring(shift1, shift1 + lengthOfSubstring);
                    String substring2 = colorsOfMailboxes.substring(shift2, shift2 + lengthOfSubstring);
                    if (substring1.equals(substring2)) {
                        uniqueFound = false;
                        break;
                    }
                }
                if (!uniqueFound) break;
            }
            if (uniqueFound) {
                result = lengthOfSubstring;
                break;
            }
        }
        
        pw.println(result);
        pw.close();
    }
}
