package algorithm.simulationAndHighPrecision.P1065;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();
        int[] order=new int[m*n];
        for (int i=0;i<order.length;i++){
            order[i]=s.nextInt();
        }
        int[][] machines=new int[n+1][m+1];//工件对应的当前工序号存放在0列
        int[][] processingTimes=new int[n+1][m+1];//工件对应的当下一工序最早开始时间存放在0列

        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                machines[i][j]=s.nextInt();
            }
        }
        for (int i=1;i<=n;i++){
                machines[i][0]=1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                processingTimes[i][j]=s.nextInt();
            }
        }

        LinkedList<Interval>[] intervals=new LinkedList[m+1];
        for (int i=0;i<intervals.length;i++){
            intervals[i]=new LinkedList<>();
            intervals[i].add(new Interval(0,2127483647));
        }

        for (int i=0;i<order.length;i++){
            int partsNumber =order[i];
            int machine=machines[partsNumber][machines[partsNumber][0]];
            int processingTime=processingTimes[partsNumber][machines[partsNumber][0]];
            machines[partsNumber][0]++;

            LinkedList<Interval> interval=intervals[machine];
            int earliest=processingTimes[partsNumber][0];
            int index=0;
            int start=0;
            Interval insert=null;
            /**
             * 找出第一个空隙，满足在上一工序结束之后的剩余空隙大于加工时间
             * 由于增加删除操作较多且查询操作均需从头遍历，故使用链表
             */
            for(Interval item:interval){
                index++;
                if(earliest<item.end){
                    start= Math.max(earliest, item.start);
                    if (item.end-start>=processingTime){
                        insert=item;
                        break;
                    }
                }
            }
            if (insert.end!=start+processingTime){
                interval.add(index,new Interval(start+processingTime,insert.end));
            }

            if(insert.start!=start){
                interval.add(index,new Interval(insert.start,start));
            }

            processingTimes[partsNumber][0]=start+processingTime;
            interval.remove(index-1);
        }

        int result=0;
        for (LinkedList<Interval> interval:intervals){
            result=Math.max(result,interval.peekLast().start);
        }
        System.out.println(result);
    }
}
class Interval{
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}