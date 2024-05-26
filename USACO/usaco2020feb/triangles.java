import java.io.*;
import java.util.*;
public class triangles {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
   
    int n = Integer.parseInt(br.readLine());
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      x[i] = Integer.parseInt(st.nextToken());
      y[i] = Integer.parseInt(st.nextToken());
    }

    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) { // same x-coordinate
        if (i == j || x[i] != x[j]) continue;
        for (int k = 0; k < n; k++) { // same y-coordinate
          if (i == k || y[i] != y[k]) continue;
          res = Math.max(res, Math.abs(x[k] - x[i]) * Math.abs(y[j] - y[i]));
        }
      }
    }
    
    pw.println(res);
    pw.close();
  }
}
