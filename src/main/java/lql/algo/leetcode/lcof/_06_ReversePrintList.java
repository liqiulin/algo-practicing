package lql.algo.leetcode.lcof;

import java.util.Stack;

/**
 * 面试题06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class _06_ReversePrintList {
    public static void main(String[] args) {

    }

    /**
     * 利用栈新进后出的特性   时间复杂度：O(n)  空间复杂度：O(n)
     * @param head
     * @return
     */
    public int[] reversePrintWithStack(ListNode head) {
        if (head == null) {
            return new int[]{};
        }

        Stack<ListNode> stack = new Stack<>();

        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }

        int[] ret = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ret[i++] = stack.pop().val;
        }

        return ret;
    }


    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}
