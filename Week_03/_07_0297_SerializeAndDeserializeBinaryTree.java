package homework._03week;


import java.util.*;

/**
 * 297. 二叉树的序列化与反序列化
 * ----------------------------
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 示例: 
 * 你可以将以下二叉树：
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * --------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _07_0297_SerializeAndDeserializeBinaryTree {


    // Definition for a binary tree node.
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 层序遍历：空结点也入队列【错误的答案，最后会有连续的null字符串】
    //如输入[1,2,3,null,null,4,5]，则输出[1,2,3,null,null,4,5,null,null,null,null]
    public String serialize_error(TreeNode root) {
        if (null == root) return "[]";
        StringBuilder results = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.remove();
            if (null != tempNode) {
                if (count > 0) results.append(",");
                results.append(tempNode.val);
                count++;
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            } else {
                if (count > 0) results.append(",");
                results.append("null");
                count++;
            }
        }
        results.append("]");
        return results.toString();
    }

    // 层序遍历：空结点也入队列【正确的解决方法，去掉最后连续的null字符串】
    //如输入[1,2,3,null,null,4,5]，则输出[1,2,3,null,null,4,5]
    public String serialize(TreeNode root) {
        if (null == root) return "[]";
        List<String> dataList = new ArrayList<>();
        StringBuilder results = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.remove();
            if (null != tempNode) {
                dataList.add(String.valueOf(tempNode.val));
                queue.add(tempNode.left);
                queue.add(tempNode.right);
            } else {
                dataList.add("null");
            }
        }
        int end = dataList.size() - 1;//找到最后一个不为null的字符串.
        for (; end >= 0; end--) {
            if (!"null".equals(dataList.get(end))) break;
        }
        for (int i = 0; i <= end; i++) {
            if (i > 0) results.append(",");
            results.append(dataList.get(i));
        }
        results.append("]");
        return results.toString();
    }

    // 层序遍历：反序列化
    public TreeNode deserialize(String data) {
        if ("[]" == data) return null;
        String datas[] = data.substring(1, data.length() - 1).split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(datas[index++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (null != node) {
                if (index < datas.length && !datas[index].equals("null")) {
                    node.left = new TreeNode(Integer.valueOf(datas[index]));
                    queue.add(node.left);
                }
                index++;
                if (index < datas.length && !datas[index].equals("null")) {
                    node.right = new TreeNode(Integer.valueOf(datas[index]));
                    queue.add(node.right);
                }
                index++;
            }

        }
        return root;
    }


    public static void main(String args[]) {
        _07_0297_SerializeAndDeserializeBinaryTree test = new _07_0297_SerializeAndDeserializeBinaryTree();
        System.out.println(test.serialize(test.deserialize("[1,2,3,null,null,4,5]")));
    }
}