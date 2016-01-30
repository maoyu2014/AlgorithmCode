
public class Two {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur = null;
		ListNode head = null;
		int jinwei =0;
		while (l1!=null || l2!=null || jinwei!=0) {
			int temp=0;
			if (l1!=null) temp+=l1.val;
			if (l2!=null) temp+=l2.val;
			temp += jinwei;
			ListNode l3 = new ListNode(temp%10);
			l3.next=null;
			jinwei = temp/10;
			if (head==null) head=l3;
			if (cur!=null) cur.next = l3;
			cur = l3;
			if (l1!=null) l1 = l1.next;
			if (l2!=null) l2 = l2.next;
		}
        return head;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		l1.next=l2;
		l2.next=l3;
		l3.next=null;
		
		ListNode l4 = new ListNode(5);
		ListNode l5 = new ListNode(6);
		ListNode l6 = new ListNode(4);
		l4.next=l5;
		l5.next=l6;
		l6.next=null;
		
		ListNode ll = new Two().addTwoNumbers(l1, l4);
		while (ll!=null) {
			System.out.print(ll.val);
			ll = ll.next;
		}
		
	}
}	

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}