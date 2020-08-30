package homework._03week;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 236. 二叉树的最近公共祖先
 * ----------------------------
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 示例 1:
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * ----
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 说明:
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * -------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _08_0236_LowestCommonAncestorOfABinaryTree {

    // Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * root是p，q的最近公共祖先，只可能为以下情况之一：
     * 1、p和q在root的子树中，并且分别在root的左右子树中。
     * 2、p=root，并且q在root的左或右子树中。
     * 3、q=root，并且p在root的左或右子树中。
     */
    //[1]递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口：当root越过叶节点时，则直接返回null；当root等于p，q，则直接返回 root。
        if (null == root || root == p || root == q) return root;
        //处理 //下一层
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null == left && null == right) return null;
        if (null == left) return right;
        if (null == right) return left;
        //恢复现场
        return root;
    }

    public static void main(String args[]) {
//        _08_0236_LowestCommonAncestorOfABinaryTree test = new _08_0236_LowestCommonAncestorOfABinaryTree();
//        System.out.println(test.lowestCommonAncestor()));
    }
}