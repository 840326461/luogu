package CMU.Q4;

import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(3, "1A 1B,2C 2C", "1B"));
    }

    public String solution(int N, String S, String T) {
        Cell[][] board=new Cell[N][N];
        String[] shipsLoc=S.split(",");
        String[] hits=T.split(" ");
        ArrayList<Ship> ships=new ArrayList<>();

        //init board
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                board[i][j]=new Cell();
            }
        }

        for (String shipLoc:shipsLoc){
            int[] index=processShip(shipLoc);
            Ship ship=new Ship();
            for (int i=index[0];i<=index[2];i++){
                for (int j=index[1];j<=index[3];j++){
                    ship.addCell(board[i][j]);
                }
            }
            ships.add(ship);
        }

        for (String hit :hits) {
            int[] index=processCell(hit);
            board[index[0]][index[1]].setHit(true);
        }

        int sunken=0;
        int hit=0;
        for (Ship ship:ships) {
            int status=ship.sunk();
            if(status==1){
                hit++;
            }else if(status==2){
                sunken++;
            }
        }
        return sunken+","+hit;
    }

    //return x1,y1,x2,y2
    private int[] processShip(String loc){
        String[] pair=loc.split(" ");
        int[] result=new int[4];
        int[] pair1=processCell(pair[0]);
        int[] pair2=processCell(pair[1]);
        result[0]=pair1[0];
        result[1]=pair1[1];
        result[2]=pair2[0];
        result[3]=pair2[1];
        return result;
    }

    private int[] processCell(String loc){
        int[] result=new int[2];
        result[0]=Integer.parseInt(loc.substring(0,loc.length()-1))-1;
        result[1]=loc.charAt(loc.length()-1)-0x41;
        return result;
    }
}

class Cell{
    private boolean hit;

    public Cell() {
        this.hit = false;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }
}

class Ship{
    private ArrayList<Cell> ship;

    //0 for not hit, 1 for hit but not sunk, 2 for sunk
    public int sunk(){
        boolean hit=false;//hit cell exist
        boolean notHit=false;//notHit cell exist
        for (Cell c:ship) {
            if (!c.isHit()){
                notHit=true;
            }else{
                hit=true;
            }
        }
        if(hit&&notHit){
            return 1;
        }else if(!notHit){
            return 2;
        }else {
            return 0;
        }
    }

    public Ship() {
        this.ship = new ArrayList<>();
    }

    public void addCell(Cell cell){
        ship.add(cell);
    }
}