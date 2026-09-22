package PTA04;

import java.util.Scanner;

public class Leapyear {
    public static boolean isLeapYear(int year){
        if(year % 4 == 0 && year % 100 != 0){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        input.close();
        System.out.println(isLeapYear(year));
    }
}
