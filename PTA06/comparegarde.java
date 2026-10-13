package PTA06;
import java.util.Scanner;

// 接口
interface Comparable {                            
    int compareTo(Student student);
}

class Student implements Comparable{
    private String name;
    private int score;
    public Student(String name, int score){
        this.name = name;
        this.score = score;
    }
    @Override
    public int compareTo(Student stu){
        int result = this.score - stu.score;
        return result;
    }
}

public class comparegarde {
    public static void main(String[] args) {                
        Scanner input = new Scanner(System.in);
        Student p1=new Student("张三", 88);
        String name = input.next();
        int score = input.nextInt();
        Student p2 = new Student(name,score);
        System.out.println(p1.compareTo(p2));
        input.close();
    }
}
