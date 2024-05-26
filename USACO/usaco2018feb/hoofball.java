import java.io.*;

public class hoofball {
    static int N;
    static int[] x;
    static int[] passto; // passto[i] is # of cows passing to cow i

    // To whom does cow i pass the ball?
    static int target(int i) {
        int left_nbr = -1, left_dist = 1000;
        int right_nbr = -1, right_dist = 1000;

        // Find closest neighbors on left and right
        for (int j = 0; j < N; j++) {
            if (x[j] < x[i] && x[i] - x[j] < left_dist) {
                left_nbr = j;
                left_dist = x[i] - x[j];
            }
        }
        for (int j = 0; j < N; j++) {
            if (x[j] > x[i] && x[j] - x[i] < right_dist) {
                right_nbr = j;
                right_dist = x[j] - x[i];
            }
        }

        if (left_dist <= right_dist) return left_nbr;
        return right_nbr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader fin = new BufferedReader(new FileReader("hoofball.in"));
        PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
        N = Integer.parseInt(fin.readLine());
        x = new int[N];
        passto = new int[N];

        String[] positions = fin.readLine().split(" ");
        for (int i = 0; i < N; i++) x[i] = Integer.parseInt(positions[i]);
        for (int i = 0; i < N; i++) passto[target(i)]++;

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (passto[i] == 0) answer++;  // +1 for every "source" cow, to whom nobody passes
            if (i < target(i) && target(target(i)) == i && passto[i] == 1 && passto[target(i)] == 1)
                answer++;  // +1 for every pair passing to each other
        }

        fout.println(answer);
        fout.close();
    }
}
