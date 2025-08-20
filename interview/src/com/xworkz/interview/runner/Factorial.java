package com.xworkz.interview.runner;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Enter the number to find the factorial: ");
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int factorial=fact(num);
        System.out.println("Factorial of "+num+ " is "+factorial);
    }
    public static int fact(int num){
        if(num==0 || num==1){
            return 1;
        }
        return num*fact(num-1);
    }
}
