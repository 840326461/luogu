package crosssimulation.P3952;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<StackItem> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        out:
        for (int i = 0; i < n; i++) {
            int lineNum = s.nextInt();
            int max = 0;
            int middle = 0;
            String complexity = s.next();
            complexity = complexity.substring(2, complexity.length() - 1);
            int coeficient = -1;
            if (complexity.equals("1")) {
                coeficient = 0;
            } else {
                coeficient = Integer.parseInt(complexity.substring(2));
            }
            for (int j = 0; j < lineNum; j++) {
                String head = s.next();
                if (head.equals("F")) {
                    char c = s.next().charAt(0);
                    String a = s.next();
                    String b = s.next();
                    if (stack.contains(c)) {
                        System.out.println("ERR");
                        stack.clear();
                        break out;
                    }
                    if (a.equals("n")) {
                        if (b.equals("n")) {
                            stack.push(new StackItem(c,true));
                        } else {
                            Stack<Character> temp = new Stack<>();
                            temp.push('F');
                            while (!temp.empty()) {
                                String line = s.nextLine();
                                if (line.trim().isEmpty()) {
                                    line = s.nextLine();
                                }
                                if (line.startsWith("F")) {
                                    temp.push('F');
                                } else {
                                    temp.pop();
                                }
                                j++;
                            }
                        }
                    } else {
                        if (b.equals("n")) {
                            stack.push(new StackItem(c,true));
                            middle++;
                        } else {
                            if(Integer.parseInt(a)>Integer.parseInt(b)){
                                Stack<Character> temp = new Stack<>();
                                temp.push('F');
                                while (!temp.empty()) {
                                    String line = s.nextLine();
                                    if (line.trim().isEmpty()) {
                                        line = s.nextLine();
                                    }
                                    if (line.startsWith("F")) {
                                        temp.push('F');
                                    } else {
                                        temp.pop();
                                    }
                                    j++;
                                }
                            }else {
                                stack.push(new StackItem(c, false));
                            }
                        }
                    }
                } else {
                    if (stack.empty()) {
                        System.out.println("ERR");
                        break out;
                    }
                    StackItem item=stack.pop();
                    if(item.countable) {
                        middle--;
                    }
                }
                max = Math.max(max, middle);
            }
            if (!stack.empty()) {
                System.out.println("ERR");
                stack.clear();
                continue;
            }
            if (max == coeficient) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}

class StackItem{
    char c;
    boolean countable;

    public StackItem(char c, boolean countable) {
        this.c = c;
        this.countable = countable;
    }
}