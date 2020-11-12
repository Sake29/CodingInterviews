import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) return new int[]{};
        selectSort(arr);
        return Arrays.copyOfRange(arr, 0, k);
    }

    public void bubbleSort(int[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void selectSort(int[] arr){
        if (arr == null) return;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    @Test
    public void test(){
        int[] nums = {3,2,1,5,4};
        int[] leastNumbers = getLeastNumbers(nums, 2);
        //selectSort(nums);
        for (int i = 0; i < leastNumbers.length; i++) {
            System.out.println(leastNumbers[i]);
        }
    }
}
