import org.junit.jupiter.api.Test;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        ListNode phead = new ListNode(-1);//哑节点，指向头节点。用于删除头节点的情况
        phead.next = head;
        ListNode deleteNode = head;
        ListNode preNode = phead;
        while (deleteNode!=null) {
            if (deleteNode.val == val){
                //删除该节点
                preNode.next = deleteNode.next;
                break;
            }
            deleteNode = deleteNode.next;
            preNode = preNode.next;
        }
        return phead.next;
    }

    private void print(ListNode head){
        if (head == null) System.out.println("EMPTY!");
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.val);
            if (temp.next != null){
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    @Test
    public void test(){
         ListNode node1 = new ListNode(4);
         ListNode node2 = new ListNode(5);
         ListNode node3 = new ListNode(1);
         ListNode node4 = new ListNode(9);
         node1.next = node2;
         node2.next = node3;
         node3.next = node4;

        ListNode res = deleteNode(node1, 10);
        print(res);
    }

}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}
