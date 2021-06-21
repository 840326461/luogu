package CMU.Q2;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().solution(5000));
    }

    public int solution(int N) {
        boolean negative = N < 0;
        if (negative) {
            N = -N;
        }
        String s = Integer.toString(N);
        int i = 0;
        int index = -1;
        if (negative) {
            for (; i < s.length(); i++) {
                if (s.charAt(i) - 0x30 > 5) {
                    index = i;
                    break;
                }
            }
        } else {
            for (; i < s.length(); i++) {
                if (s.charAt(i) - 0x30 < 5) {
                    index = i;
                    break;
                }
            }
        }
        int result=0;
        if (index != -1) {
            result= Integer.parseInt(s.substring(0, index) + "5" + s.substring(index));
        } else {
            result= Integer.parseInt(s + "5");
        }
        if(negative){
            return -result;
        }else {
            return result;
        }
    }
}
