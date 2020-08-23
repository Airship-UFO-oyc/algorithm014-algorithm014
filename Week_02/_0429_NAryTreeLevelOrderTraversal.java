package homework._02week;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 429. N叉树的层序遍历
 * ----------------------------
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 例如，给定一个 3叉树:  [1,null,3,2,4,null,5,6]
 * <p>
 * 返回其层序遍历:
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * 说明:
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * -------------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _0429_NAryTreeLevelOrderTraversal {


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


    //方案一：递归（递归）
    static public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> results = new ArrayList<>();
        helper(root, results, 0);
        return results;
    }

    //层序遍历
    private static void helper(Node root, List<List<Integer>> results, int level) {
        if (null == root) return;
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if (null != root.children) {
            for (Node node : root.children) {
                helper(node, results, level + 1);
            }
        }
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
        System.out.println(levelOrder(n1).toString());
    }
}