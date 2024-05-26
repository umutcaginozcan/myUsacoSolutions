package sortingAlgorithms;

import java.util.Scanner;

public class recursion1 {
    public static void main(String[] args) {
        int N = 3;
        sayHello(N);
        countDown(N);
        upTo(N);
        System.out.println(makeSum());
        System.out.println(getMax());
        hanoi(N, 1, 2, 3);
    }

    public static void sayHello(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Hello!");
        sayHello(n - 1);
    }

    public static void countDown(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }

    public static void upTo(int n) {
        if (n == 0) {
            return;
        }
        upTo(n - 1);
        System.out.println(n);
    }

    public static int makeSum() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        if (number == 0) {
            return 0;
        }

        return number * (number + 1) / 2 + makeSum();
    }

    static int getMax() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        if (N == 0) {
            return 0;
        }
        
        return Math.max(N, getMax());
    }

    static void hanoi(int n, int a, int b, int c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
            System.out.println(a + " -> " + c);
            hanoi(n - 1, b, a, c);
        }
    }
}

/* 
function hanoi(n, a, b, c)  //source, temp, target
if
n > 0
hanoi(n-1, a, c, b)
print
a "-->" c
hanoi(n-1, b, a, c)
 
main()
N = 3
hanoi(N, 1, 2, 3) 
*/