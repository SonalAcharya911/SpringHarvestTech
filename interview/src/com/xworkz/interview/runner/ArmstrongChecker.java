package com.xworkz.interview.runner;

import java.util.Scanner;

public class ArmstrongChecker {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number to check: ");
        int num=sc.nextInt();
        if(isArmstrong(num)){
            System.out.println(num+" is an armstrong number");
        }
        else{
            System.out.println(num+" is not an armstrong number");
        }
    }

    public static boolean isArmstrong(int num) {
        int digit = 0;
        int armstrong = 0;
        int originalNum=num;

        int length = String.valueOf(num).length();

        for (int i = 0; i < length; i++) {
            digit = num % 10;
            armstrong = armstrong + (int) Math.pow(digit, length);
            num = num / 10;
        }

        if(originalNum==armstrong){
            return true;
        }
        return false;



    }
}
