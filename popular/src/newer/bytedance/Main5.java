package newer.bytedance;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        for (int i = 0; i < m; i++) {
            int n = s.nextInt();
            int[] people = new int[n];
            for (int j = 0; j < n; j++) people[j] = s.nextInt();
            Arrays.sort(people);
            int result = 0;
            int index=n-1;
            while (true) {
                if (index==3){
                    result=result+people[index]+people[index-2]*2;
                    break;
                }else if (index<=2){
                    result+=people[index];
                    break;
                }else{
                    result+=people[index];
                    index-=2;
                    result+=people[index];
                }
            }
            System.out.println(result);
        }
    }
}
