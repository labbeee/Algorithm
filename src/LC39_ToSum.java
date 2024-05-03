import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LC39_ToSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入格式为：第一行（数量没有限制）：1 2 3 4 5，第二行 2
        ArrayList<Integer> list = new ArrayList<>();
        String[] str = sc.nextLine().split(" ");
        for (String element : str) {
            list.add(Integer.parseInt(element));
        }
        //System.out.println(list);
        //列表转化为Integer[]数组，list.toArray()好像只能转化为包装类Integer[]
        //Integer[] candidates = list.toArray(new Integer[list.size()]);
        //列表转化为int[]数组
        int[] candidates = new int[list.size()];
        int i = 0;
        for (Integer num : list){
            candidates[i] = num;
            i++;
        }

        int target = sc.nextInt();
        List<List<Integer>> result = combinationSum(candidates, target);

        //二维列表的遍历
//        for (List<Integer> l1 : result){
//            for (Integer l2 : l1){
//                System.out.println(l2 + " ");
//            }
//        }
        System.out.println(result);  //list中实现了toString()， 所以可以直接打印

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 先进行排序
        backtracking(res, new ArrayList<>(), candidates, target, 0, 0);
        return res;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int sum, int idx) {
        // 找到了数字和为 target 的组合
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            path.add(candidates[i]);
            backtracking(res, path, candidates, target, sum + candidates[i], i);
            path.remove(path.size() - 1); // 回溯，移除路径 path 最后一个元素
        }
    }
}
