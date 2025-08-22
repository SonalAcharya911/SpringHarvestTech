package com.xworkz.interview.runner;

import lombok.ToString;

import java.util.*;


public class IntervalRunner {

    static Set<Integer[]> integerSet;

    @Override
    public String toString() {

        return super.toString();
    }

    public static void main(String[] args) {


        List<ArrayList> list=null;

        ArrayList<Integer> arrayList1=new ArrayList();

        arrayList1.add(1);
        arrayList1.add(2);




        Set<Integer[]> interval1=null;
        List<Integer> interval2=null;
        Integer[] interval3={8,10};
        Integer[] interval4={15,18};

        Set<Integer[]> integers=new HashSet<>();
        integers.add(new Integer[]{1, 3});
        integers.add(new Integer[]{2, 6});
        integers.add(new Integer[]{8, 10});
        integers.add(new Integer[]{15, 16});



        for(Integer[] nums: integers){
            for(int i=0;i< nums.length; i=i+2){
                System.out.println(nums[i]);

                if(nums[i]<nums[i-1]){

                }
            }



        }

//        Integer[][] intervals={interval1,interval2,interval3,interval4};
//        for(int i=0; i<=intervals.length;i++){
//            for(int j=i+1; j<intervals[0].length;j++){
//                System.out.println(intervals[i][j]);
//            }
//        }

















    }
}
