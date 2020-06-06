package lql.algo.leetcode.lcof;

/**
 *  <a href="https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/">面试题10- II. 青蛙跳台阶问题</a>
 *
 *  其实本质就是一个斐波那契函数
 */
public class _10_FrogJump {

    public static void main(String[] args) {
        _10_FrogJump test = new _10_FrogJump();

        System.out.println(test.jump(3));
    }

    public int jump(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int valOfMinusOne = 2;
        int valOfMinusTwo = 1;

        for (int i = 3; i <= n; i++) {
            int val = (valOfMinusOne + valOfMinusTwo) % 1000000007;
            valOfMinusTwo = valOfMinusOne;
            valOfMinusOne = val;
        }
        return valOfMinusOne;
    }


}
