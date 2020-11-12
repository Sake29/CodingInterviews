import org.junit.jupiter.api.Test;

public class Solution {

    /**
     *
     * @param nums   待查数组
     * @param target 目标数
     * @return int
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                count = 1;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] == target){
                        count +=1;
                    }
                    else break;
                }
                break;
            }
        }
        return count;
    }

    /**
     * 使用二分查找确定目标数
     *
     * @param nums   待查数组
     * @param target 目标数
     * @return int
     */
    public int search2(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length-1;
        int count = 0;
        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] >= target){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        for (int i = left; i < nums.length; i++) {
            if (nums[i] == target){
                count = 1;
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j] == target){
                        count +=1;
                    }
                    else break;
                }
                break;
            }
        }
        return count;
    }


    @Test
    public void test(){
        int[] nums1 = {2,2};
        int res1 = search2(nums1, 2);
        int res2 = search(nums1, 8);
        System.out.println(res1);
        System.out.println(res2);
    }
}
