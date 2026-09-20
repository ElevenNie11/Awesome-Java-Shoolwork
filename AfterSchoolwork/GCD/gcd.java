package AfterSchoolwork.GCD;
import java.util.Scanner;

public class gcd {
    public static int GCD(int a, int b){
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
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
