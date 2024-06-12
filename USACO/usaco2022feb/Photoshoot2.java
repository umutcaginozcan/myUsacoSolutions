// package myUsacoSolutions.USACO.usaco2022feb;
import java.util.Scanner;

public class Photoshoot2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] initialArr = new int[N];
        int[] resultArr = new int[N];
        for (int j = 0; j < N; j++) {
            initialArr[j] = in.nextInt();
        }
        for (int j = 0; j < N; j++) {
            resultArr[j] = in.nextInt();
        }
       
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (initialArr[i] == resultArr[i]) {
                continue;
            }

            count++;
            int index = i + 1;
            for (; index < N; index++) {
                if (resultArr[i] == initialArr[index]) {
                    break;
                }
            }

            int temp = initialArr[index];
            for (int j = index - 1; j >= i; j--) {
                initialArr[j + 1] = initialArr[j];
            }
            initialArr[i] = temp;
        }

        System.out.println(count);
    }
}
