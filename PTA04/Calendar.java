package PTA04;
import java.util.Scanner;

class MyDate{
    int month, year;
    public MyDate(int year, int month){
        this.month = month;
        this.year = year;
    }

    // 函数1
    public boolean isLeapYear(){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        return false;
    }

    // 函数2
    public int getMonthDay(){
        int[] laepDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] normalDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int day;
        if(isLeapYear()){
            day = laepDays[month - 1];
        }else{
            day = normalDays[month - 1];
        }
        return day;
    }

    // 函数3
    public String getStartDay(){
        int totalDays = 0;
        for(int i = 1800; i < year; i++){
            if(i % 400 == 0 || (i % 4 == 0 && i % 100 != 0)){
                totalDays += 366;
            }else{
                totalDays += 365;
            }
        }
        int[] laepDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] normalDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear()){
            for(int i = 0; i < month; i++){
                totalDays += laepDays[i];
            }
        }else{
            for(int i = 0; i < month; i++){
                totalDays += normalDays[i];
            }
        }
    // 计算星期
        int weekday = (totalDays + 3) % 7;
        String[] week = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        return week[weekday];
    }
}

public class Calendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        int month = input.nextInt();
        input.close();
        MyDate a = new MyDate(year, month);
        System.out.println(a.isLeapYear());
        System.out.println(a.getMonthDay());
        System.out.println(a.getStartDay());
    }
}
