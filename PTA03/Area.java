package PTA03;
import java.util.Scanner;

class Cuboid{
    double l, w, h;
    Cuboid(double l, double w, double h){
        this.l = l;
        this.w = w;
        this.h = h;
    }
    public double getArea(){
        return 2 * (l * w + l * h + w * h);
    }
    public double getVolume(){
        return l * w * h;
    }
}

public class Area {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    double l = input.nextDouble();
    double w = input.nextDouble();
    double h = input.nextDouble();
    Cuboid myCuboid = new Cuboid(l, w, h);
    System.out.printf("%.4f",myCuboid.getArea());
    System.out.println();
    System.out.printf("%.4f",myCuboid.getVolume());

    input.close();
  }
}
