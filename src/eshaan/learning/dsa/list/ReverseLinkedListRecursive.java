package eshaan.learning.dsa.list;

public class ReverseLinkedListRecursive {
    public static ListNode reverseList(ListNode head) {
        //base case
        if(head.next==null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        // Reversing the linked list
        ListNode reversedHead = reverseList(head);

        System.out.println("Reversed list:");
        printList(reversedHead);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
