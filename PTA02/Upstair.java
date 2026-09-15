// 递归思想
// 楼梯有n阶台阶，上楼可以一步上1阶，也可以一步上2阶，也可以一步上3阶，编一程序计算共有多少种不同的走法
// 输入楼梯的台阶数，输出有多少种走法
package PTA02;
import java.util.Scanner;

public class Upstair {
    public static int fun(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return fun(n - 1) + fun(n - 2) + fun(n - 3);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(fun(n));
    }
}