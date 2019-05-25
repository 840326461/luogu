package string.P1914;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String pass = s.nextLine();
        for (int i = 0; i < pass.length(); i++) {
            int result = (pass.charAt(i) - 0x60 + n) % 26;
            if (result == 0)
                System.out.print('z');
            else
                System.out.print((char) (result + 0x60));
        }
    }
}
