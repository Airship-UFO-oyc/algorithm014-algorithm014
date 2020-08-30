package homework._03week;


import java.util.Arrays;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * ----------------------------
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * ----------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _09_0105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //[1]递归：分治，使用中序遍历的特性判断左右子树.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;//递归出口：前序或中序的序列为空时，则返回null，说明已经完成创建.
        //处理
        TreeNode root = new TreeNode(preorder[0]);//前序遍历的第一个元素即为根节点.
        //下一层
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {//找到根节点在中序遍历序列中的位置。
                int[] pre_left = Arrays.copyOfRange(preorder, 1, i + 1);//前序遍历序列的左子树.
                int[] pre_right = Arrays.copyOfRange(preorder, i + 1, preorder.length);//前序遍历序列的右子树.
                int[] in_left = Arrays.copyOfRange(inorder, 0, i);//中序遍历序列的左子树.
                int[] in_right = Arrays.copyOfRange(inorder, i + 1, inorder.length);//中序遍历序列的右子树.
                root.left = buildTree(pre_left, in_left);//左子树
                root.right = buildTree(pre_right, in_right);//右子树
            }
        }
        //恢复现场
        return root;
    }

    public static void main(String args[]) {

    }
}