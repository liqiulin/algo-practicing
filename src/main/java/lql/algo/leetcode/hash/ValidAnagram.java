package lql.algo.leetcode.hash;

import java.util.*;


/**
 * 242. 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class ValidAnagram {
    // 使用hash表解法 时间复杂度O(n) 空间复杂度 O(n)
    public boolean isAnagram_useHashSet(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 构建s的字符集合
        Map<Character, Integer> smap = toMap(s);
        Map<Character, Integer> tmap = toMap(t);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Objects.equals(smap.get(c), tmap.get(c))) {
                return false;
            }
        }

        return true;
    }

    private Map<Character, Integer> toMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            map.putIfAbsent(c1, 1);
            int currentVal = map.get(c1);
            map.put(c1, ++currentVal);
        }
        return map;
    }

    // 排序 时间复杂度O(nlogn) 空间复杂度 O(n)
    public boolean isAnagram_sort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // 构建s的字符集合
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        char[] tc = t.toCharArray();
        Arrays.sort(tc);

        return Arrays.equals(sc, tc);
    }

    // 暴力解法 O(n2)
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(0);
            boolean anyMatch = false;
            for (int j = 0; j < t.length(); j++) {
                if (t.charAt(j) == c) {
                    anyMatch = true;
                    break;
                }
            }
            if (!anyMatch) {
                return false;
            }
        }
        return true;
    }
}


