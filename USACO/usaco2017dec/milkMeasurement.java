import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class milkMeasurement {

    static class Log {

        int day;        
        String name;
        int dif;

    }
    
    static class DayComparator implements Comparator<Log> {
    
        @Override
        public int compare(Log o1, Log o2) {
            return o2.day - o1.day;
        }
    }

    public static void main(String[] args) throws IOException {
			 
		Scanner in = new Scanner(System.in);
        int N = in.nextInt();
			
			
            Log[] logs = new Log[N];
			
			 for(int i=0; i<N; i++)
			 {
                logs[i] = new Log();
                logs[i].day = in.nextInt();
                logs[i].name = in.next();
                logs[i].dif = in.nextInt();
			 } 
			
        
        Arrays.sort(logs, new DayComparator());

        for(Log l: logs) {
            System.out.println(l.day + " " + l.name + " " + l.dif); 
        }
        
        // int B = 7, E = 7, M = 7;
        // String board = "BEM";
        // int res = 0;
        // for (int i = 0; i < N; i++) {
        //     if (logs[i].name.equals("Bessie")) {
        //         B += logs[i].dif;
        //     } else if (logs[i].name.equals("Elsie")) {
        //         E += logs[i].dif;
        //     } else {
        //         M += logs[i].dif;
        //     }
            
        //     String newBoard = "";
        //     int maxVal = Math.max(B, Math.max(E, M));
        //     if (B == maxVal) {
        //         newBoard += "B";
        //     }
        //     if (E == maxVal) {
        //         newBoard += "E";
        //     }
        //     if (M == maxVal) {
        //         newBoard += "M";
        //     }
            
        //     if (!newBoard.equals(board)) {
        //         res++;
        //     }
            
        //     board = newBoard;
        // }

        // pw.println(res);
        // pw.close();
   }
}

// cosnt MAXN = 100

// read N

// array A[3][MAXN+1] = {0} //B, E, M

// A[0][0] = A[1][0] = A[2][0] = 7

// //updates
// repeat N times
// 	read day, name, dif
// 	if name = "Bessie"
// 		A[0][day] += dif
// 	else if name = "Elsie"
// 		A[1][day] += dif
// 	else
// 		A[2][day] += dif

// //prefix sum
// for j from 1 to MAX
// 	A[0][j] += A[0][j-1]
// 	A[1][j] += A[1][j-1]
// 	A[2][j] += A[2][j-1]
	
// res = 0

// board = "BEM"
// for j from 1 to MAX
	
// 	maxVal = max(A[0][j], A[1][j], A[2][j])
	
// 	newBoard = ""
	
// 	if A[0][j] = maxVal
// 		add(newBoard, 'B')
	
// 	if A[1][j] = maxVal
// 		add(newBoard, 'E')
	
// 	if A[2][j] = maxVal
// 		add(newBoard, 'M')
		
		
// 	if newBoard != board
// 		res++
		
// board = newBoard