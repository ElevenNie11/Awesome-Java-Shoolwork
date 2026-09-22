package PTA04;

import java.util.Scanner;

public class Alldays {
    public static int getTotalNumberOfDays(int year, int month){
        // 先计算 1800 年到输入年份前一年的所有天数
        int totalDays = 0;
        for(int i = 1800; i < year; i++){
            if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0){
                    totalDays += 366;
            }else{
                    totalDays += 365;
            }
        }
        // 再算月份
        int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] normalDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // if判断输入的年份是否为闰年
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            // for循环开始计算本年天数
            // 注意题目要求不计算本月（比如用户输入10，就不计算10月份的天数）天数
            for(int i = 0; i < month - 1; i++){
                totalDays += leapDays[i];
            }
        }else{
            for(int i = 0; i < month - 1; i++){
                totalDays += normalDays[i];
            }
        }
        return totalDays;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        input.close();
        System.out.println(getTotalNumberOfDays(year, month));
    }
}
