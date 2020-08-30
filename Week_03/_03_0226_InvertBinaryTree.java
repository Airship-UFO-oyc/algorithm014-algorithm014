package homework._03week;


/**
 * 226. 翻转二叉树
 * ----------------------------
 * 翻转一棵二叉树。
 * 示例：
 * 输入：
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * ---------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _03_0226_InvertBinaryTree {


    // Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //[1]递归：递归+剪枝
    public TreeNode invertTree(TreeNode root) {
        if (null == root) return root;
        helper(root.left, root.right, root);
        return root;
    }

    private void helper(TreeNode leftNode, TreeNode rightNode, TreeNode root) {
        if (null == leftNode && null == rightNode) return;//递归出口
        //处理
        root.left = rightNode;
        root.right = leftNode;
        //下一步
        if (null != root.left) helper(root.left.left, root.left.right, root.left);//交换左子树.
        if (null != root.right) helper(root.right.left, root.right.right, root.right);//交换右子树.
        //恢复现场
    }


    public static void main(String args[]) {


    }
}