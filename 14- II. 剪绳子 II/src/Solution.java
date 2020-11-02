import org.junit.jupiter.api.Test;

public class Solution {
    /**
     * 剪绳子
     * 此题与14- I. 剪绳子 主体等价
     * 唯一不同在于本题目涉及 “大数越界情况下的求余问题”
     * 考虑使用贪心算法
     *
     * @param n n
     * @return int
     */
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;//至少要剪成2段
        int p = 1000000007;
        long res = 1;
        while (n > 4){//此处不取=号是因为当n=4时，如果剪成1和3，那1×3<4
            //n > 4时，每次都尽可能的剪3，当n不足以剪3的时候，即剩下0、1、2
            res *= 3;
            res %= p;//防止res过大溢出
            n -= 3;
        }
        //剩下为1和2的时候，不剪是最大的
        return (int) (res * n % p);
    }

    @Test
    public void test(){
        int res = cuttingRope(1000000008);
        System.out.println(res);
    }
}
