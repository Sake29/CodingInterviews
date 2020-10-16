import org.junit.Test;

import java.util.HashSet;

public class Solution {
    /**
     * 发现重复的数字
     * 思路一：
     * 利用hashset的不重复性进行检测
     *
     * @param nums 待检测的数组
     * @return int
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)){
                return num;
            }
            else hashSet.add(num);
        }
        return -1;
    }

    /**
     * 思路二：
     * 由于数组里面的数小于数组的长度，因此可以“一个萝卜一个坑”
     * 如果某个数n对应的下标上的数和该数相等，则说明重复
     *
     * @param nums 待检测的数组
     * @return int
     */
    public int findRepeatNumber1(int[] nums){
        return -1;
    }

    /**
     * 思路三：
     * 使用临时数组，将原数组的数作为下标对应到临时数组里
     * 如果有一个位置超过了1，说明重复
     *
     * @param nums 待检测的数组
     * @return int
     */
    public int findRepeatNumber2(int[] nums){
        return -1;
    }

    /**
     * 思路四：
     * 先排序，后遍历
     *
     * @param nums 待检测的数组
     * @return int
     */
    public int findRepeatNumber3(int[] nums){
        return -1;
    }

    @Test
    public void test(){
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int repeatNumber = findRepeatNumber(nums);
        int repeatNumber1 = findRepeatNumber1(nums);
        int repeatNumber2 = findRepeatNumber2(nums);
        int repeatNumber3 = findRepeatNumber3(nums);
        System.out.println("解法1："+repeatNumber);
        System.out.println("解法2："+repeatNumber1);
        System.out.println("解法3："+repeatNumber2);
        System.out.println("解法4："+repeatNumber3);

    }
}
