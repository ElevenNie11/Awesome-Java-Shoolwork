package AfterSchoolwork.BubbleSort;
import java.util.Scanner;

// [从小到大排序]冒泡排序每完成一轮，通常会把当前未排序部分的最大元素移到右边
public class bubblesort {
     // 冒泡排序函数
    public static void bubbleSort(int[] arr){
        for(int i = arr.length - 1; i >= 1; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for(int i = 0; i < 6; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        bubbleSort(arr);    // 调用排序函数
        // 输出结果
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    } 
}
