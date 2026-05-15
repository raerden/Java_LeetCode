package p0002_AddTwoNumbers;
/*
https://leetcode.com/problems/add-two-numbers/
 */
public class Main {
    public static void main(String[] args) {
        ListNode l1 = createList(new int[]{2,4,3});
        ListNode l2 = createList(new int[]{5,6,4});
        /* [7,0,8] */

//        ListNode l1 = createList(new int[]{0});
//        ListNode l2 = createList(new int[]{0});

//        ListNode l1 = createList(new int[]{9,9,9,9,9,9,9});
//        ListNode l2 = createList(new int[]{9,9,9,9});
        /* [8,9,9,9,0,0,0,1] */

//        ListNode l1 = createList(new int[]{1,6,0,3,3,6,7,2,0,1});
//        ListNode l2 = createList(new int[]{6,3,0,8,9,6,6,9,6,1});
        /* [7,9,0,1,3,3,4,2,7,2] */

        printList(l1);
        printList(l2);

        Solution solution = new Solution();
        ListNode sum = solution.addTwoNumbers(l1, l2);

        printList(sum);

    }

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode current = dummy;
            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int x1 = l1 != null ? l1.val : 0;
                int x2 = l2 != null ? l2.val : 0;
                int sum = carry + x1 + x2;
                carry = sum / 10;
                current.next = new ListNode(sum % 10);
                current = current.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }
            return dummy.next;
        }
    }

    static class Solution_my_first {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int val1 = l1.val;
            int val2 = l2.val;

            int sum = (val1 + val2) % 10;
            int div = (val1 + val2) / 10;

            ListNode resHead = new ListNode(sum);
            ListNode resCurrent = resHead;

            ListNode l1Current = l1.next;
            ListNode l2Current = l2.next;

            while (true) {
                if (l1Current != null) {
                    val1 = l1Current.val;
                    l1Current = l1Current.next;
                } else {
                    val1 = 0;
                }

                if (l2Current != null) {
                    val2 = l2Current.val;
                    l2Current = l2Current.next;
                } else {
                    val2 = 0;
                }

                sum = (val1 + val2 + div) % 10;
                div = (val1 + val2 + div) / 10;

                if(sum == 0 && div == 0 && l1Current == null && l2Current == null) {
                    break;
                } else {
                    resCurrent.next = new ListNode(sum);
                    resCurrent = resCurrent.next;
                }
            }
            return resHead;
        }
    }

    public static void printList(ListNode list) {
        if (list == null)
            return;

        System.out.print('[');
        ListNode current = list;

        boolean first = false;
        while (current != null) {
            if (first)
                System.out.print(',');
            System.out.print(current.val);
            current = current.next;
            first = true;
        }
        System.out.println(']');
    }

    public static ListNode createList(int[] values) {
        if (values.length == 0)
            return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }
}



