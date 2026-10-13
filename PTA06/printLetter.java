package PTA06;
import java.util.Scanner;

public class printLetter {
    public static void main(String[] args){
        int N,n;
        Scanner input=new Scanner(System.in);
        N=input.nextInt();
        n=input.nextInt();
        input.close();
        InterfaceA a =new Print();
        a.setN(N);
        a.printCapitalLetter();
        InterfaceB b=new Print();
        b.printLowercaseLetter(n);
    }
}

interface InterfaceA {
    void setN(int n);
    void printCapitalLetter();

}
interface InterfaceB {
    void printLowercaseLetter(int n);
}
/* 函数题：请在这里填写答案 */

class Print implements InterfaceA, InterfaceB{
    private int N;
    @Override 
    public void setN(int n){
        this.N = n;
    }
    @Override 
    public void printCapitalLetter(){
        if(N > 26){
            N = N % 26;
        }
        for(int i = 0; i < N; i++){
            System.out.print((char)('A' + i));
        }
        System.out.println();
    }
    @Override 
    public void printLowercaseLetter(int n){
        if(n > 26){
            n = n % 26;
        }
        for(int i = 0; i < n; i++){
            System.out.print((char)('a' + i));
        }
    }
}