package two_Pointers;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 * */
public class removeNthFromEnd19 {
	public class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
		 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // �� ���� ָ�룬��nodeָ������nodeָ��ǰn��������ͬʱ����β�ߣ���������node���˶�β����node�͵��˸�ɾ��node
        ListNode dummyhead = new ListNode(-1);
        ListNode slow= dummyhead, fast = dummyhead ;
        dummyhead.next = head;
        int i = 0 ;
        for ( ; i < n ; i++ ) {
            fast = fast.next ;
        }
        
        while( fast.next != null) {
            fast = fast.next ;
            slow = slow.next ;
        }
        
        //fast.next is end, now delete slow.next 
        ListNode temp = slow.next.next;
        slow.next = temp ;
        
        return dummyhead.next;
    }
}
