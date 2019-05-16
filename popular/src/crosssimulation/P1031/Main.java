package crosssimulation.P1031;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] cards = new int[num];
        int total = 0;
        int count=0;
        for (int i = 0; i < num; i++) {
            cards[i] = s.nextInt();
            total += cards[i];
        }
        int average = total / num;

        for (int i = 0; i < num; i++) {
            if (cards[i] == average) {
                continue;
            } else if (cards[i] < average) {
                cards[i + 1] -= average - cards[i];
            } else if (cards[i] > average) {
                cards[i + 1] += cards[i] - average;
            }
            cards[i] = average;
            count++;
        }
        System.out.println(count);
    }
}
