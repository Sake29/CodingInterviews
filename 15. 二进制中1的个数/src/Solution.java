import org.junit.jupiter.api.Test;

public class Solution {


    /**
     * 使用Integer类自带的方法
     *
     *
     * @param n n
     * @return int
     */
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }


    /**
     * 除2法(超时)
     *
     * @param n n
     * @return int
     */
    public int hammingWeight2(int n) {
        if (n<2) return n;//避免死循环
        int count = 0;
        while (n>2){
            if (n % 2 == 1) count++;
            else n /= 2;
        }
        return count;
    }

    /**
     * 位运算
     * 把n往右移32次，每次都和1进行与运算
     *
     * @param n n
     * @return int
     */
    public int hammingWeight3(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >>> 1) & 1) == 1 ) count++;
        }
        return count;
    }

    @Test
    public void test(){
        int res1 = hammingWeight1(1000000007);
        System.out.println(res1);
    }

}
