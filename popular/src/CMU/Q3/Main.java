package CMU.Q3;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().solution("abcde"));
    }

    public String solution(String S) {
        int index=-1;
        for (int i=0;i<S.length()-1;i++){
            if(S.charAt(i)>S.charAt(i+1)){
                index=i;
                break;
            }
        }
        if (index!=-1){
            return S.substring(0,index)+S.substring(index+1);
        }else{
            return S.substring(0,S.length()-1);
        }
    }
}
