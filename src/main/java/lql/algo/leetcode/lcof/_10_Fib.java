package lql.algo.leetcode.lcof;

/**
 * <a href="https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/">面试题10- I. 斐波那契数列</a>
 */
public class _10_Fib {

    public static void main(String[] args) {
        _10_Fib test = new _10_Fib();

        System.out.println(test.fib(3));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int valOfMinusOne = 1;
        int valOfMinusTwo = 0;

        for (int i = 2; i <= n; i++) {
            int val = (valOfMinusOne + valOfMinusTwo) % 1000000007;
            valOfMinusTwo = valOfMinusOne;
            valOfMinusOne = val;
        }
        return valOfMinusOne;
    }

    /**
     * 递归方式：时间复杂度高，运行会超时
     */
    public int fibOfRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibOfRecursion(n - 1) + fibOfRecursion(n - 2);
    }


}
