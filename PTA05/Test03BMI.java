package PTA05;
import java.util.Scanner;

class BMI{
    private String name;
    private int age;
    private double weight;
    private double height;
    BMI(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }
    public String getName(){
        return name;
    }
    public double getBMI(){
        double weightBMI = weight * 0.45359237;
        double heightBMI = height * 0.0254;
        double BMI = weightBMI / (heightBMI * heightBMI);
        return Math.round(BMI * 100) / 100.0;
    }
    public String getStatus(){
        double BMI = getBMI();
        if(BMI < 18.5){
            return "Underweight";
        }else if(BMI<25.0){
            return "Normal";
        }else if(BMI < 30){
            return "Overweight";
        }else{
            return "Obese";
        }
    }
}

public class Test03BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        int age = input.nextInt();
        double weight = input.nextDouble();
        double height = input.nextDouble();
        input.close();

        BMI bmi1 = new BMI(name, age, weight, height);
        System.out.println("The BMI for " + bmi1.getName() + " is " + bmi1.getBMI() + " " + bmi1.getStatus());
    }
}