import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 使用栈模拟队列，该方法效率较低
 * 原因是栈的开销大
 *
 * @author WSY
 * @date 2020/10/21
 */
public class CQueue {

    private Stack<Integer> stack;
    private Stack<Integer> queueStack;

    public CQueue() {
        stack = new Stack<>();
        queueStack = new Stack<>();
    }


    public void appendTail(int value){
        stack.push(value);
    }

    public int deleteHead() {
        if (queueStack.isEmpty()){//如果该栈为空，先将其反转，再对栈顶出栈
            if (stack.isEmpty()){
                //如果两个栈都为空，说明该队列没有元素，返回-1
                return -1;
            }
            while (!stack.isEmpty()){
                queueStack.push(stack.pop());
            }
            return queueStack.pop();
        }
        return queueStack.pop();
    }

    @Test
    public void test(){
        CQueue obj = new CQueue();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());//1
        System.out.println(obj.deleteHead());//2
        System.out.println(obj.deleteHead());//3
    }

}
