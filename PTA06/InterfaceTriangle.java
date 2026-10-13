package PTA06;
import java.text.DecimalFormat;

interface Ishape {
    public abstract double getArea();
    public abstract double getPerimeter();
}

class Triangle implements Ishape{
    private double a;
    private double b;
    // 构造方法
    public Triangle(double a, double b){
        this.a = a;
        this.b = b;
    }
    // 求面积
    @Override 
    public double getArea(){
        return a * b / 2;
    }
    // 求周长
    @Override 
    public double getPerimeter(){
        double c = Math.sqrt(a * a + b * b);
        return a + b + c;
    }
}

public class InterfaceTriangle {
    public static void main(String[] args) {
        DecimalFormat d = new DecimalFormat("#.####");
        Ishape r = new Triangle(3.1, 4.2);
        System.out.println(d.format(r.getArea()));
        System.out.println(d.format(r.getPerimeter()));
    }
}
