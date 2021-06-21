package CMU.Q1;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().solution("Sat",23));
    }

    public String solution(String S, int K) {
        String[] days=new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        int start=0;
        for(String day:days){
            if (day.equals(S)){
                break;
            }
            start++;
        }
        int remain=(start+K)%7;
        return days[remain];
    }
}
