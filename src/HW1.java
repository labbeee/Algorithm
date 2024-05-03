import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Scanner;

public class HW1 {
    static ArrayList<String> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s1 : s) {
            list.add(Integer.parseInt(s1));
        }
        //System.out.println(list);
        int[] tarNums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            tarNums[i] = list.get(i);
        }
        //System.out.println(Arrays.toString(tarNums));
        int tar = sc.nextInt();
        //System.out.println(tar);
        res.add("S");
        TreeNode root = buildBalanceBST(tarNums);
        TreeNode sea = search(root, tar);
        if(sea != null){
            res.add("Y");
        }else{
            res.add("N");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size();i++){
            sb.append(res.get(i));
        }
        System.out.println(sb);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildBalanceBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }

    public static TreeNode search(TreeNode root, int tar) {
        if (root == null ||root.val == tar) {
            return root;
        }
        if(root.val < tar){
            res.add("L");
            return search(root.left, tar);

        }else{
            res.add("R");
            return search(root.right, tar);
        }
    }

}



