package leetcode.problem;

import java.util.Set;
import java.util.Stack;

class TreeNode{
	public int val;
	public TreeNode left = null, right = null;
	
	TreeNode(int key){
		val = key;
	}
	
	TreeNode(){
		val = 0;
	}
	
//	public int hashCode(){
//		return val;
//	}
//	
//	public boolean equals(Object obj){
//		if(obj == null || getClass() != obj.getClass())
//			return false;
//		TreeNode cur = (TreeNode)obj;
//		if(cur.val != this.val){
//			
//		}
//	}
	
	public static Stack<TreeNode> PushLeft(TreeNode root, Stack<TreeNode> stack){
		if(root == null){
			return stack;
		}
		TreeNode left = root.left;
		while(left != null){
			stack.push(left);
			left = left.left;
		}
		return stack;
	}
	
	public static void PreorderTraverse(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null)
			System.out.println("the root node is null");
		stack.push(root);
		
		TreeNode cur = null;
		while(!stack.empty()){
			cur = stack.pop();
			System.out.println(cur.val);
			if(cur.right != null)
				stack.push(cur.right);
			if(cur.left != null)
				stack.push(cur.left);
		}
	}
	
	public static void InorderTraverse(TreeNode root){
		if(root == null)
			System.out.println("the root node is null");
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = null;
//		while((cur = root.left) != null){
//			stack.push(cur);
//			cur = cur.left;
//		}
		PushLeft(root, stack); //push all the left child of the root tree into the stack
		
		while(!stack.empty()){
			cur = stack.pop();
			System.out.println(cur.val);
			if(cur.right != null)
			{
				stack.push(cur.right);
				PushLeft(cur.right,stack);
			}
		}
	}
	
	public static void PostorderTraverse(TreeNode root){
		if(root == null){
			System.out.println("root is null");
			return ;
		}
		Stack<TreeNode> stack =  new Stack<TreeNode>();
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		stack.push(root);
		TreeNode cur = null, parent = null;
		while(!stack.empty()){
			cur = stack.pop();
//			if(cur == parent){
//				System.out.println(cur.val);
//				continue;
//			}
//			if(cur.left != null || cur.right != null){
//				stack.push(cur);
//				parent = cur;
//				if(cur.right != null) stack.push(cur.right);
//				if(cur.left != null) stack.push(cur.left);
//			}else{
//				System.out.println(cur.val);
//			}
			stack1.push(cur); 
			if(cur.left != null) stack.push(cur.left);
			if(cur.right != null) stack.push(cur.right);
		}
		while(!stack1.empty()){
			System.out.println(stack1.pop().val);
		}
	}
	
	public static void pushleft(TreeNode root, Stack st){
		if(root == null) return;
		while(root.left != null){
			if(root.right != null)
				st.push(root.right);
			root = root.left;
		}
	}
	
	public static void PostorderTraverse1(TreeNode root){
		if(root == null){
			return;
		}
		Stack st = new Stack();
		pushleft(root, st);
		
		TreeNode cur = null, ptr= null;
		while(!st.empty()){
			cur = (TreeNode)st.pop();
			if(cur.right == null){
				System.out.println(cur.val);
			}else{
				ptr = (TreeNode) st.pop();
				st.push(cur);
				pushleft(ptr,st);
				}
		}
		
	}
}

public class TreeTraverse {
	
	static TreeNode GenerateTree(){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(15);
		root.right.left = new TreeNode(100);
		return root;
	}
	
	public static void main(String[]args){
		TreeNode root = GenerateTree();
		//TreeNode.PreorderTraverse(root);
		//TreeNode.InorderTraverse(root);
		TreeNode.PostorderTraverse(root);
	}
}
