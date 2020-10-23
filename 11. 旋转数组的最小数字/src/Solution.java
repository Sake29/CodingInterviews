import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    /**
     * 直接对数组排序，返回最小值
     *
     * @param numbers 数字
     * @return int
     */
    public int minArray(int[] numbers) {
        if (numbers.length == 0) return 0;
        Arrays.sort(numbers);
        return numbers[0];
    }

    /**
     * 在数组后面拼装一个数组
     * eg：{2,3,4,1} -> {2,3,4,1,2,3,4,1}
     * 当当前值大于下一个值时，返回下一个值。
     *
     * @param numbers 数字
     * @return int
     */
    public int minArray1(int[] numbers){
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        int res = numbers[0];
        for (int i = 0; i < 2 * numbers.length - 1; i++) {
            int index = i % (numbers.length-1);
            if (numbers[index] > numbers[(index+1) % numbers.length]){
                res = numbers[i%numbers.length+1];
                break;
            }
        }
        return res;
    }

    /**
     * 二分查找
     * {2,3,4,5,1}
     *  i   m   j
     *  当m>j时，说明最小值在m到j之间，则将i移动到m+1处
     *  当m<j时，说明最小值在i到m之间，则将j移动到m处
     *  当m=j时，说明m到j之间的数字相等，则可以缩小遍历范围
     *
     * @param numbers 数字
     * @return int
     */
    public int minArray2(int[] numbers){
        if (numbers.length == 0) return 0;
        if (numbers.length == 1) return numbers[0];
        int i = 0, j = numbers.length-1;
        while (i < j){
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]){
                i = m + 1;
            }
            else if (numbers[m] < numbers [j]){
                j = m;
            }
            else j--;
        }
        return numbers[i];
    }

    @Test
    public void test(){
        int[] numbers1 = {};
        int[] numbers2 = {1};
        int[] numbers3 = {2,3,4,1};
        int[] numbers4 = {1,2,3,4};

        System.out.println("###直接排序###");
        System.out.println(minArray(numbers1));
        System.out.println(minArray(numbers2));
        System.out.println(minArray(numbers3));
        System.out.println(minArray(numbers4));
        System.out.println("###双倍数组###");
        System.out.println(minArray1(numbers1));
        System.out.println(minArray1(numbers2));
        System.out.println(minArray1(numbers3));
        System.out.println(minArray1(numbers4));
        System.out.println("###二分查找###");
        System.out.println(minArray2(numbers1));
        System.out.println(minArray2(numbers2));
        System.out.println(minArray2(numbers3));
        System.out.println(minArray2(numbers4));

    }
}
