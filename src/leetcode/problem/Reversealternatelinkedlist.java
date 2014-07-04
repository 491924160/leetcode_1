package leetcode.problem;

public class Reversealternatelinkedlist {
	public static ListNode Reverselist(ListNode head){
		if(head == null) return null;
		ListNode ptr = head, newhead = null, prev = null;
		do{
			ListNode next = ptr.next;
			if(ptr.next != null)
				ptr.next = next.next;
			else break;
			next.next = newhead;
			newhead = next;
			prev = ptr;
			ptr = ptr.next;
		}while(ptr != null);
		prev.next = newhead;
		return head;
	}
	
	public static ListNode GenerateList(){
		ListNode head = new ListNode(1), ptr = head;
		for(int i = 2; i < 10; i++){
			ptr.next = new ListNode(i);
			ptr = ptr.next;
		}
		return head;
	}
	
	public static void Traverse(ListNode head){
		if(head == null) return;
		ListNode ptr = head;
		do{
			System.out.println(ptr.val);
			ptr = ptr.next;
		}while(ptr != null);
	}
	
	public static void main(String[]args){
		ListNode head = GenerateList();
		//Traverse(head);
		Reverselist(head);
		Traverse(head);
	}
}
