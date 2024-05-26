// package usaco2019open;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;

public class cowEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> cows[] = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            cows[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                cows[i].add(st.nextToken());
            }
        }

        String res = "yes";
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (String x : cows[i]) {
                    for (String y : cows[j]) {
                        if (x.equals(y)) {
                            for (int k = 0; k < N; k++) {
                                if (k == i || k == j) continue;

                                for (String z : cows[k]) {
                                    if (cows[i].contains(z) && cows[j].contains(z)) continue;
                                    if (cows[i].contains(z) || cows[j].contains(z)) {
                                        if (!cows[k].contains(x)) {
                                            pw.println(i);
                                            pw.println(j);
                                            pw.println(k);
                                            pw.println(x);
                                            pw.println(z);
                                            res = "no";
                                        } 
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        pw.println(res);
        pw.close();
    }
}

/*
9
1 gbbuq
3 wzqfj ptnsn afadr
2 gbbuq ljjiv
1 ptnsn
0
2 wmdkq gbbuq
2 wzqfj ptnsn
1 bxixm
2 trrbl bxixm
 */
// OUTPUT: no answer: yes