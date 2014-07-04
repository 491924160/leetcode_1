package leetcode.problem;

import java.util.Random;



public class SortLinkedList {
	  public static ListNode sortList(ListNode head) {
		  	if(head == null || head.next == null) return head;
	       	ListNode middle = middleList(head);
	       	ListNode rlist = middle.next;
	       	middle.next = null;
	       	ListNode lhead = sortList(head), rhead = sortList(rlist);
	       	ListNode sortedlist = merge(lhead,rhead);
	       	return sortedlist;
	    }
	  
	  public static ListNode merge(ListNode left, ListNode right){
		  ListNode head = new ListNode(), curr = head;
		  while(left !=null && right != null){
			  if(left.val >= right.val){
				  curr.next = right;
				  right = right.next;
			  }else{
				  curr.next = left;
				  left = left.next;
			  }
			  curr = curr.next;
		  }
		  curr.next = (left == null)?right:left;
		  return head.next;
	  }
	  
	  public static ListNode middleList(ListNode head){
		  if(head == null || head.next == null) return head;		  
			  ListNode slow,fast;
			  slow = fast = head;
			  while(fast.next != null && fast.next.next != null){
				  slow = slow.next;
				  fast = fast.next.next;
			  }
			  return slow;
	  }
	  
	  private static ListNode generate(){
		  Random ran = new Random();
		  ListNode head = new ListNode(), curr = head;
		  for(int i = 0; i < 10000 ; i++){
			  ListNode item = new ListNode();
			  item.val = ran.nextInt(100000);
			  curr.next = item;
			  curr = curr.next;
			 
		  }
		  return head.next;
	  }
	  
	  public static void main(String[]args){
		  ListNode node = generate();
		  node = sortList(node);
		  while(node != null){
			  System.out.println(node.val + " ");
			  node = node.next;
		  }
	  }
}
