import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class HW_1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numsStr = scanner.nextLine().split(" ");
        int target = scanner.nextInt();

        int[] nums = new int[numsStr.length];
        for (int i = 0; i < numsStr.length; i++) {
            nums[i] = Integer.parseInt(numsStr[i]);
        }

        TreeNode root = buildBST(nums);
        String path = searchPath(root, target);

        System.out.println(path);
    }

    private static TreeNode buildBST(int[] nums) {
        Arrays.sort(nums); // 将数字进行排序，确保构建的二叉搜索树是平衡的
        return buildBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode buildBSTHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBSTHelper(nums, start, mid - 1);
        node.right = buildBSTHelper(nums, mid + 1, end);

        return node;
    }

    private static String searchPath(TreeNode root, int target) {
        StringBuilder path = new StringBuilder();
        TreeNode curr = root;

        path.append("S"); // 添加根节点标记

        while (curr != null) {
            if (target == curr.val) {
                path.append("Y");
                break;
            } else if (target < curr.val) {
                path.append("L");
                curr = curr.left;
            } else {
                path.append("R");
                curr = curr.right;
            }
        }

        if (curr == null) {
            path.append("N");
        }

        return path.toString();
    }
}