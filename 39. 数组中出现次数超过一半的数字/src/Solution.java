import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    /**
     * 找众数
     * 使用hashmap记录每个元素的个数
     *
     * @param nums 待查数组
     * @return int
     */
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> res = new HashMap<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res.containsKey(nums[i])){
                int value = res.get(nums[i]) + 1;
                res.put(nums[i],value);
            }
            else {
                res.put(nums[i],1);
            }
        }
        Set<Integer> keys = res.keySet();
        for (Integer key : keys) {
            if (nums.length / 2 < res.get(key)){
                num = key;
                break;
            }
        }
        return num;
    }

    /**
     * 找众数
     * 有序数组的中间位置必是众数
     *
     * @param nums 待查数组
     * @return int
     */
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    @Test
    public void test(){
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int res = majorityElement1(nums);
        System.out.println(res);
    }
}
