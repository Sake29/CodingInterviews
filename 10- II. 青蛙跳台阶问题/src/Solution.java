public class Solution {
    /**
     * 跳台阶
     * 动态规划问题
     * 状态转移方程：f(x) = f(x-1) + f(x-2)
     *
     * @param n n
     * @return int
     */
    public int numWays(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int a = 1;
        int b = 1;
        for (int i = 2; i <= n; i++) {
            b = a + b;
            a = b - a;
            b %= 1000000007;
        }
        return b;
    }
}
