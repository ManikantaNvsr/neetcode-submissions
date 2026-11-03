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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // dummy node
        ListNode resultHead = new ListNode(0);
        ListNode temp = resultHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // When one of them is exhausted
        // We have to write the remaining elements to the end of result list
        // Since this is a LinkedList, we just need to point the firstNode in the remaining list.
        temp.next = list1 != null ? list1 : list2;

        return resultHead.next;
    }
}