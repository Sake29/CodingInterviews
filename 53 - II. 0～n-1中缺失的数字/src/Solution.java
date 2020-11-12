import org.junit.jupiter.api.Test;

public class Solution {
    /**
     * 对特殊情况进行处理后，其余位置如果索引不等于元素，返回索引
     *
     * @param nums 待查数组
     * @return int
     */
    public int missingNumber(int[] nums) {
        if (nums.length == 1 && nums[0] == 1) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    /**
     * 二分法找
     *
     * @param nums 待查数组
     * @return int
     */
    public int missingNumber2(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] == mid) left = mid + 1;
            else right = mid;
        }
        return right;
    }

    @Test
    public void test(){
        int[] nums = {0,1};
        int res = missingNumber2(nums);
        System.out.println(res);
    }
}
