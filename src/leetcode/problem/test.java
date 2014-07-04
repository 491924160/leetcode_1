package leetcode.problem;

import java.util.Iterator;
import java.util.Stack;

public class test {
public static void main(String[]args)
{
	String s=new String("sadf fgg uu iio    pp ");
	 Stack<String> stack=new Stack<String>();
     s=s.trim();
     s=s.replaceAll("\\s{2,}"," ");
     int length=s.length();
     int i=0;
     int m=0;
     while(i<length)
     {
         if(s.charAt(i)==' ')
         {
             stack.push(s.substring(m,i));
			    m=i+1;
         }
         i++;
     }
     stack.push(s.substring(m,i));
     StringBuffer buffer=new StringBuffer();
     while(!stack.empty())
     {
         buffer.append(stack.pop()+" ");
     }
     System.out.print(buffer.toString());
}
}
