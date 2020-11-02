import org.junit.jupiter.api.Test;

public class Solution {

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    /**
     * 深度优先遍历（递归）
     *
     * @param i       当前横坐标
     * @param j       当前纵坐标
     * @param m       矩阵长
     * @param n       矩阵宽
     * @param k       数位和上限
     * @param visited 已访问的矩阵元素
     * @return int
     */
    private int dfs (int i,int j,int m,int n,int k,boolean[][] visited){
        //边界条件
        if (
                i < 0 //越界
                || i >= m //越界
                || j < 0 //越界
                || j >= n //越界
                || (i / 10 + i % 10  + j / 10 + j % 10) > k //当前坐标数位和大于k
                || visited[i][j])//当前位置已经访问
        {
            return 0 ;
        }
        visited[i][j] = true;
        //往四个方向搜索
        int res = dfs(i+1,j,m,n,k,visited) + dfs(i-1,j,m,n,k,visited) + dfs(i,j+1,m,n,k,visited) + dfs(i,j-1,m,n,k,visited) + 1;
        return res;
    }


    @Test
    public void test(){
        int res1 = movingCount(4, 4, 6);
        int res2 = movingCount(2, 3, 1);
        int res3 = movingCount(3, 1, 0);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
