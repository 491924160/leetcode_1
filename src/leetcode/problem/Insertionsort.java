package leetcode.problem;

import java.util.Random;

public class Insertionsort {
	public static ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) 
			return head;
		ListNode curr = head.next, pivot = head;
		pivot.next = null;
		while(curr != null){
			ListNode next = curr.next;
			if(pivot.val >= curr.val){
				curr.next = pivot;
				pivot = curr;
//				ListNode temp = curr;
//				temp.next = pivot;
//				pivot = temp;
			}else{
				ListNode iter = pivot;
				while(iter.next != null && iter != null){
					if(iter.val < curr.val && iter.next.val >= curr.val){
						ListNode temp = iter.next;
						iter.next = curr;
						curr.next = temp;
						break;
					}else
						iter = iter.next;
				}
				if(iter.next == null){
					iter.next = curr;
					curr.next = null;
				}
//				ListNode iter = pivot.next;
//				ListNode prev = pivot;
//				if(iter != null){
//				while(iter != null){
//					if(iter.val < curr.val){
//						if(iter.next != null){
//						prev = iter;
//						iter = iter.next;
//						}else{
//							ListNode temp = curr;
//							iter.next = temp;
//							curr = curr.next;
//							temp.next = null;
//							break;
//						}
//					}
//					else{
//						ListNode temp = curr;
//						curr = curr.next;
//						prev.next = temp;
//						temp.next = iter;											
//						break;
//					}
//				}
//				}else{
//					pivot.next = curr;
//					curr = curr.next;
//					pivot.next.next = null;
//				}
				
			}
			curr = next;
		}
		return pivot;
    }
	 private static ListNode generatelinklist(){
		  Random ran = new Random();
		  ListNode head = new ListNode(), curr = head;
		  for(int i = 0; i < 30 ; i++){
			  ListNode item = new ListNode();
			  item.val = ran.nextInt(100);
			  curr.next = item;
			  curr = curr.next;		 
		  }
		  return head.next;
	  }
	 
	public static int[] insertionsort(int[] array){
		if(array.length == 0 || array.length ==1) return null;
		int length = array.length;
		int[] sortedarray = new int[length];
			sortedarray[0] = array[0];
		if(array[0] > array[1]){
			sortedarray[0] = array[1];
			sortedarray[1] = array[0];
		}else{
			sortedarray[0] = array[0];
			sortedarray[1] = array[1];
		}
		for(int i = 2; i<length; i++){
				if(sortedarray[i-1] <= array[i]){
					sortedarray[i] = array[i];
				}else{
					int m;
					for( m = i-1;m>=0;m--){
						if(sortedarray[m] > array[i]) sortedarray[m+1] = sortedarray[m];
						else break;						
					}	
					sortedarray[m+1] = array[i];
				}		
		}
		return sortedarray;
		
	}
	
	public static int[] generate(){
		Random ran = new Random();
		int[] array = new int[10];
		for(int i = 0; i < 10; i++){
			array[i] = ran.nextInt(50);
		}
		return array;
	}
	
	private static void printlist(ListNode head){
		int count = 0;
		while(head != null){
			System.out.println(head.val);
			head = head.next;
			//System.out.println(count++);
		}
	}
	
	public static void main(String[]args){
//		int[] array = generate();
//		array = insertionsort(array);
//		for(int val:array)
//			System.out.println(val);
		ListNode head = generatelinklist();
		head = insertionSortList(head);
		printlist(head);
	}
	
	
}
