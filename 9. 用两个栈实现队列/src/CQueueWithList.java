import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * 使用链表代替栈模拟队列，该方法优于用栈模拟
 *
 *
 * @author WSY
 * @date 2020/10/21
 */
public class CQueueWithList {

    private LinkedList<Integer> list;
    private LinkedList<Integer> queueList;

    public CQueueWithList() {
        list = new LinkedList<>();
        queueList = new LinkedList<>();
    }


    public void appendTail(int value){
        list.add(value);
    }

    public int deleteHead() {
        if (queueList.isEmpty()){
            if (list.isEmpty())return -1;
            while (!list.isEmpty()){
                queueList.add(list.pop());
            }
            return queueList.pop();
        }
        else return queueList.pop();
    }

    @Test
    public void test(){
        CQueueWithList obj = new CQueueWithList();
        obj.appendTail(1);
        obj.appendTail(2);
        obj.appendTail(3);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());//1
        System.out.println(obj.deleteHead());//2
        System.out.println(obj.deleteHead());//3
    }

}
