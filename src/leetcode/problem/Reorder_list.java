package leetcode.problem;

import java.util.ArrayList;
import java.util.List;

//class ListNode{
//	int val;
//	ListNode next;
//	ListNode(int x){
//		val = x;
//		next = null;
//	}
//}

public class Reorder_list {
	public static void reorderList1(ListNode head){
		if(head == null){
			System.out.println("the head is null");
			return;
		}
		List<ListNode> list = new ArrayList<ListNode>();
		ListNode ptr = head;
		int count = 0;
		while(ptr != null){
			list.add(ptr);
			ptr = ptr.next;
			count++;
		}
		for(int i = 0; i < (int)Math.floor(count/2);i++){
			if(list.get(i).next != list.get(count-1-i)){
				list.get(i).next = list.get(count-1-i);
				list.get(count-1-i).next = list.get(i+1);
				list.get(count-2-i).next = null;
			}
		}
	
	}
	
	public static void reorderList(ListNode head){
		if(head == null){
			System.out.println("the head is null");
			return;
		}
		int count = 0, floor;
		ListNode ptr = head;
		while(ptr != null){
			count++;
			ptr = ptr.next;
		}
		floor = (int) Math.floor(count/2);
		ptr = head;
		for(int i = 0;i < floor; i++){
//			int j = 0;
//			ListNode prev = null;
//			while(i + j != count-1){
//				prev = ptr;
//				ptr = ptr.next;
//				j++;
//			}
//			if(ptr.next != null){
//				
//			}
			ListNode prev = null, end = null, cur = ptr;
			while(cur.next != null){
				prev = cur;
				end = cur.next;
				cur = cur.next;
			}
			if(prev != ptr){
			end.next = ptr.next;
			ptr.next = end;
			prev.next = null;
			if(ptr.next.next != null)
			ptr = ptr.next.next;}
		}
	}
	
	public static ListNode GenerateList(){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		return head;
	}
	
	public static void main(String[]args){
		ListNode head = GenerateList();
		reorderList1(head);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
