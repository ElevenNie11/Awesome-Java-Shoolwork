package AfterSchoolwork.BubbleSort;
import java.util.Scanner;
// [从小到大排序]冒泡排序每完成一轮，通常会把当前未排序部分的最大元素移到右边
// 类名不可以用连字符-（eg：bubblesort-optimization）
// change标志变量的提前结束外层循环标志
public class bubblesort_optimization{
    // 冒泡排序函数
    public static void bubbleSort(int[] arr){
        boolean change = true; // change表示这一轮是否发生交换
        // 外层循环：每一轮确定一个最大值
        // eg: 2 3 4 5 1 6
        // 比较第一轮：2 3 4 5 1 6     6
        // 比较第二轮：2 3 4 5 1       5
        // 比较第三轮：2 3 4 1         4
        // 比较第四轮：2 3 1           3
        // 比较第五轮：2 1             2
        // 比较第六轮：1               1（不用比较，因为只剩1了）
        for(int i = arr.length - 1; i >= 1; i--){
            // 每一轮开始时，假设还没发生过交换
            change = false;
            // 内层循环：比较相邻的两个元素
            for(int j = 0; j < i; j++){
                // 如果前面的数比后面的数大，就交换
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 说明这一次发生了交换
                    change = true;
                }
            }
            // 如果这一轮一次交换都没有发生，说明数组已经有序
            // eg：1 2 3 4 5 6
            if(!change){
                break;
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
        // 输出排序后的数组
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}