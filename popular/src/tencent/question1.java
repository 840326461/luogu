package tencent;

import java.util.Scanner;

public class question1 {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int n=s.nextInt();
            for(int i=0;i<n;i++){
                int next=s.nextInt();
                int[] map=new int[next+1];
                while(next!=0){
                    int in=s.nextInt();
                    if (in==next){
                        System.out.print(in);
                        next--;
                        while(true){
                            if (map[next]==1){
                                System.out.print(" "+next);
                                next--;
                            }else
                                break;
                        }
                        System.out.println();
                    }else{
                        map[in]=1;
                        System.out.println();
                    }
                }
            }
        }
}

