import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class contaminatedMilk {
    public static void main(String[] args) throws IOException {
        // initialize file I/O
		BufferedReader br = new BufferedReader(new FileReader("badmilk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));

        // read in the first line, store N M D S.
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

        // arrays to store inputs.
        int[] friends = new int[D];
        int[] milks = new int[D];
        int[] times = new int[D];

        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int friend = Integer.parseInt(st.nextToken());
            int milk = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            friends[i] = friend;
            milks[i] = milk;
            times[i] = time;
        }

        int[] badMilk = new int[M];
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int sickFriend = Integer.parseInt(st.nextToken());
            int sickTime = Integer.parseInt(st.nextToken());
            for (int j = 0; j < D; j++) {
                if (friends[j] == sickFriend && times[j] < sickTime) {
                    badMilk[milks[j] - 1]++;
                }
            }
        }

        int[] sickFriends = new int[N];
        for (int i = 0; i < M; i++) {
            if (badMilk[i] >= 1) {
                for (int j = 0; j < D; j++) {
                    if (milks[j] == badMilk[i]) {
                        sickFriends[friends[j] - 1] = 1;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (sickFriends[i] == 1) {
                result++;
            }
        }

        pw.println(result);
        pw.close();
    }
}   
