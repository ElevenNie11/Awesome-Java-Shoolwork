package PTA03;
import java.util.Scanner;
// 考察了最大公约数
class Fraction{
    int numerator;   // 分子
    int denominator; // 分母
    // 构造方法
    Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        // 约分函数，刚输入分子分母的时候就必须先进行约分(要进行约分首先就要找到最大公约数)
        simplify();
    }

    // 寻找两个数的最大公约数gcd
    // 12(a) 34(b)
    // 12 % 34 = 12(temp)
    // 34 % 12 = 10
    // 12 % 10 = 2
    // 10 % 2 = 0
    // 2(2就是gcd) 
    int gcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // 约分
    void simplify(){
        int gcd = gcd(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    // 打印分数
    public void print(){
        if(denominator == 1){
            System.out.print(numerator + " ");
        }else{
            System.out.print(numerator + "/" + denominator + " ");
        }
    }

    // 分数加法（注意返回类型是Fraction类的对象）
    public Fraction plus(Fraction b){
        int newNumerator = numerator * b.denominator + b.numerator * denominator;
        int newDenominator = denominator * b.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    // 分数乘法（注意返回类型是Fraction类的对象）
    public Fraction multiply(Fraction b){
        int newNumerator = numerator * b.numerator;
        int newDenominator = denominator * b.denominator;
        return new Fraction(newNumerator, newDenominator);
    }
}

public class FractionGCD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).print();
        in.close();
    }
}
