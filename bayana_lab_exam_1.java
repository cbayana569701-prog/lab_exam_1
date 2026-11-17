import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Scanner;

public class labexam1 {
    static Scanner input = new Scanner(System.in);
    static int count = 0;

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        System.out.println("Enter five elements:");
        for (int i = 0; i < 5; i++) {
            String elmnt = input.next();
            queue.add(elmnt);
        }
        System.out.println("\nQueue: " + queue);
        System.out.println("\nDequeuing two elements...");
        queue.poll();
        queue.poll();
        System.out.println("Updated Queue: " + queue);
        System.out.print("\nEnter number of elements to arrange:");
        int n = input.nextInt();
        if (n <= 0 || n > queue.size()) {
            System.out.println("Invalid number of elements!");
            return;
        }

        ArrayList<String> elmnts = new ArrayList<>();
        int i = 0;
        for (String item : queue) {
            if (i < n) {
            	elmnts.add(item);
                i++;
            }
        }
        System.out.println("\nGenerated Permutations:");
        generatePermutations(elmnts, 0);
        System.out.println("\nTotal Permutations: " + count);
        input.close();

    }

    public static void generatePermutations(
            ArrayList<String> elmnts, int index) {
        if (index == elmnts.size()) {
            for (String item : elmnts) {
                System.out.print(item);
            }
            System.out.println();
            count++;
            return;
        }
        for (int i = index; i < elmnts.size(); i++) {
            String temp = elmnts.get(index);
            elmnts.set(index, elmnts.get(i));
            elmnts.set(i, temp);

            generatePermutations(elmnts, index + 1);

            temp = elmnts.get(index);
            
            elmnts.set(index, elmnts.get(i));
            elmnts.set(i, temp);

        }
    }
}
