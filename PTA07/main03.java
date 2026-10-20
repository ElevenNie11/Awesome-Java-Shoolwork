package PTA07;

import java.util.Scanner;

public class main03 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int y,m,d;
        y=sc.nextInt();
        m=sc.nextInt();
        d=sc.nextInt();
        sc.close();
        Age father=new Age(1980);
        father.setMonth(2);
        father.setDay(18);
        Age son=new Age(y,m,d);
        try{
            System.out.print(father.Compare(son));
        }catch(AgeException e){
            System.out.println(e.toString());
        }
    }
}

class Age{
    private int year;
    private int month;
    private int day;

    public Age(int year){
        this.year = year;
    }

    public Age(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setMonth(int month){
        this.month = month;
    }

    public void setDay(int day){
        this.day = day;
    }

    public int getYear(){
        return year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int Compare(Age son) throws AgeException{
        int age = son.getYear() - this.year;
        if(son.getMonth() < this.month || son.getMonth() == this.month && son.getDay() < this.day){
            age--;   // 月日还没到，差不满整年，减一岁
        }
        if(age < 20){
            throw new AgeException("too young");
        }else if(age > 70){
            throw new AgeException("too old");
        }
        return age;
    }
}

class AgeException extends Exception{
    public AgeException(String message){
        super(message);
    }

    @Override 
    public String toString(){
        return getMessage();    // 只输出too young / too old，不带类名
    }
}

// 【注意】
// AgeException extends Exception 属于受检异常（checked exception）
// Java规定：方法体内 throw 一个受检异常，要么自己 try-catch 掉，要么必须在方法签名上用 throws 声明