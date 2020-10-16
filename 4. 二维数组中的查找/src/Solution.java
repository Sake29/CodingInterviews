import org.junit.jupiter.api.Test;

public class Solution {

    /**
     * 思路一：遍历矩阵
     *
     * @param matrix 矩阵
     * @param target 目标
     * @return boolean
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (target == matrix[i][j]){ return true;}
            }
        }
        return false;
    }

    /**
     * 思路二：从矩阵右上角出发，向左搜索减小，向下搜索增大
     * 类似一棵二叉搜索树
     *
     * @param matrix 矩阵
     * @param target 目标
     * @return boolean
     */
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int columns = matrix[0].length;//列数
        int rows = matrix.length;//行数
        int column = columns-1;//初始搜索的列号
        int row = 0;//初始搜索的行号
        while (row < rows && column >= 0 ){
            int root = matrix[row][column];
            if (root == target){return true;};
            if (root < target){
                row++;
            }if (root > target){
                column--;
            }
        }
        //System.out.println(root);
        return false;
    }


    @Test
    public void test(){
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
/*        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }*/
        //int[][] matrix = {{-5}};
        boolean result = findNumberIn2DArray1(matrix, -5);
        System.out.println(result);

    }
}
