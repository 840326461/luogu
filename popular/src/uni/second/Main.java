package uni.second;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String[] list=s.nextLine().split(",");
        int[] nums=new int[list.length];
        for (int i=0;i<list.length;i++){
            nums[i]=Integer.parseInt(list[i]);
        }
        for (int i=0;i<nums.length-1;i++){
            if(nums[i]>=nums[i+1]){
                if(i+2<nums.length){
                    if(nums[i+1]!=nums[i+2]-1){
                        System.out.println(nums[i+1]+","+(nums[i]+1));
                    }else {
                        System.out.println(nums[i]+","+(nums[i-1]+1));
                    }
                }else {
                    System.out.println(nums[i+1]+","+(nums[i]+1));
                }
            }
        }
    }
}
