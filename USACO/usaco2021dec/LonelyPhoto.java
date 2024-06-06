package myUsacoSolutions.USACO.usaco2021dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LonelyPhoto {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String cows = br.readLine();

        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 3; j <= N; j++) { // Changed to j <= N
                if (!isLonely(cows.substring(i, j))) {
                    break;
                }
                if (isSingleBreed(cows.substring(i, j))) { // Checking the correct substring
                    continue;
                }
                result++;
            }
        }

        System.out.println(result);
    }

    public static boolean isLonely(String photo) {
        int guernseyCount = 0, holsteinCount = 0;
        for (int i = 0; i < photo.length(); i++) {
            if (photo.charAt(i) == 'G') guernseyCount++;
            else holsteinCount++;
        }

        return !(guernseyCount >= 2 && holsteinCount >= 2);
    }

    public static boolean isSingleBreed(String photo) {
        int guernseyCount = 0, holsteinCount = 0;
        for (int i = 0; i < photo.length(); i++) {
            if (photo.charAt(i) == 'G') guernseyCount++;
            else holsteinCount++;
        }

        return (guernseyCount > 0 && holsteinCount == 0) || (guernseyCount == 0 && holsteinCount > 0);
    }
}
