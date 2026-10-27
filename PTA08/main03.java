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
            for(int j = 1; j < b; j++){
                list.addLast(list.removeFirst());
            }
            System.out.print(list.removeFirst() + " ");
        }
        System.out.println(list.getFirst());
    }
}
