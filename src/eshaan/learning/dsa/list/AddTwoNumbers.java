package eshaan.learning.dsa.list;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //variables: sum, carry, Dummy Node
        int sum=0, carry=0;
        ListNode dummy = new ListNode(0);
        //to keep track of the node is result list

        ListNode current = dummy;
        //iterate till any one of the list
        //ex: l1: {1->2->5} l2: {2->1)
        while(l1!=null || l2!=null){
            int x= (l1!=null)? l1.val:0;
            int y= (l2!=null)? l2.val:0;
            sum = carry + x + y;
            carry = sum/10;
            current.next = new ListNode(sum%10);
            current = current.next;
            if(l1!=null){
                l1 = l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        //handle value in carry
        if(carry>0){
            current.next = new ListNode(carry);
        }
        return dummy.next;

    }
}

