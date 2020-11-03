import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }


    /**
     * 合并两个链表
     * 使用一个哑结点，指向合并后的链表res
     * 每次比较两个链表的头节点，将较小的头节点合并到res中
     * 当有一个链表为空时，结束遍历，将剩下不为空的链表接在尾部
     *
     * @param l1 l1
     * @param l2 l2
     * @return {@link ListNode}
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dump = new ListNode(-9999);//哑结点
        ListNode curr = dump;
        while ( l1!=null && l2!=null){
            if (l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null) curr.next = l2;
        if (l2 == null) curr.next = l1;
        return dump.next;
    }

    private void print(ListNode head){
        if (head == null) System.out.println("EMPTY!");
        while (head != null){
            System.out.print(head.val);
            if (head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }

    @Test
    public void test(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(3);
        node4.next = node5;
        node5.next = node6;

        print(node1);
        print(node4);

        ListNode res = mergeTwoLists(node1, node4);
        print(res);
    }
}
