package com.xworkz.coding;

import java.util.Scanner;

public class EvenOddCheck {
    public static void main(String[] args) {


        Scanner input=new Scanner(System.in);
        System.out.println("Enter the Input");
        int num= input.nextInt();
        if(num%2==0)
        {
            System.out.println("Is an even  number");
        }
        else
        {
            System.out.println("Is an Odd numder");
        }
    }


}
