package PTA04;

import java.util.Scanner;

public class PrintMonth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year=input.nextInt();
        int month = input.nextInt();
        printMonth(year, month);
        input.close();
    }
    
    public static void printMonth(int year, int month){
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }
    
    public static void printMonthTitle(int year, int month){
        System.out.println("    "+getMonthName(month)+ "  " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    // 1.
    public static String getMonthName(int month){
        String[] monthNames = {"January", "February", "March","April", "May", "June","July", "August", "September","October", "November", "December"};
        return monthNames[month - 1];
    }

    // // 2. 辅助函数：计算本年份当前月份的1号是星期几
    // public static int getStartDay(int year, int month){
    //     int totalDays = 0;
    //     for(int i = 1800; i < year; i++){
    //         if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0){
    //                 totalDays += 366;
    //         }else{
    //                 totalDays += 365;
    //         }
    //     }
    
    //     int[] leapDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //     int[] normalDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    //     if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
    //         for(int i = 0; i < month - 1; i++){
    //             totalDays += leapDays[i];
    //         }
    //     }else{
    //         for(int i = 0; i < month - 1; i++){
    //             totalDays += normalDays[i];
    //         }
    //     }

    //     // 计算这是星期几（每个月的一号）
    //     // 1800年1月1日是星期三
    //     int weekday = (totalDays + 3) % 7;
    //     return weekday;
    // }

    // 3.
    public static void printMonthBody(int year, int month){
        // 获取1号是星期几
        // int startDay = getStartDay(year, month);
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
        int startDay = (totalDays + 3) % 7;

        // 闰年和普通年份该月一共多少天
        int days;
        // int leapDays[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // int normalDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 闰年特判
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)){
            days = leapDays[month - 1];
        }else{
            days = normalDays[month - 1];
        }
        // 打印一号之前的空白部分（按题目要求来）
        // 星期日 = 0
        // 星期一 = 1
        // 星期二 = 2
        // 星期三 = 3
        // 星期四 = 4
        // 星期五 = 5
        // 星期六 = 6
        // 所以这里的 i = 0，不要写成 i = 1 
        for(int i = 0; i < startDay; i++){
            System.out.print("    ");
        }
        // 打印日期
        for(int i = 1; i <= days; i++){
            System.out.printf("%4d", i);
            // 星期六过后换行
            if((startDay + i) % 7 == 0){
                System.out.println();
            }
        }

        // 如果最后一天没有刚好落在星期六，最后补一个换行
        if((startDay + days) % 7 != 0){
            System.out.println();
        }
    }
}
