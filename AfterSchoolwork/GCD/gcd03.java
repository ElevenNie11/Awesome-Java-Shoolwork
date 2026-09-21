package AfterSchoolwork.GCD;
import java.util.Scanner;
// 更相减损法
public class gcd03 {
    public static int GCD(int a, int b){
        while (a != b){
            if(a > b) 
                a = a - b;   // 大数 - 小数
            if(b > a)
                b = b  - a;  // 大数 - 小数
        }
        return a;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int gcd = GCD(a, b);
        System.out.print("最大公约数：" + gcd);
    }
}
