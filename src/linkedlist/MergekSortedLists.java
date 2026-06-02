package linkedlist;

import java.util.ArrayList;
import java.util.List;

public class MergekSortedLists {
    ListNode res;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return res;
        res = lists[0];

        while (lists.length > 1) {
            List<ListNode> ans = new ArrayList<>();
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = i + 1 < lists.length ? lists[i + 1] : null;
                ans.add(merge(l1, l2));
            }
            lists = ans.toArray(new ListNode[0]);
        }
        return lists[0];
        // for(int i=1; i<lists.length; i++) {
        // res = merge(res, lists[i]);
        // }
        // return res;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode d = new ListNode();
        ListNode cur = d;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;

        return d.next;
    }
}
