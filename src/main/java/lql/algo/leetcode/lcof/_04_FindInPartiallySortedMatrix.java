package lql.algo.leetcode.lcof;

/**
 * 面试题04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 *
 * 解法一：暴力法 O(M * N)
 * 解法二：O(M + N)
 */
public class _04_FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        System.out.println(findNumberIn2DArray(matrix, 5));  // true
        System.out.println(findNumberIn2DArray(matrix, 20)); // false
    }

    static public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 矩阵又上角坐标
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0;
        int column = columns - 1;

        while(row < rows && column >= 0) {
            int rightTop = matrix[row][column];
            if (rightTop == target) {
                return true;
            } else if (rightTop > target) {
                // 右上角大于目标，排除此列
                column--;
            } else {
                // 右上角小于目标，排除此行
                row++;
            }
        }
        return false;
    }
}
