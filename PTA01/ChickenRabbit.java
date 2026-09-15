package PTA01;
// x+y = head
// 2x+4y = foot
// x=2head-foot/2
// y=foot/2-head
import java.util.Scanner;
public class ChickenRabbit{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        long head = input.nextLong();               // 注意变量类型为long
        long foot = input.nextLong();
        input.close();
        // 全是鸡：foot < 2*head
        // 全是兔：foot > 4*head
        if(foot<2*head || foot>4*head || foot%2!=0){
            System.out.println("no answer");
        }else{
            long chicken = 2*head - foot/2;         // 注意变量类型为long
            long rabbit = head - chicken;
            System.out.println(chicken + " " + rabbit);
        }
    }
}