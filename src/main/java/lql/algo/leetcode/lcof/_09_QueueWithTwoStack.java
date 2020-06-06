package lql.algo.leetcode.lcof;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class _09_QueueWithTwoStack {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        for (int i = 0; i < 10; i++) {
            cQueue.appendTail(i);
        }

        while (!cQueue.isEmpty()) {
            System.out.println(cQueue.deleteHead());
        }
    }
}

class CQueue {
    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public CQueue() {
        this.firstStack = new Stack<>();
        this.secondStack = new Stack<>();
    }

    public void appendTail(int value) {
        firstStack.push(value);
    }

    public int deleteHead() {
        if (secondStack.isEmpty()) {
            // 将firstStack数据迁移到secondStack
            while(!firstStack.isEmpty()) {
                secondStack.push(firstStack.pop());
            }
        }

        if (secondStack.isEmpty()) {
            return -1;
        } else {
            return secondStack.pop();
        }
    }

    public boolean isEmpty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }
}
