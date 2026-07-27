package linkedlist;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        int c = 0;

        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            ListNode kth = getKthNode(groupPrev, k);

            if (kth == null)
                break;

            ListNode groupNext = kth.next;

            ListNode prev = kth.next;
            ListNode cur = groupPrev.next;

            while (cur != groupNext) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;

    }

    public ListNode getKthNode(ListNode cur, int k) {
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }

        return cur;
    }
}
