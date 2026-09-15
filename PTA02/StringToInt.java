// 完成Transform方法，把一个由数字组成的字符串（String类型）转化为整型的数组。如果其中有其他字符，则整型对应的位置用“0”填充。
package PTA02;
import java.util.Scanner;

public class StringToInt{
    // 作答函数
    public static void Transform(String source, int[] output){
        for(int i = 0; i < source.length(); i++){
            char ch = source.charAt(i);
            if(ch >= '0' && ch <= '9'){
                output[i] = ch - '0';   // 把字符数转换成真正整数的方法：'7'-'0'=7 
            }else{
                output[i] = 0;
            }
        }
    }
    // PTA已给的主函数
    public static void main(String[] args) {
        String source;
        Scanner input = new Scanner(System.in);
        source = input.nextLine();
        input.close();
        int[] output = new int[source.length()];
        Transform(source,output);
        for(int i=0;i<source.length();i++) {
              System.out.printf("%d",output[i]);
          }
    }
}
