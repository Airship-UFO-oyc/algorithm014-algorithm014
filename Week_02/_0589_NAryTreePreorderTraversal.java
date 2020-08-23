package homework._02week;

import java.util.*;

/**
 * 589. N叉树的前序遍历
 * ----------------------------
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 例如，给定一个 3叉树 : [1,null,3,2,4,null,5,6]
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * ---------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0589_NAryTreePreorderTraversal {

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //递归体
    static public void helper(Node root, List<Integer> results) {
        if (null == root) return;//递归出口
        results.add(root.val);//遍历根
        if (null == root.children) return;
        for (Node child : root.children) {
            helper(child, results);//从左到右遍历子树
        }
    }

//    //方案一：递归
//    static public List<Integer> preorder(Node root) {
//        List<Integer> results = new ArrayList<>();
//        helper(root, results);
//        return results;
//    }

    //方案二：非递归
    static public List<Integer> preorder(Node root) {
        List<Integer> results = new ArrayList<>();
        if (null == root) return results;
        Stack<Node> stack = new Stack<>();//栈
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tempNode = stack.pop();
            results.add(tempNode.val);
            List<Node> children = tempNode.children;
            if (null != children) {
                for (int i = children.size() - 1; i >= 0; i--) {//从右至左入栈
                    if (null != children.get(i)) stack.push(children.get(i));
                }
            }
        }
        return results;
    }

    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        List<Node> nc1 = new ArrayList<Node>() {{
            this.add(n2);
            this.add(n3);
            this.add(n4);
        }};
        n1.children = nc1;
        List<Node> nc2 = new ArrayList<Node>() {{
            this.add(n5);
            this.add(n6);
        }};
        n2.children = nc2;
        System.out.println(preorder(n1).toString());
    }
}