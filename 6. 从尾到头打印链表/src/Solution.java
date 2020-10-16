import org.junit.jupiter.api.Test;

public class Solution {
    /**
     * 反向打印
     * 遍历链表，将链表进行反转，再遍历反转后的链表，输出为int数组
     * 也可以考虑用栈实现。
     *
     * @param head 头
     * @return {@link int[]}
     */
    public int[] reversePrint(ListNode head) {
        if (head == null){return new int[0];}
        ListNode pointer = null;
        int i = 0;
        while (head != null){
            ListNode temp = new ListNode(head.val);
            temp.next = pointer;
            pointer = temp;
            head = head.next;
            i++;
        }
        int[] res = new int[i];
        for (int j = 0; j < res.length; j++) {
            res[j] = pointer.val;
            pointer = pointer.next;
        }
        return res;
    }

    /**
     * 打印链表
     *
     * @param head 头
     */
    public void print(ListNode head){
        if (head == null){
            System.out.println("EMPTY!");
            return;
        }
        if (head.next == null){
            System.out.println(head.val);
            return;
        }
        while (head != null){
            System.out.print(head.val);
            if (head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }
    }

    @Test
    public void test(){
/*        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;*/
        //print(node1);
        ListNode node1 = null;
        int[] res = reversePrint(node1);
        for (int re : res) {
            System.out.println(re);
        }
    }

}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
