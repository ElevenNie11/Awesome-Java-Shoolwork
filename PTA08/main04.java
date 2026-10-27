package PTA08;

import java.util.Scanner;

public class main04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        input.close();
        System.out.print(Card24.count(x));
    }
}

class Card24{
    public static int count(int x){
        if(x < 4){
            return 0;
        }
        return x * (x + 1) * (x + 2) * (x + 3) / 24;
    }
}