import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void test(){
        int[] pushed1 = {1,2,3,4,5};
        int[] popped1 = {4,5,3,2,1};
        int[] popped2 = {4,3,5,1,2};

        boolean res1 = validateStackSequences(pushed1, popped1);
        boolean res2 = validateStackSequences(pushed1, popped2);

        System.out.println(res1);
        System.out.println(res2);
    }


}
