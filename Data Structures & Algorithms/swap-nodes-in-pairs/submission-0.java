/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = null;
        if (head.next.next != null) {
            result = swapPairs(head.next.next);
        }

        // Let's say the recursive function reached last two elements or last 3 elements
        // We swap the elements here and return head of the two swapped elements to the parent caller
        ListNode temp = head.next;
        head.next.next = head;
        head.next = result;
        return temp;
    }
}
