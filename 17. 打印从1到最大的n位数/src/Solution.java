import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 打印数据
     * 在int范围内，使用pow()可以解决
     *
     * @param n n
     * @return {@link int[]}
     */
    public int[] printNumbers(int n) {
        int i = 0;
        int max = (int) Math.pow(10,n);
        int[] res = new int[max-1];
        while (i < max-1){
            res[i] = i+1;
            i++;
        }
        return res;
    }

    /**
     * 打印数据
     * 考虑大数问题：当n>10时，使用pow会越界
     * 解决：用字符串模拟加法
     * @return {@link int[]}
     */
    char[] temp = {'0','1','2','3','4','5','6','7','8','9'};//字符库
    char[] num;//存放每个数字
    int n;//位数
    int count = 0;
    StringBuffer res;//存放结果的数字字符串，以逗号分隔
    public int[] printNumbers1(int n){
        this.n = n;
        res = new StringBuffer();
        num = new char[n];//定义n位数
        dfs(0);
        res.deleteCharAt(res.length()-1);//删除末尾的逗号
        String s = res.toString();
        System.out.println(s);
        return null;
    }

    private void dfs(int x){
        if (x == n) {//终止条件当n位数字生成完毕
            //去除首位的0

            //添加到结果集
            res.append(String.valueOf(num) + ",");//将char数组转为字符串，并将数字字符串添加到结果中，并加上逗号
            return;
        }
        for (int i = 0; i < temp.length; i++) {
            num[x] = temp[i];//固定第x位，生成其他位
            dfs(x+1);
        }
    }

    private void print(int[] nums){
        if (nums.length == 0) System.out.println("EMPTY!");
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i != nums.length - 1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }

    @Test
    public void test(){
/*        int[] res1 = printNumbers(1);
        int[] res2 = printNumbers(2);
        int[] res3 = printNumbers(10);

        print(res1);
        print(res2);
        print(res3);*/

    }

    @Test
    public void test1(){
        char[] num = {'1','2','3'};
        while (num[0] == '0'){
            num = Arrays.copyOfRange(num,1,num.length);
        }
        System.out.println(num);

    }
}
