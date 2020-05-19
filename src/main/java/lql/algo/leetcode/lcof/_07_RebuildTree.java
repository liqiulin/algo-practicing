package lql.algo.leetcode.lcof;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题07. 重建二叉树
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 */
public class _07_RebuildTree {
    public static void main(String[] args) {
        _07_RebuildTree rebuildTree = new _07_RebuildTree();

        int[] preOder = {3,9,20,15,7};
        int[] inOder = {9,3,15,20,7};

        System.out.println(rebuildTree.buildTree(preOder, inOder));
    }


    public TreeNode buildTree(int[] preOder, int[] inOrder) {
        if (preOder == null || preOder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inOderMap = buildInOderMap(inOrder);
        return buildTreeInner(preOder, 0, preOder.length - 1, inOrder, 0, inOrder.length -1, inOderMap);

    }

    private Map<Integer, Integer> buildInOderMap(int[] inOder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inOder.length; i++) {
            map.put(inOder[i], i);
        }
        return map;
    }

    private TreeNode buildTreeInner(int[] preOrder, int m, int n, int[] inOder, int p, int q, Map<Integer, Integer> inOderMap) {
        int root = preOrder[m];

        int rootIdxOfInOrder = getRootIdx(inOderMap, root);
//        int rootIdxOfInOrder = getRootIdx(inOder, p, q, root);

        int leftTreeSize = rootIdxOfInOrder - p;
        int rightTreeSize = q - rootIdxOfInOrder;

        TreeNode node = new TreeNode(root);
        if (leftTreeSize > 0) {
            node.left = buildTreeInner(preOrder, m + 1, m + leftTreeSize, inOder, p, rootIdxOfInOrder - 1, inOderMap);
        }
        if (rightTreeSize > 0) {
            node.right = buildTreeInner(preOrder, n - rightTreeSize + 1, n, inOder,  rootIdxOfInOrder + 1, q, inOderMap);
        }

        return node;
    }

    // todo 这里时间复杂度太高，可以优化（把InOder转换成Map(val, index)）
    private int getRootIdx(int[] inOder, int p, int q, int root) {
        for (int i = p; i <= q; i++) {
            if (inOder[i] == root) {
                return i;
            }
        }
        throw new IllegalArgumentException("arg invalid");
    }

    // 利用map，提高性能
    private int getRootIdx(Map<Integer, Integer> inOderMap, int rootVal) {
        return inOderMap.get(rootVal);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
