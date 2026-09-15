# Java作业合集&重要知识的笔记

## 递归Recursion
### 定义
递归就是函数自己调用自己，把一个大问题拆解成“规模更小的同类问题”，小到能直接给出答案为止
### 必备要素
- 终止条件（base case）：当问题小到不能再小的时候，直接返回结果，不再继续递归（防止无限递归）
- 递归条件（recursive case）
### 例一：阶乘factorial
```
  //递归经典问题：阶乘（递归就是函数自己调用自己）
  // n! = n × (n-1) × (n-2) × ... × 1
  import java.util.Scanner;
  
  public class Recursion_factorial{
      static int factorial(int num){
          if(num == 0 || num == 1){  //base case(基线条件/终止条件)
              return num;
          }
          return num*factorial(num - 1); //recursion case(递归条件)
      }
      public static void main(String[] args){
          Scanner Input = new Scanner(System.in);
          System.out.print("请输入数字：");
          int num = Input.nextInt();
          System.out.print("阶乘结果为：" + factorial(num));
          Input.close();
      }
  }
```
<img width="1710" height="256" alt="image" src="https://github.com/user-attachments/assets/e3df8d9b-c5a0-4e06-9ebe-b28ca267276a" />

### 分解：递归的两个阶段
- “下潜”：一路调用自己，不断把问题变小，直到碰到base case
- “回溯”：base case算出结果之后，一层层**把结果往上传**，最终组装出最初问题的答案

### 递归的执行顺序
递归的执行顺序，本质上就是在用“栈(stack)”这个结构：*递归的每一层调用都会在调用栈里压入一个新的栈帧（记录这一层的局部变量、参数、返回地址）*
```
  factorial(1)  → 栈顶（最新调用，最先返回）
  factorial(2)
  factorial(3)
  factorial(4)
  factorial(5) → 栈底（最早调用，最后返回）
```
调用栈空间是有限的，如果base case设置错误或者没有，函数会无限往下调用，栈帧会越堆越多，最终耗尽栈空间而崩溃，这就是“**栈溢出**（StackOverflow）”

### 例二：斐波那契数列fibonacci
```
package Java;
import java.util.Scanner;

public class Practice03_Fibonacci{
    static int Fibonacci(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
    public static void main(String[] args){
        Scanner Input = new Scanner(System.in);
        System.out.print("请输入一个数字：");
        int n = Input.nextInt();
        System.out.printf("斐波那契数列函数Fibonacci(%d)的值：%d", n, Fibonacci(n));
        Input.close();
    }
}
```
<img width="1626" height="220" alt="image" src="https://github.com/user-attachments/assets/f7d6208e-887e-4563-a48f-6ef95c3b53f1" />
