// 大数相加
// 实现两个大数的加法计算。该题目需要学生实现3个静态方法：Transform( )、BigNumAdd( )、Display()
// public static void Transform(String s1, String s2, int[] a, int[] b)  // 两个数组的对齐处理
// public static int[] BigNumAdd(int[] a, int[] b)                       // 两个数组的加法
// public static void Display(int[] a)
package PTA02;
import  java.util.Scanner;
public class AddtionOfLargeNumbers {
    // 作答函数-Transform
    public static void Transform(String s1, String s2, int[] a, int[] b){
        int c = Math.max(s1.length(), s2.length());
        for(int i = 0; i < s1.length(); i++){
            a[c - s1.length() + i] = s1.charAt(i) - '0';    // 不可以写成s1[i]!!!
        }
        for(int i = 0; i < s2.length(); i++){
            b[c - s2.length() + i] = s2.charAt(i) - '0';
        }
    }
    // 作答函数-BigNumAdd
    public static int[] BigNumAdd(int[] a, int[] b){
        int[] result = new int[a.length + 1];
        int carry = 0;                              // carry是用于专门保存进位的
        for(int i = a.length - 1; i >= 0; i--){
            int sum = a[i] + b[i] + carry;     // 都是从个位开始相加起来的
            result[i + 1] = sum % 10;          // 进十位
            carry = sum / 10;                  // 进位
        }
        result[0] = carry;       // 也许会出现result[0] = 0的情况，所以在Display中要进行处理
        return result;
    }
    // 作答函数-Display
    public static void Display(int[] a){
        int i = 0;
        // 如果当前是0，并且不是最后一位，就要跳过这个0（eg：012434）
        while(a[i] == 0 && i < a.length - 1){
            i++;
        } 
        // 从第一个有效数字开始输出
        for(; i <= a.length - 1; i++){
            System.out.print(a[i]);
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
        int[] a = new int[c] ;
        int[] b = new int[c];
        int[] result = new int[c+1];
        Transform(tempa, tempb, a, b);
        result = BigNumAdd(a,b);
        
        Display(result);
        
    }
}