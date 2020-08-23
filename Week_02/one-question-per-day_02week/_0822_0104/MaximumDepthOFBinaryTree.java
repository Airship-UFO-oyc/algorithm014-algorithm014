package _2020._08._22._0104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 * ----------------------------
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 返回它的最大深度 3 。
 * -------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class MaximumDepthOFBinaryTree {


    //Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    //[1]递归
//    static public int maxDepth(TreeNode root) {
//        if(null==root) return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

    //[2]非递归：广度优先遍历，使用队列
    static public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {//每当同一层的节点，全部出队时，进行下一层的遍历.
                TreeNode tempNode = queue.poll();
                if (null != tempNode.left) queue.offer(tempNode.left);//左节点入队
                if (null != tempNode.right) queue.offer(tempNode.right);//右节点入队
                size--;
            }
            depth++;
        }
        return depth;
    }

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(maxDepth(n1));
    }

}

