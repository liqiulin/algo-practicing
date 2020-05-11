package lql.algo.leetcode.lcof;

import java.util.Objects;

/**
 * 面试题05. 替换字符串空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 *
 */
public class _05_ReplaceSpace {

    public static void main(String[] args) {
        String s = "hello world";

        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return s;
        }

        int spaceCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        if (spaceCount == 0) {
            return s;
        } else {
            int newLength = s.length() + 2*spaceCount;
            char[] newCharArray = new char[newLength];
            int i = s.length() - 1;
            int j = newCharArray.length -1;
            for (; i >= 0; i--) {
                if (s.charAt(i) == ' ') {
                    newCharArray[j--] = '0';
                    newCharArray[j--] = '2';
                    newCharArray[j--] = '%';
                } else {
                    newCharArray[j--] = s.charAt(i);
                }
            }
            return new String(newCharArray);
        }
    }
}
