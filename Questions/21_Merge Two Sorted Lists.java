class Solution {
    // Merges two sorted linked lists into a single sorted linked list.
    // Time: O(N + M), where N and M are the lengths of the input linked lists.
    // Space: O(1), using only a constant amount of extra space.
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummyHead.next;
    }
}
