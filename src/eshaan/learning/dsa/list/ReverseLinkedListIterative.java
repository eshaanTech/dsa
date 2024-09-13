package eshaan.learning.dsa.list;

public class ReverseLinkedListIterative {
    public static ListNode reverseList(ListNode head) {
        //initialize variables
        //1->2
        ListNode last = null; //to be new head
        ListNode curr = head;
        ListNode next = null;
        while(curr!=null){
            //preserve next
            next = curr.next;
            curr.next=last;
            last=curr;
            curr=next;

        }
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
