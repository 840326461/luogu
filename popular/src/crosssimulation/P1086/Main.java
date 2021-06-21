package crosssimulation.P1086;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int k=s.nextInt();
        Peanut[] list=new Peanut[m*n];
        int count=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                list[count]=new Peanut(i,j,s.nextInt());
                count++;
            }
        }

        Arrays.sort(list);
        int total=0;
        int time=0;
        int index=0;
        time+=1+list[index].x+1;
        if (time+list[index].x+1>k){
            System.out.println(total);
            return;
        }
        total+=list[index].num;
        index++;

        for (;index<m*n;index++){
            time+=Math.abs(list[index].x-list[index-1].x)+Math.abs(list[index].y-list[index-1].y)+1;
            if (time+list[index].x+1>k){
                System.out.println(total);
                return;
            }
            total+=list[index].num;
        }

        System.out.println(total);
    }
}

class Peanut implements Comparable<Peanut>{
    int x;
    int y;
    int num;

    public Peanut(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    @Override
    public int compareTo(Peanut o) {
        return Integer.compare(o.num, num);
    }
}
