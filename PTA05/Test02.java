package PTA05;

// 构造方法可以有访问修饰符
// 构造方法不能有返回值

class Circle extends Shape{
    private double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public double getArea(){
        double area = Math.PI * radius * radius;
        return area;
    }
}

class Rec extends Shape{
    private double width;
    private double height;
    public Rec(double width, double height){
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        double area = width * height;
        return area;
    }
}

public class Test02 {
    public static void main(String[] args) {
        Shape s1=new Circle(3.0);
        Shape s2=new Rec(4.5,7.6);
        // 计算面积用了统一接口（计算面积的时候也不用管到底是圆形还是矩形在计算）
        System.out.printf("%.3f\n",s1.getArea());
        System.out.printf("%.3f",s2.getArea());
    }
}

// Shape最核心的作用就是：作为所有图形的父类/统一规范
// 它规定了一件事：所有Shape的子类，都必须能够计算面积（所以在Circle和Rec类中都必须实现getArea这个函数）
abstract class Shape{
    abstract double getArea();
}