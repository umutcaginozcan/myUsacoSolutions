import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class YearOfTheCow {
    static String[] animals = {"Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig", "Rat"};
    static Map<String, Integer> whenBorn = new HashMap<>();

    public static String getAnimal(int year) {
        int a = 0, y = 2021;
        while (y < year) {
            y++;
            a++;
            if (a == 12) a = 0;
        }
        while (y > year) {
            y--;
            a--;
            if (a == -1) a = 11;
        }
        return animals[a];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        whenBorn.put("Bessie", 2021);
        int N = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline character
        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String cowA = parts[0];
            String relation = parts[3];
            String animal = parts[4];
            String cowB = parts[7];
            
            whenBorn.put(cowA, whenBorn.get(cowB));
            do {
                if (relation.equals("previous")) {
                    whenBorn.put(cowA, whenBorn.get(cowA) - 1);
                } else {
                    whenBorn.put(cowA, whenBorn.get(cowA) + 1);
                }
            } while (!getAnimal(whenBorn.get(cowA)).equals(animal));
        }
        int diff = Math.abs(whenBorn.get("Bessie") - whenBorn.get("Elsie"));
        System.out.println(diff);
        scanner.close();
    }
}