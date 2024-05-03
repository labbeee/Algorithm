import java.util.*;

public class bagProblem {

    public static void main(String[] args) {
        // 背包容量 N
        // 物品种类 M
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] values = new int[M];
        int[] weights = new int[M];

        for(int i = 0; i < M;i++) {
            weights[i] = sc.nextInt();
        }


        for(int i = 0; i < M;i++) {
            values[i] = sc.nextInt();
        }
        //方式1：二维数组
//        int[][] dp = new int[M][N+1];  //表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
//
//        // 初始化
//        for(int i = weights[0]; i <= N; i++) {
//            dp[0][i] = values[0];
//        }
//
//        // 先物品
//        for(int i = 1; i < M; i++) {
//            // 后背包
//            for(int j = 0; j <= N; j++) {
//                if(weights[i] > j) {
//                    dp[i][j] = dp[i-1][j];
//                } else {
//                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]] + values[i]);
//                }
//            }
//        }
//        System.out.println(dp[M-1][N]);

        //方式2：一维滚动数组
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[N + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for(int i = 0; i < M; i++){
            for(int j = N; j >= weights[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        System.out.println(dp[N]);
    }
}