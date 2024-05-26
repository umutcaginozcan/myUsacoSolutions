import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class milkPails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));

        int liters = 0;
        int maxLiters = 0;
        int bucket1Count = 0;
        int bucket2Count;

        StringTokenizer st = new StringTokenizer(br.readLine());
        // Kovanın boyutlarını ve hedef miktarı oku
        int X = Integer.parseInt(st.nextToken()); // Küçük kova
        int Y = Integer.parseInt(st.nextToken()); // Orta kova
        int M = Integer.parseInt(st.nextToken()); // Hedef süt miktarı

        // X kovasıyla doldurulabilecek maksimum sayıyı hesapla
        while (bucket1Count * X <= M) {
            bucket1Count++;
        }
        bucket1Count--; // Son eklenen sayı M'i aştığı için bir azalt

        // Her X kova kombinasyonu için, Y kovasıyla ne kadar doldurabileceğini hesapla
        for (int i = 0; i <= bucket1Count; i++) {
            bucket2Count = 0;
            while (bucket2Count * Y + i * X <= M) {
                bucket2Count++;
            }
            bucket2Count--; // Son eklenen sayı M'i aştığı için bir azalt
            
            // Bu kombinasyon için toplam süt miktarını hesapla ve maksimumu güncelle
            liters = bucket2Count * Y + i * X;
            if (liters > maxLiters) maxLiters = liters;
        }

        // Maksimum süt miktarını yaz
        pw.println(maxLiters);
        pw.close();

    }
}
