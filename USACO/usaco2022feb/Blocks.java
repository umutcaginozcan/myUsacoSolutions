import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Blocks {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] blocks = new String[4];
        in.nextLine();
        for (int i = 0; i < 4; i++) {
            blocks[i] = in.nextLine();
        }
        
        outerloop:
        for (int i = 1; i <= N; i++) {
            String word = in.nextLine(); // "MOVE"

            ArrayList<ArrayList<Integer>> charLocations = new ArrayList<>();
            for (int charIndex = 0; charIndex < word.length(); charIndex++) {
                ArrayList<Integer> a = new ArrayList<>();
                for (int blockIndex = 0; blockIndex < 4; blockIndex++) {
                    if (blocks[blockIndex].contains("" + word.charAt(charIndex))) {
                        a.add(blockIndex);
                    }
                }
                charLocations.add(a);
            }

            if (canFormWord(charLocations, new HashSet<>(), 0)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean canFormWord(ArrayList<ArrayList<Integer>> charLocations, HashSet<Integer> usedBlocks, int index) {
        if (index == charLocations.size()) {
            return true;
        }

        for (int blockIndex : charLocations.get(index)) {
            if (!usedBlocks.contains(blockIndex)) {
                usedBlocks.add(blockIndex);
                if (canFormWord(charLocations, usedBlocks, index + 1)) {
                    return true;
                }
                usedBlocks.remove(blockIndex);
            }
        }

        return false;
    }
}
