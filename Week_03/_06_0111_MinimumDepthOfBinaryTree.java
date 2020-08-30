package homework._03week;


/**
 * 111. 二叉树的最小深度
 * ----------------------------
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例:
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最小深度  2.
 * -----------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _06_0111_MinimumDepthOfBinaryTree {


    // Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //[1]递归：暴力递归
    public int minDepth(TreeNode root) {
        if (null == root) return 0;//递归出口：必须到叶子结点，而不是到null结点！
        //下一步：计算左右子树的深度，取最小值;
        int d1 = minDepth(root.left);
        int d2 = minDepth(root.right);
        return null == root.left || null == root.right ? d1 + d2 + 1 : Math.min(d1, d2) + 1;
    }


    public static void main(String args[]) {


    }
}