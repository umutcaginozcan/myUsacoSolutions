// package usaco2020dec;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class daisyChains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] petals = new int[N];
        for (int i = 0; i < N; i++) {
            petals[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int sum = makeSum(petals, i, j);
                int len = j - i + 1;
                int avg = sum / len;
                if (sum % len > 0) {
                    continue;
                }

                if (isContain(petals, i, j, avg)) {
                    res++;
                }
            }
        }

        pw.println(res);
        pw.close();
    }

    public static int makeSum(int[] arr, int i, int j) {
        int sum = 0;
        for (; i <= j; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static boolean isContain(int[] arr, int i, int j, int avg) {
        while (i <= j) {
            if (arr[i] == avg) return true;
            i++;
        }
        return false;
    }
} 
