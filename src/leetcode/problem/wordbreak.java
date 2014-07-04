package leetcode.problem;

import java.util.Set;
import java.util.*;

public class wordbreak {
	public static boolean wordBreak(String s, Set<String> dict) {
		int len = s.length();
		boolean[] array = new boolean[len+1];
//		for(int i = 0;i < len;i++){
//			array[i] = false;
//		}
		array[0] = false;
		String sub = null;
		for(int i = 1; i <= len;i++){
			sub = s.substring(0, i);
			if(dict.contains(sub)){
				array[i] = true;
				continue;
			}else{
			for(int j = i-1;j >= 0; j--){
				String sub1 = s.substring(j,i);
				if(dict.contains(sub1) && array[j] == true){
					array[i] = true;
					break;
				}
			}
			}
		}
		return array[len];
    }
	
	public static void main(String[]args){
		String s = "ab";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		System.out.println(wordBreak(s,dict));
	}
	
}
