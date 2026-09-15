package PTA02;
import java.util.Scanner;

public class StringAlign {
    // 作答函数
    public static void Transform(String tempa, String tempb, int[] a, int[] b){
        int c  = Math.max(tempa.length(), tempb.length());
        for(int i = 0; i < tempa.length(); i++){
            a[c - tempa.length() + i] = tempa.charAt(i) - '0'; // 必须转换成整数
        }
        for(int i = 0; i < tempb.length(); i++){
            b[c - tempb.length() + i] = tempb.charAt(i) - '0';
        }
    }

    // PTA已给的函数
    public static void main(String[] args){
        String tempa, tempb;
        
        Scanner input = new Scanner(System.in);
        tempa = input.nextLine();
        tempb = input.nextLine();
        input.close();
        int c = Math.max(tempa.length(), tempb.length());
        int[] a = new int[c] ;   // 里面所有元素会全部自动初始化为0
        int[] b = new int[c];
        Transform(tempa, tempb, a, b);
        for(int i=0;i<c;i++) {
            System.out.printf("%d",a[i]);
        }
        System.out.println();
        for(int i=0;i<c;i++) {
            System.out.printf("%d",b[i]);
        }
    }
}
