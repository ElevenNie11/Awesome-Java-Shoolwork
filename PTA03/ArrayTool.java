package PTA03;
import java.util.*;

class MyArrays{
    // 必须加 static（因为在主程序里没有创建MyArrays对象，而是直接调用方法，所以必须加上static）
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println();
    }

    // 从小到大排序
    public static void sortArray(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 求和
    public static int sumOfArray(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
}

public class ArrayTool{
     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int array[]= new int[n];
        for(int i=0;i<n;i++)
        {
            array[i]=sc.nextInt();
        }
        
        MyArrays.printArray(array);        // 显示数组的内容
        MyArrays.sortArray(array);         // 对数组元素排序
        MyArrays.printArray(array);        // 显示排序后的结果
        int sum=MyArrays.sumOfArray(array);// 数组元素求和
        System.out.println(sum);           // 显示数组元素的和
        sc.close();

    }
}