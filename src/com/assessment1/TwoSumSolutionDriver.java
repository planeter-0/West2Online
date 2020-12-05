package com.assessment1;

import java.util.Date;

public class TwoSumSolutionDriver {
    public static void main(String[] args){
        Date start = new Date();
        TwoSumSolution a=new TwoSumSolution();
        int[] arr =new int[1000000000];//十亿
        for(int i=0;i<1000000000;i++)
            arr[i]=(int)(Math.random()*10000);

        a.twoSum(arr,100);
        Date end = new Date();
        System.out.println("Time:"+(end.getTime()-start.getTime())+"ms");
    }
}
