package homework._02week;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * ----------------------------
 * 给定一个二叉树，返回它的中序 遍历。
 * 示例:
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * ----------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0094_BinaryTreeInorderTraversal {


    //Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归体（中序遍历）
    static public void helper(TreeNode root, List<Integer> results) {
        if (null == root) return;//递归出口
        helper(root.left, results);//中序遍历左子树
        results.add(root.val);//中序遍历根节点
        helper(root.right, results);//中序遍历右子树
    }

//    //方案一：递归（中序遍历）
//    static public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> results = new ArrayList<>();
//        helper(root, results);
//        return results;
//    }

    //方案二：非递归
    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (null == root) return results;
        Stack<TreeNode> stack = new Stack<>();//栈
        TreeNode currentNode = root;
        while (null != currentNode || !stack.isEmpty()) {//当前节点为null，并且栈为空的时候，跳出左子树的遍历
            while (null != currentNode) {
                stack.push(currentNode);//当前节点入栈
                currentNode = currentNode.left;
            }
            TreeNode tempRootNode = stack.pop();
            results.add(tempRootNode.val);//遍历根节点
            currentNode = tempRootNode.right;//遍历右节点
        }
        return results;
    }

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.right = n2;
        n2.left = n3;
        System.out.println(inorderTraversal(n1).toString());
    }
}