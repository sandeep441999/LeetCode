package linkedlist;

public class ReverseList {
    public ListNode reverseList(ListNode head) {

        // ListNode dummy2 = null;

        // while(head != null) {
        // ListNode temp = new ListNode(head.val);
        // temp.next = dummy2;
        // dummy2 = temp;
        // head = head.next;
        // }

        // return dummy2;

        ListNode ans = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = ans;
            ans = curr;
            curr = temp;
        }

        return ans;

    }
}
