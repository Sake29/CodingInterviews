import org.junit.jupiter.api.Test;

public class Solution {

    /**
     * 递归实现斐波那契数列
     * 效率较低
     *
     * @param n n
     * @return int
     */
    public int fib1(int n){
        if (n == 0 || n == 1){
            return n;
        }
        return (fib1(n-1)+fib1(n-2))%1000000007;
    }

    /**
     * 根据数列的定义实现斐波那契数列
     * 每次for循环都要对1000000007取余
     * 当第n项和大于1000000007时，将第n项和的值变为其对1000000007取余
     *
     * @param n n
     * @return int
     */
    public int fib(int n){
        if (n == 0 || n == 1){
            return n;
        }
        int a = 0;
        int b = 1;
        for (int i = 1; i < n ; i++) {
            b = a + b;//状态转移方程，并缓存之前的运算结果
            a = b - a;//缓存
            b %= 1000000007;//每次运算都取模，避免越界
        }
        return b;
    }




    @Test
    public void test(){
        System.out.println(fib(2));
        System.out.println(fib(5));
        System.out.println(fib(30));

        System.out.println(fib1(2));
        System.out.println(fib1(5));
        System.out.println(fib1(30));

    }
}
