package PTA02;
import java.util.Scanner;

public class Upstair_optimization {
    public static int fun(int n, int[] memo){
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(memo[n] != 0) return memo[n];
        memo[n] = fun(n - 1, memo) + fun(n - 2, memo) + fun(n - 3, memo);
        return memo[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n + 1];
        sc.close();
        System.out.println(fun(n, memo));
    }
}
