package PTA07;
import java.util.Scanner;

public class main01 {
    public static void main(String args[]) {
      People wang=new People();
      int n;
      Scanner input=new Scanner(System.in);
      n=input.nextInt();
      input.close();
      try{  
        wang.setAge(n);
        System.out.println(wang.getAge());
      }
      catch(IntegerException e) {
        System.out.println(e.toString());
      }
      
    }
}

class People {
    private int age=1;
    public void setAge(int age) throws IntegerException{
        if(age > 120){
            throw new IntegerException("too old");
        }else if(age < 0){
            throw new IntegerException("illegal input");
        }else{
            this.age = age;
        }
    }
    public int getAge(){
        return age;
    }
}

class IntegerException extends Exception{
    public IntegerException (String message){
        super(message);
    }
    @Override
    public String toString(){
        return getMessage();
    }
}