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

class BmiException extends Exception{
    public BmiException(String message){
        super(message);
    }
    @Override 
    public String toString(){
        return getMessage();
    }
}