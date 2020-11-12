import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        //dp[i]为以元素num[i]为结尾的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //状态转移方程
            if (dp[i-1] < 0) dp[i] = nums[i];
            if (dp[i-1] >= 0) dp[i] = nums[i]+dp[i-1];
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

    /**
     * 考虑到dp中只有dp[i-1]有用,因此不用生成dp数组来存放结果
     *
     * @param nums 全国矿工工会
     * @return int
     */
    public int maxSubArray2(int[] nums){
        if(nums.length == 0) return 0;
        int res = nums[0];
        int pre = 0;//用于存放dp[i-1]
        int curr = nums[0];//用于存放dp[i]
        for (int i = 0; i < nums.length; i++) {
            curr = nums[i];
            if (pre < 0) curr = nums[i];
            if (pre >= 0) curr = nums[i] + pre;
            res = Math.max(res,curr);
            pre = curr;
        }
        return res;
    }


    @Test
    public void test(){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray2(nums);
        System.out.println(res);
    }
}
