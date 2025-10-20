package com.xworkz.interview.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetRunner {
    public int[] twoSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> results= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> result=new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        if(!results.contains(result)){
                            results.add(result);
                        }
                    }
                }
            }
        }
        return null;




    }
}
