import java.util.*;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] input = scanner.nextLine().split(" ");
            int[] H = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

            if (H[H.length - 1] != 1) {
                System.out.println(-1);
                continue;
            }

            Set<Integer> elementsSeen = new HashSet<>();
            int minLocation = 1, curr = 0;
            ArrayList<Integer>[] permutation = new ArrayList[2];
            permutation[0] = new ArrayList<>();
            permutation[1] = new ArrayList<>();

            for (int i = H.length - 2; i >= 0; i--) {
                int ele = H[i];
                elementsSeen.add(ele);
                if (ele == minLocation) {
                    curr = 1 - curr;
                } 
                while (elementsSeen.contains(minLocation)) {
                    minLocation++;
                }
                permutation[curr].add(ele);
            }

            if (elementsSeen.size() != N - 2) {
                System.out.println(-1);
                continue;
            }

            permutation[1 - curr].add(minLocation);
            elementsSeen.add(minLocation);
            while (elementsSeen.contains(minLocation)) {
                minLocation++;
            }
            permutation[curr].add(minLocation);

            if (permutation[0].get(permutation[0].size() - 1) > permutation[1].get(permutation[1].size() - 1)) {
                Collections.reverse(permutation[1]);
                permutation[1].addAll(permutation[0]);
                StringJoiner joiner = new StringJoiner(" ");
                permutation[1].forEach(e -> joiner.add(String.valueOf(e)));
                System.out.println(joiner.toString());
            } else {
                Collections.reverse(permutation[0]);
                permutation[0].addAll(permutation[1]);
                StringJoiner joiner = new StringJoiner(" ");
                permutation[0].forEach(e -> joiner.add(String.valueOf(e)));
                System.out.println(joiner.toString());
            }
        }
        scanner.close();
    }
}
