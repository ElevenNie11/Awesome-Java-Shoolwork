package PTA07;

import java.util.Scanner;

public class main06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double weight = input.nextDouble();
        double height = input.nextDouble();
        Bmi test = new Bmi();
        try{  
            test.setBmi(weight, height);
            System.out.println(test.getBmi());
        }catch(BmiException e){
            System.out.println(e.toString());
        }
        input.close();
    }
}

class Bmi{
    private double bmi;
    public void setBmi(double weight, double height) throws BmiException{
        double result = weight / (height * height);
        if(result < 18.5){
            throw new BmiException("Underweight");
        }else if(result <= 24){
            this.bmi = result;
        }else if(result <= 30){
            throw new BmiException("Overweight");
        }else{
            throw new BmiException("Obese");
        }
    }

    public double getBmi(){
        return bmi;           
    }
}

// 定义一个自定义异常类 BmiException，继承自 Exception
class BmiException extends Exception{
    // 构造方法：接收一个字符串作为异常提示信息
    // 把信息传给父类Exception，父类保存了，后面getMessage()就可以看到
    public BmiException(String message){
        super(message);
    }
    // 重写 toString 方法
    @Override 
    public String toString(){
        // 返回异常信息
        // 原本Exception的toString()默认输出：“异常类名：异常信息”
        // 但是这里重写之后，直接只返回异常消息本身，不会带上异常类名
        return getMessage();
    }
}