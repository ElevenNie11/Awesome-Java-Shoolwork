package PTA06;
import java.util.Scanner;

public class palindrome {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        // 用 StringBulider 保存过滤后的字符串
        StringBuilder sb = new StringBuilder();
        // 遍历原字符串
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            // 判断是否为非字母或数字字符
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));  // 转成小写 避免大小写影响
            }
        }
        // 双指针判断回文
        int left = 0;
        int right = sb.length() - 1;
        boolean flag = true;
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                flag = false;
                break;
            }
                left++;
                right--;
        }
        System.out.println(flag);
    }
}