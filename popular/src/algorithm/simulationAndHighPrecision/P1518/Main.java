package algorithm.simulationAndHighPrecision.P1518;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] map=new char[10][10];
        Scanner s=new Scanner(System.in);
        Entity A=null;
        Entity B=null;
        Boolean[] state=new Boolean[160001];
        for(int i =0;i<160001;i++){
            state[i]=false;
        }
        for(int i=0;i<10;i++){
            map[i]=s.nextLine().toCharArray();
        }
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(map[i][j]=='F'){
                    A=new Entity(i,j);
                    map[i][j]='.';
                }else if(map[i][j]=='C'){
                    B=new Entity(i,j);
                    map[i][j]='.';
                }
            }
        }
        long time=0;
        while(true){
            A.move(map);
            B.move(map);
            int st=A.getX()+10*A.getY()+100*B.getX()+1000*B.getY()+10000*A.getDirection()+40000*B.getDirection();
            if(state[st]){
                System.out.println(0);
                break;
            }else{
                state[st]=true;
            }
            time++;
            if(A.meet(B)){
                System.out.println(time);
                break;
            }
        }

    }
}

class Entity{
    int originX;
    int originY;
    int x;
    int y;
    int direction;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
        this.originX=x;
        this.originY=y;
        this.direction=0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public void move(char[][] map){
        if(direction==0){
            if(x<=0||map[x-1][y]=='*'){
                direction=1;
            }else{
                x--;
            }
        }else if(direction==1){
            if(y>=9||map[x][y+1]=='*'){
                direction=2;
            }else{
                y++;
            }
        }else if(direction==2){
            if(x>=9||map[x+1][y]=='*'){
                direction=3;
            }else{
                x++;
            }
        }else{
            if(y<=0||map[x][y-1]=='*'){
                direction=0;
            }else {
                y--;
            }
        }
    }

    public boolean meet(Entity o){
        return x == o.x && y == o.y;
    }
}
