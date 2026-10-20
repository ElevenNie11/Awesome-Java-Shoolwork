package PTA07;

import java.util.Scanner;

public class main05 {
    public class  Main{
    public static void main(String args[]) {
            Scanner input = new Scanner(System.in);
            double x = input.nextDouble();
            double y = input.nextDouble();
            double z = input.nextDouble();
            input.close();
            Triangle test = new Triangle();
            try{  
                test.setTriangle(x, y, z);
                System.out.println(test.getArea());
      }catch(LengthException e){
            System.out.println(e.toString());
      }
    }
}
}

class Triangle{
    private double x;
    private double y;
    private double z;
    
    public void setTriangle(double x, double y, double z) throws LengthException{
        if(x + y <= z || x + z <= y || y + z <= x){
            throw new LengthException("Wrong Length");
        }
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getArea(){
        double p = (x + y + z) / 2;
        double area = Math.sqrt(p * (p - x) * (p - y) * (p - z));
        return area;
    }
}

class LengthException extends Exception{
    public LengthException(String message){
        super(message);
    }
    @Override 
    public String toString(){
        return getMessage();
    }
}