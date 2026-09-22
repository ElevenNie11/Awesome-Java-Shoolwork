package PTA04;

import java.util.Scanner;

public class weekday {
    public static int getStartDay(int year, int month){
        int totalDays = 0;
        for(int i = 1800; i < year; i++){
            if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0){
                    totalDays += 366;
            }else{
                    totalDays += 365;
            }
        }
    
        int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] normalDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            for(int i = 0; i < month - 1; i++){
                totalDays += leapDays[i];
            }
        }else{
            for(int i = 0; i < month - 1; i++){
                totalDays += normalDays[i];
            }
        }

        // 计算这是星期几（每个月的一号）
        // 1800年1月1日是星期三
        int weekday = (totalDays + 3) % 7;
        return weekday;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        input.close();
        System.out.println(getStartDay(year, month));
    }
}