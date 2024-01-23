class Solution {
    // Adds two numbers represented by linked lists.
    // Time: O(max(N, M)) where N and M are lengths of input linked lists.
    // Space: O(max(N, M)) for the resulting linked list.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0); // Dummy node for the result
        ListNode cur = ans; // Pointer to traverse the result list
        int carry = 0; // Carry-over from addition

        // Continue until both input lists are processed and there is no carry-over
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;

            cur.next = new ListNode(sum % 10); // Create a new node
            cur = cur.next; // Move to the next node
            carry = sum / 10; // Update carry-over

            l1 = (l1 != null) ? l1.next : null; // Move to the next nodes in input lists
            l2 = (l2 != null) ? l2.next : null;
        }

        return ans.next; // Skip the dummy node
    }
}
