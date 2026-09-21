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
#### ⚠️注意⚠️
当函数执行到“自己调用自己”的地方时，当前这一层函数会暂时停下来，等待下一层函数返回结果。直到达到终止条件，然后再一层一层返回，把之前暂停的计算继续完成！每一层都记住了自己当时还没完成的语句，等下一层返回后继续执行！
```
假设输入：4
第一次调用: factorial(4)
然后执行：return 4 * factorial(3)
但是！这里的 factorial(3) 还没有算出来，所以：4 × ？（这一层**暂停**）
---
进入下一层：
执行：factorial(3)
然后：return 3 * factorial(2);
于是又暂停：3 × ？
---
继续进入：factorial(2)
然后：return 2 * factorial(1);
暂停：2 × ？
---
继续进入：factorial(1)
到达终止条件：return 1;
这时候递归不再继续往下调用了！！！
---
---
开始一层一层“返回”：现在 factorial(1) 返回1
上一层原本是：return 2 * factorial(1);
现在知道：factorial(1) = 1
所以有了：return 2 * 1;
得到：2
然后又返回给factorial(3)
...
factorial(3) = 6;
一直直到回到然后回到factorial(4)：return 4*6;
最终结果：24
```
#### 再举例：
```
static void test(int num){
    if(num == 1){
        return;
    }
    System.out.println("进入：" + num);
    test(num - 1);                    // 递归
    // if语句什么时候执行呢？
    if(num > 1){
        System.out.println("返回：" + num);
    }
}
```
假设输入：4
```
test(4)
 ↓
输出：进入：4
 ↓
test(3)
 ↓
输出：进入：3
 ↓
test(2)
 ↓
输出：进入：2
 ↓
test(1)
 ↓
return
 ↓
回到 test(2)
 ↓
执行 if
输出：返回：2
 ↓
test(2)结束
 ↓
回到 test(3)
 ↓
执行 if
输出：返回：3
 ↓
test(3)结束
 ↓
回到 test(4)
 ↓
执行 if
输出：返回：4
 ↓
test(4)结束
```
\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-\-
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

### 例三：爬楼梯（三阶斐波那契）
```
import java.util.Scanner;

public class Upstair {
    public static int fun(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return fun(n - 1) + fun(n - 2) + fun(n - 3);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(fun(n));
    }
}
```
<img width="1290" height="1031" alt="b33640d13acc6e1a0f152849ff099ccf" src="https://github.com/user-attachments/assets/eefdb555-8851-47df-a3fe-514cdb3087c5" />

#### 执行过程
**调用栈遵循“先一路下探，再逐层返回”**
- fun(4)不会立刻算，而是先问fun(3)
- fun(3)又会先问fun(2)...一直下探到fun(2)、fun(1)、fun(0)这些基准情形直接返回
- 拿到子问题的答案以后，再**一层层往上相加**：fun(3) = 2 + 1 + 1 = 4 ; fun(4) = fun(3) + fun(2) + fun(1) = 4 + 2 + 1 = 7

```
// 基准情形（出口）：问题小到不用再拆，直接给出答案（没有它就会无限递归，栈溢出）
if(n == 0) return 1;
if(n == 1) return 1;
if(n == 2) return 2;
// 递推关系：把问题拆小，继续调用自己
return fun(n - 1) + fun(n - 2) + fun(n -3);
```

### Q；为什么递推式是这三个数相加？
### A：“爬楼梯问题”：一次可以爬1级、2级、3级台阶，问走到第n级有几种走法。
- 最后一步走1级：前面要走完(n - 1)级，一共有fun(n - 1)种走法
- 最后一步走2级：前面要走完(n - 2)级，一共有fun(n - 2)种走法
- 最后一步走3级：前面要走完(n - 3)级，一共有fun(n - 3)种走法
- 三种情况互不重叠，加起来就是总走法

### 递归的代价
fun(2)和fun(1)再树里被算了多次：每个子问题都要从头重新计算一遍，所以本次纯递归的时间复杂度为O(3^n)指数级。n到30左右就会明显卡顿，优化版本就是进行记忆化（把计算过的结果存起来）
```
// 加入记忆化memo[n]
import java.util.Scanner;

public class Upstair_optimization {
    public static int fun(int n, int[] memo){
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;
        if(memo[n] != 0) return memo[n];
        memo[n] = fun(n - 1, memo) + fun(n - 2, memo) + fun(n - 3, memo);
        return memo[n];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n + 1];
        sc.close();
        System.out.println(fun(n, memo));
    }
}
```
---

## 水仙花数：个/十/百位 分割
```
num
个位：num % 10
十位：num / 10 % 10
百位：num / 100
```

---

## 最大公约数Greatest Common Divisor（GCD）
```
例如：12 和 8
- 12的因数：1、2、3、4、6、12
- 8的因数： 1、2、4、8
- 它们共同拥有：1、2、4
- 其中最大的就是：4
- 所以：gcd(12, 8) = 4
```

### gcd的经典写法01：辗转相除法（效率最高）
```
public static int gcd(int num1, int num2){
  while(num2 != 0){
    int temp = num1 % num2;
    num1 = num2;
    num2 = temp;
  }
  return num1;
}
```

### gcd的经典写法02：更相减损法
```
public static int gcd(int num1, int num2){
  while(num1 != num2){
    if(num1 > num2)
        num1 = num1 - num2;     // 大数 - 小数
    if(num2 > num1)
        num2 = num2 - num1;     // 大数- 小数
  }
  return num1;
}
```

### gcd的经典写法03：for循环（算法效率不高）
```
public static int gcd(int num1, int num2){
  int gcd = 1;
  for(int i = 1; num1 % i == 0 && num2 % i ==0; i++){
            gcd = i;
  }
  return gcd;
}
```
