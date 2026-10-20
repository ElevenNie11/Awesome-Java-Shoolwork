package PTA07;
import java.util.Scanner;

public class main04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String choice = sc.next();
            try {
                if (choice.equals("number"))
                    throw new NumberFormatException();
                else if (choice.equals("illegal")) {
                    throw new IllegalArgumentException();
                } else if (choice.equals("except")) {
                    throw new Exception();
                } else
                break;
            }catch(NumberFormatException e){
                System.out.println("number format exception");
                System.out.println(e);
            }catch(IllegalArgumentException e){
                System.out.println("illegal argument exception");
                System.out.println(e);
            }catch(Exception e){
                System.out.println("other exception");
                System.out.println(e);
            }
        }
        sc.close();
    }
}

// 多种异常捕获 这几个异常之间存在继承：
// Exception
//  └─ RuntimeException
//      └─ IllegalArgumentException
//          └─ NumberFormatException
// 遵循规则：【子类异常在前，父类异常在后，从最具体到最宽泛】
// 所以 Exception作为最上层类型必须放在最后，充当“兜底”分支

// 每个catch里先打印自定义提示，再用System.out.println(e)打印异常信息
// println(e)内部调用 e.toString()，而这些异常都没有传message，所以输出就是“类名”本身