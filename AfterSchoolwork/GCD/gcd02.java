package AfterSchoolwork.GCD;
import java.util.Scanner;

public class gcd02 {
    public static int GCD(int a, int b){
        int gcd = 1;
        for(int i = 1; i <= a && i <= b; i++){
            if(a % i == 0 && b % i == 0){
                gcd = i;
            }
        }
        return gcd;
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
