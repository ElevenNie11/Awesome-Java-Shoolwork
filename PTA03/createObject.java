package PTA03;

class Student {
    String name;
    int id;
    public Student(){}                      // 无参构造方法
    public Student(String name, int id){    // 有参构造方法
        this.name = name;
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }

    public void setID(int id){
        this.id = id;
    }

    public String toString(){
        return name +  " " + id;
    }
}

public class createObject {
    public static void main(String[] args) {
        Student chen=new Student();
        Student zhang=new Student("Zhang",2018123456);
        chen.setName("Chen");
        chen.setID(2018012345);
        System.out.println(chen.toString());
        System.out.println(zhang.toString());
        
    }
}

// Q：toString难道不是java里内置的函数吗？