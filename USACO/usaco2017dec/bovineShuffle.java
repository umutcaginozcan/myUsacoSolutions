import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class bovineShuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        // N: Number of cows.
        // ai: Shuffling Pattern.
        // Last Locations.
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] shufflingPattern = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            shufflingPattern[i] = Integer.parseInt(st.nextToken());
        }

        int[] lastLocations = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lastLocations[i] = Integer.parseInt(st.nextToken());
        }

        int[] firstLocations = deShuffle(lastLocations, shufflingPattern, 3);
        for (int i = 0; i < N; i++) {
            pw.println(firstLocations[i]);
        }
        pw.close();
    }

    public static int[] deShuffle(int[] locations, int[] shufflingPattern, int times) {
        
        int[] temp = locations.clone();
        for (int i = 1; i <= times; i++) {
            for (int j = 0; j < locations.length; j++) {
                temp[j] = locations[shufflingPattern[j] - 1];
            }
            locations = temp.clone();
        }
        return locations;
    }
    
}

// INPUT:
// 10
// 5 4 8 9 1 6 3 2 7 10
// 2641421 9202362 1490027 1368690 5520059 2897763 6513926 7180540 2383426 8089172


