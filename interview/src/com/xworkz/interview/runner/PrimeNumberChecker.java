package com.xworkz.interview.runner;

import java.util.Scanner;

public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number to check if prime: ");
        int num= scanner.nextInt();
        boolean isPrime=isPrime(num);
        if(isPrime){
            System.out.println(num+" is a prime number");
        }
        else{
            System.out.println(num+" is not a prime number");
        }
    }

    public static boolean isPrime(int num){
        for(int i=2;i<num/2; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
