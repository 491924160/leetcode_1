package leetcode.problem;
import java.util.Set;
import java.util.Stack;


public class reverse_notation {
public static void main(String[]args)
{
	Stack<String> stack=new Stack<String>();
	String[] tokens=new String[]{"5","6","+","13","*"};
	int i=tokens.length;
	int j=0;
	while(j<i)
	{
		int m=0;
		int n=0;
		if(!tokens[j].isEmpty())
		{
	switch(tokens[j])
	{ 	
	case "+": 
		 m=Integer.parseInt(stack.pop());
		 n=Integer.parseInt(stack.pop());
		stack.push(Integer.toString(m+n));
		break;
	case "-":
		 m=Integer.parseInt(stack.pop());
		 n=Integer.parseInt(stack.pop());
		stack.push(Integer.toString(n-m));
		break;
	case "/":
		 m=Integer.parseInt(stack.pop());
		 n=Integer.parseInt(stack.pop());
		stack.push(Integer.toString(n/m));
		break;
	case "*":
		 m=Integer.parseInt(stack.pop());
		 n=Integer.parseInt(stack.pop());
		stack.push(Integer.toString(n*m));
		break;
	default: stack.push(tokens[j]);		
	}
	}
		j++;
	}
	System.out.print(stack.pop());
}
}
