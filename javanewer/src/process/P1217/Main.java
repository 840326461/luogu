package process.P1217;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        int b=s.nextInt();
        int[] prime=new int[1000000];
        int[] check=new int[10000000];
        int primeCount=0;
        for (int i=2;i<=b;i++){
            if (i==9999999)break;
            if (check[i]!=1){
                prime[primeCount++]=i;
            }
            for (int j=0;j<primeCount;j++){
                if (i*prime[j]>9999999){
                    break;
                }
                check[i*prime[j]]=1;
                if(i%prime[j]==0){
                    break;
                }
            }
        }
        for (int j=0;j<primeCount;j++){
            if(prime[j]>=a&&prime[j]<=b&&isPalindrome(prime[j])){
                System.out.println(prime[j]);
            }
        }
    }

    private static boolean isPalindrome(int val){
        StringBuilder sb=new StringBuilder(Integer.toString(val));
        return sb.toString().equals(sb.reverse().toString());
    }
}
