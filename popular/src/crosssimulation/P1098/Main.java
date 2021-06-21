package crosssimulation.P1098;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int type = s.nextInt();
        int repeatNum = s.nextInt();
        boolean reverse = s.nextInt() != 1;
        StringBuilder sb = new StringBuilder();

        s.nextLine();
        String origin = s.nextLine();

        int i = 0;
        for (; i < origin.length() - 2; i++) {
            char c = origin.charAt(i);
            sb.append(c);
            char next = origin.charAt(i + 1);

            if (next == '-') {
                if (c == '-') {
                    continue;
                }
                char last = origin.charAt(i + 2);
                if (last > c && last - c <= 25) {
                    StringBuilder append = new StringBuilder();
                    char start = (char) (c + 1);
                    int num = last - c - 1;
                    if (type == 2 && c > 0x60) {
                        start -= 0x20;
                    }

                    if (type == 3) {
                        for (int j = 0; j < num; j++) {
                            for (int k = 0; k < repeatNum; k++) {
                                append.append('*');
                            }
                        }
                        sb.append(append);
                    } else {
                        for (int j = 0; j < num; j++, start++) {
                            for (int k = 0; k < repeatNum; k++) {
                                append.append(start);
                            }
                        }
                        if (reverse) {
                            append.reverse();
                        }
                        sb.append(append);
                    }
                } else {
                    continue;
                }
                i++;
            }
        }
        for (; i < origin.length(); i++) {
            sb.append(origin.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
