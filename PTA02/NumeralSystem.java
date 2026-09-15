// 递归思想
// 十五进制在数学中是一种逢15进1的进位制。
// 一般用数字0到9和字母A到E表示，其中:A ~ E表示10 ~14，这些称作十五进制数字。
// 输入为一个十进制的正数（可以是多位），输出是其十五进制的值。

package PTA02;
import java.util.Scanner;

public class NumeralSystem {
    public static void fun(int n){
        if(n == 0){
            return;  //然后递归开始返回
        }
        fun(n / 15);
        int remainder = n % 15;
        if(remainder < 10){
            System.out.print(remainder);
        }else{
            char charNum = (char)('A' + remainder - 10);
            System.out.print(charNum);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        fun(n);
    }
}
