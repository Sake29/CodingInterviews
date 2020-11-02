import org.junit.jupiter.api.Test;

public class Solution {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }

    /**
     * 快慢指针
     * 快指针比慢指针多走k步
     * 当快指针到链表尾部，返回慢指针
     *
     * @param head 链表的头节点
     * @param k    倒数第k个
     * @return {@link ListNode}
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k<=0) return null;
        ListNode fast = head;
        ListNode slow = head;
        int temp = 0;
        while (fast.next!=null){
            fast = fast.next;
            if (temp != k-1){
                temp++;
            }
            else {
                slow = slow.next;
            }
        }
        return slow;
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
        ListNode res = getKthFromEnd(node1, -1);
        print(res);
    }

}
