package PTA06;
import java.util.Scanner;

public class palindrome2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        int left = 0;
        int right = line.length() - 1;
        boolean isPalindrome = true;
        while(left < right){
            if(!Character.isLetterOrDigit(line.charAt(left))){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(line.charAt(right))){
                right--;
                continue;
            }
            if(line.charAt(left) != line.charAt(right)){
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(isPalindrome);
    }
}
