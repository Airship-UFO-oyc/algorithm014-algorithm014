package _2020._08._27;

import java.util.*;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * ----------------------------
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 * --------------------------------------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _01_offer_06_CongWeiDaoTouDaYinLianBiaolcof {

    //Definition for singly-linked list.
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    //[1]暴力
//    static public int[] reversePrint(ListNode head) {
//        List<Integer> nums = new ArrayList<>();
//        while (null != head) {
//            nums.add(head.val);
//            head = head.next;
//        }
//        Collections.reverse(nums);
//        return nums.stream().mapToInt(Integer::valueOf).toArray();
//    }

    //[2]使用栈
    static public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (null != head) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] results = new int[size];
        for (int i = 0; i < size; i++) {
            results[i] = stack.pop();
        }
        return results;
    }


    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        System.out.println(Arrays.toString(reversePrint(n1)));
    }

}

