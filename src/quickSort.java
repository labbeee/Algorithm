import java.util.Scanner;

public class quickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            myqucikSort(arr, 0, arr.length - 1);
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);

            }
        }
    }

    public static void myqucikSort(int[] arr, int left, int right) {

        if (left > right) {
            return;
        }
        //定义左右指针，表示要查找的数据的范围
        int i = left;
        int j = right;
        //选取基准数, 通常取第一个元素
        int base = arr[left];
        //第一轮循环：找到基准数在数组应该存入的位置--i==j，然后基准数归位：把基准数和相遇位置的数字进行交换，实现基准数左边的元素都比他小，右边的都比他大。
        while (i != j) {
            //利用j,从右往左找出比基准数小的数字
            while (arr[j] >= base && i < j) {
                j--;
            }
            //利用i, 从左往右找出比基准数要大的数字
            while (arr[i] <= base && i < j) {
                i++;
            }
            //把i和j指向的元素进行交换
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //当i和j相遇时结束循环，表示已经找到基准数在数组中应存入的位置，然后基准数归位。
        arr[left] = arr[i];
        arr[i] = base;
        //基准数左边进行递归
        myqucikSort(arr, left, i - 1);
        //基准数右边进行递归
        myqucikSort(arr, j + 1, right);
    }

}

