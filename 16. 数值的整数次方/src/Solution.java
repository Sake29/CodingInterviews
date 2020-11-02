import org.junit.jupiter.api.Test;

public class Solution {
    /**
     * 快速幂原理：
     * 3^5 = 3*3^4 = 3*3^(2*2) = 3*9^2 = 3*9^(1*2) = 3*81^1 = 243
     *
     * 基本的快速幂：
     * 303 / 304 个通过测试用例
     * 未通过：x = 2, n = -2147483648
     * 原因：使用Math.abs()求-2147483648，会返回原值
     * 解决：使用long存储指数
     * @param x 底数
     * @param n 指数
     * @return double
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        long m = n;
        if (n< - 1){
            x = 1/x;
            m = Math.abs(m);
        }
        double res = 1;
        //迭代中的底数
        double base = x;
        while (m != 0){
            if (m % 2 == 1){//当前为奇数幂
                //n -= 1;
                res *= base;
            }
            base *= base;
            m /= 2;
        }
        return res;
    }

    /**
     * 基于位运算的快速幂
     * 判断奇偶：a & 1 == true为奇数
     * 对2求模运算：a>>>1;右移运算
     *
     * @param x x
     * @param n n
     * @return double
     */
    public double myPow1(double x, int n){
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        long m = n;
        if (n< - 1){
            x = 1/x;
            m = Math.abs(m);
        }
        double res = 1;
        //迭代中的底数
        double base = x;
        while (m != 0){
            if ((m & 1) == 1){//当前为奇数幂
                //n -= 1;
                res *= base;
            }
            base *= base;
            m = m >>> 1;
        }
        return res;
    }

    @Test
    public void test(){
        double res1 = myPow(1, -2147483648);
        double res2 = myPow(-2, 3);
        double res3 = myPow(2.1, 3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);

        double res4 = myPow1(1, -2147483648);
        double res5 = myPow1(2, -2);
        double res6 = myPow1(2.1, 3);
        System.out.println(res4);
        System.out.println(res5);
        System.out.println(res6);
    }

}
