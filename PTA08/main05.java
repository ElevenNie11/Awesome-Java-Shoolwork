package PTA08;
import java.util.ArrayList;
import java.util.Scanner;
public class main05 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        /* 请在这里填写答案 */
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            if(num == 0){
                break;
            }
            // 使用 list.contains(num) 判断该数字是否已经出现过
            if(!list.contains(num)){
                list.add(num);
            }
        }
        sc.close();
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
