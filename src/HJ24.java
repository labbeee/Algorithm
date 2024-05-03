import java.util.Arrays;
import java.util.Scanner;

public class HJ24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
           int n = sc.nextInt();
           int[] arr = new int[n];
           for(int i = 0; i < n; i++){
               arr[i] = sc.nextInt();
           }
            System.out.println(Arrays.toString(arr));
           int[] left = new int[n];  //dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
           int[] right = new int[n];
           left[0] = 1;
           right[n - 1] = 1;
           for(int i = 0; i < n; i++){
               left[i] = 1;
               for (int j = 0; j < i; j++){
                   if(arr[i] > arr[j]){
                       left[i] = Math.max(left[j] + 1, left[i]);
                   }
               }
           }
           for(int i = n - 1; i >= 0;i--){
               right[i] = 1;
               for(int j = n - 1; j > i; j--){
                   if(arr[i] > arr[j]){
                       right[i] = Math.max(right[i], right[j] + 1);
                   }
               }
           }
           int[] result = new int[n];
           for(int i = 0; i < n; i++){
               result[i] = left[i] + right[i] - 1;
           }

           int max = 1;
           for(int i = 0; i< n; i++){
               max = Math.max(result[i], max);
           }
            System.out.println(n - max);
        }
    }
}
