import java.util.*;
//WangYiLeiHuo_330_1
public class WangYiLeiHuo_330_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 雷火的员工数量
        int[] arr = new int[N]; // 每个员工今年达到的司龄
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int[] res = new int[4];
        for (int i = 0; i < N; i++)
        {
            if (arr[i] == 1)res[0]++;
            else if (arr[i] == 2)continue;
            else if (arr[i] == 3)res[1]++;
            else if (arr[i] == 4)res[0]++;
            else if (arr[i] == 5)res[0]++;
            else if (arr[i] == 6) { res[0]++; res[1]++; res[2]++; }
            else if (arr[i] == 7) { res[0]++; res[1]++; }
            else if (arr[i] == 8) { res[0]++; res[1]++; }
            else if (arr[i] == 9) { res[0]++; res[1]++; res[2]++; }
            else if (arr[i] == 10) { res[0]++; res[1]++; res[2]++; res[3]++; }
            else if (arr[i] == 11) { res[0]++; res[1]++; res[2]++; }
            else if (arr[i] == 12) { res[0]++; res[1]++; res[2]++; }
            else if (arr[i] >= 13) { res[0]++; res[1]++; res[2]++; res[3]++; }
        }
        // 输出结果
        for (int i = 0; i < 4; i++) {
            System.out.print(res[i] + " ");
        }
    }
}

