import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class promotionCounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("promote.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));

        int[] bronze = new int[2];
        int[] silver = new int[2];
        int[] gold = new int[2];
        int[] platinum = new int[2];
        int bronzeToSilver, silverToGold, goldToPlat = 0;

        // read in the first line, store a and b
		StringTokenizer st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
        bronze[0] = x1;
        bronze[1] = x2;

        // read in the second line, store c and d
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
        silver[0] = x3;
        silver[1] = x4;

        // read in the second line, store c and d
		st = new StringTokenizer(br.readLine());
		int x5 = Integer.parseInt(st.nextToken());
		int x6 = Integer.parseInt(st.nextToken());
        gold[0] = x5;
        gold[1] = x6;

        // read in the second line, store c and d
		st = new StringTokenizer(br.readLine());
		int x7 = Integer.parseInt(st.nextToken());
		int x8 = Integer.parseInt(st.nextToken());
        platinum[0] = x7;
        platinum[1] = x8;

        goldToPlat = platinum[1] - platinum[0];
        silverToGold = gold[1] - gold[0] + goldToPlat; // Promotions to gold plus those that moved to platinum
        bronzeToSilver = silver[1] - silver[0] + silverToGold; // Promotions to silver plus those that moved to gold

        pw.println(bronzeToSilver);
        pw.println(silverToGold);
        pw.println(goldToPlat);

        pw.close();
        br.close();
    }
}
