import org.junit.jupiter.api.Test;

public class Solution {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA == null || headB == null) return null;
        ListNode currA = headA;
        ListNode currB = headB;
        while (currA != currB){
            currA = currA == null?headB:currA.next;
            currB = currB == null?headA:currB.next;
        }
        return currA;
    }

    @Test
    public void test(){
        ListNode headA = new ListNode(0);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        ListNode headB = new ListNode(3);
        headA.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        headB.next = node4;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);

    }
}
