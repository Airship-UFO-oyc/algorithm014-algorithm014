package homework._02week;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * ----------------------------
 * 给定一个二叉树，返回它的 前序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * -----------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0144_BinaryTreePreorderTraversal {


    //Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    //递归体（前序遍历）
//    static public void helper(TreeNode root, List<Integer> results) {
//        if (null == root) return;//递归出口
//        results.add(root.val);//遍历根节点
//        helper(root.left, results);//前序遍历左子树
//        helper(root.right, results);//前序遍历右子树
//    }
//
//    //方案一：递归（前序遍历）
//    static public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> results = new ArrayList<>();
//        helper(root, results);
//        return results;
//    }


    //方案二：非递归（前序遍历）
    static public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (null != current || !stack.isEmpty()) {
            while (null != current) {
                results.add(current.val);
                 stack.push(current);
                current = current.left;
            }
            TreeNode temp = stack.pop();
            current = temp.right;
        }
        return results;
    }

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        System.out.println(preorderTraversal(n1).toString());
    }
}