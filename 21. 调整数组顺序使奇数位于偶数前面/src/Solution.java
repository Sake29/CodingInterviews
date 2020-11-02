import org.junit.jupiter.api.Test;

public class Solution {
    /**
     * 暴力法
     * 申请一个临时数组来存放结果
     *
     * @param nums int数组
     * @return {@link int[]}
     */
    public int[] exchange(int[] nums) {
        if (nums.length == 0) return new int[]{};
        if (nums.length == 1 || nums.length == 2) return nums;
        int[] res = new int[nums.length];
        int jishuIndex = 0;
        int oushuIndex = res.length-1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1 ) == 1){
                res[jishuIndex++] = nums[i];
            }
            else {
                res[oushuIndex--] = nums[i];
            }
        }
        return res;
    }

    /**
     * 双指针
     * 使用一左一右两个指针
     * 左边指针遇到偶数且右边指针遇到奇数指针交换
     *
     * @param nums int数组
     * @return {@link int[]}
     */
    public int[] exchange1(int[] nums){
        if (nums.length == 0) return new int[]{};
        if (nums.length == 1 || nums.length == 2) return nums;
        int left = 0;
        int right = nums.length-1;
        while (left < right){
            if ((nums[left] & 1) == 1){
                //左指针指到奇数，查找下一个
                left++;
                continue;
            }
            if ((nums[right] & 1) == 0){
                //右指针遇到偶数，查找下一个
                right--;
                continue;
            }
            //左边指针遇到偶数且右边指针遇到奇数指针交换
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }
        return nums;
    }

    /**
     * 快慢指针
     * 使用一快一慢两个指针
     * 快指针每次都移动，慢指针遇到偶数就停止移动
     * 当快指针遇到奇数，将快指针和慢指针交换位置，慢指针移动
     * 当快指针遍历完毕，结束循环
     *
     * @param nums int数组
     * @return {@link int[]}
     */
    public int[] exchange2(int[] nums){
        if (nums.length == 0) return new int[]{};
        if (nums.length == 1 || nums.length == 2) return nums;
        int fast = 0;
        int slow = 0;
        while (fast < nums.length){
            if ((nums[fast] & 1) == 1){
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5};
        int[] exchange = exchange2(nums);
        for (int i = 0; i < exchange.length; i++) {
            System.out.println(exchange[i]);
        }
    }
}
