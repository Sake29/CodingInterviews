import org.junit.jupiter.api.Test;

public class Solution {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    /**
     * 反转链表
     * 头插法
     *
     * @param head 头
     * @return {@link ListNode}
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode res = null;
        while (head!=null){
            ListNode temp = new ListNode(head.val);
            temp.next = res;
            res = temp;
            head = head.next;
        }
        return res;
    }

    private void print(ListNode head){
        if (head == null) {
            System.out.println("EMPTY!");
        }
        while (head!=null){
            System.out.print(head.val);
            if (head.next!=null){
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        print(node1);
        ListNode res = reverseList(node1);
        print(res);
    }

}
