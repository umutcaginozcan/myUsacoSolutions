import java.util.*;
     
    public class StuckInARut {
     
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] xs = new int[n];
            int[] ys = new int[n];
            char[] dir = new char[n];
            for (int j = 0; j < n; j++) {
                dir[j] = in.next().charAt(0);
                xs[j] = in.nextInt();
                ys[j] = in.nextInt();
            }
            int[] answer = new int[n];
            Arrays.fill(answer, Integer.MAX_VALUE);
            List<Integer> differences = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    differences.add(Math.abs(xs[k] - xs[j]));
                    differences.add(Math.abs(ys[k] - ys[j]));
                }
            }
            Collections.sort(differences);
            for (int d : differences) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (dir[j] == 'E' && dir[k] == 'N' && xs[j] < xs[k] && ys[k] < ys[j]) {
                            if (xs[j] + d == xs[k] && ys[k] + Math.min(answer[k], d) > ys[j]) {
                                answer[j] = Math.min(answer[j], d);
                            } else if (ys[k] + d == ys[j] && xs[j] + Math.min(answer[j], d) > xs[k]) {
                                answer[k] = Math.min(answer[k], d);
                            }
                        }
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                System.out.println(answer[j] == Integer.MAX_VALUE ? "Infinity" : answer[j]);
            }
        }
    }