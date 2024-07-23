import java.util.Scanner;

public class FeedingtheCows {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt(); // Number of test cases

        for (int t = 0; t < T; t++) {
            int strLen = in.nextInt();
            int maxDist = in.nextInt();
            String str = in.next();
            solution(str, strLen, maxDist);
        }
        in.close();
    }

    public static void solution(String str, int strLen, int maxDist) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < strLen; i++) {
            ans.append('.');
        }

        int intAns = 0;
        for (int i = 0; i < strLen; i++) {
            if (!hasGrass(ans, str.charAt(i), maxDist, i)) {
                if (ans.charAt(Math.min(strLen - 1, i + maxDist)) == '.') {
                    ans.setCharAt(Math.min(strLen - 1, i + maxDist), str.charAt(i));
                } else {
                    for (int j = Math.min(strLen - 1, i + maxDist) - 1; j >= 0; j--) {
                        if (ans.charAt(j) == '.') {
                            ans.setCharAt(j, str.charAt(i));
                            break;
                        }
                    }
                }
                intAns++;
            }
        }

        System.out.println(intAns);
        System.out.println(ans.toString());
    }

    public static boolean hasGrass(StringBuilder ans, char cowType, int maxDist, int currentIndex) {
        int start = Math.max(0, currentIndex - maxDist);
        int end = Math.min(ans.length() - 1, currentIndex + maxDist);
        for (int i = start; i <= end; i++) {
            if (ans.charAt(i) == cowType) {
                return true;
            }
        }
        return false;
    }
}
