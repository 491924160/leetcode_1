package leetcode.problem;
import java.util.*;

class RandomNode{
	int label;
	RandomListNode next, random;
	RandomNode(int x){
		this.label = x;
	}
}
public class RandomListNode {
	public RandomListNode copyRandomList(RandomNode head){
		 if(head == null) return null;
	        //RandomListNode newhead = new RandomListNode(head.label);
	        RandomListNode ptr = head;
	        do{
	           RandomListNode newhead = new RandomListNode(ptr.label);
	           newhead.next = ptr.next;
	           ptr.next = newhead;
	           ptr = ptr.next.next;
	        }while(ptr != null);
	        ptr = head;
	        do{
	            RandomListNode copy = ptr.next;
	            ptr.next.random = (ptr.random == null)? null : ptr.random.next;
	            ptr = ptr.next.next;
	        }while(ptr != null);
	        
	        ptr = head;
	        RandomListNode newhead = ptr.next;
	        do{
	            RandomListNode copy = ptr.next;
	            ptr.next = copy.next;
	            if(ptr.next != null)
	            copy.next = copy.next.next;
	            else copy.next = null;
	            ptr = ptr.next;
	        }while(ptr != null);
	        return newhead;
	}
}
