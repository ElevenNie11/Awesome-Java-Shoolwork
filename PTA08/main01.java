package PTA08;

import java.util.Scanner;

public class main01 {
    public static void main(String args[]) {
        int i,j;
        Scanner sc=new Scanner(System.in);
        i=sc.nextInt();
        j=sc.nextInt();
        sc.close();

        Circle circle=new Circle(i);
        Cone<Circle> coneOne=new Cone<Circle>(circle);//创建一个（圆）锥对象  
        coneOne.setHeight(j);
        System.out.printf("%.2f\n",coneOne.computerVolume());  
      }
}

class Circle{
    private int radius;
    public Circle(int radius){
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
}

// 泛型
// T是类型参数，代表底面对象的类型
// extends Circle限定 T 必须是Circle或其子类
// 因为限定了类型，所以可以直接调用bottom.getArea()
// 如果只写 class Cone<T>，编译器就无法确定 T 一定具有 getArea() 方法
class Cone<T extends Circle>{
    private T bottom;
    private int height;
    public Cone(T bottom){
        this.bottom = bottom;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public double computerVolume(){
        double volumn = bottom.getArea() * height / 3.0;
        return volumn;
    }
}