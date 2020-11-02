import org.junit.jupiter.api.Test;

public class Solution {
    /**
     * 剪绳子
     * 利用均值不等式推断出每段尽可能剪成3的时候，可以取最大值
     * @param n 绳子长
     * @return int
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;//至少要剪成2段
        int a = n / 3;
        int b = n % 3;
        if (b == 0){
            return (int) Math.pow(3,a);
        }else if (b == 1){
            return (int) (Math.pow(3,(a-1)) * 4);
        }
        else {
            return (int) (Math.pow(3,a)) * 2;
        }
    }

    /**
     * 剪绳子
     * 利用动态规划
     * @param n 绳子长
     * @return int
     */
    public int cuttingRope1(int n){
        int[] dp = new int[n+1];//dp[i]表示长度为i的绳子能得到的最大乘积
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j,dp[j]))*(Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];

    }

    @Test
    public void test(){
        int res1 = cuttingRope1(10);
        System.out.println(res1);
    }
}
