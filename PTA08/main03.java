package PTA08;
import java.util.LinkedList;
import java.util.Scanner;
// 约瑟夫环
public class main03 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        LinkedList<Integer> list = new LinkedList<Integer>();

        for(int i = 1; i <= a; i++){
            list.add(i);
        }

        for(int i = 1; i < a; i++){
            // 1 2 3移到队尾，4 成了队首
            for(int j = 1; j < b; j++){
                list.addLast(list.removeFirst());
            }
            // 输出队首 4
            System.out.print(list.removeFirst() + " ");
        }
        System.out.println(list.getFirst());
    }
}
