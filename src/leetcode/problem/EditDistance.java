package leetcode.problem;

import java.util.Random;

public class EditDistance {
	 public static int minDistance(String word1, String word2) {
	        int len_1 = word1.length();
	        int len_2 = word2.length();
	        int[][] array = new int[len_1][len_2];
	        for(int i = 0; i < len_2; i++)
	        	array[0][i] = i;
	        for(int i = 0; i < len_1; i++)
	        	array[i][0] = i;
	        for(int i = 1; i < len_1; i++)
	        	for(int j = 1; j < len_2; j++){
	        		if(word1.charAt(i-1) == word2.charAt(j-1))
	        			array[i][j] = array[i-1][j-1];
	        		else
	        		array[i][j] = min(array[i-1][j-1]+1,array[i][j-1]+1,array[i-1][j]+1);
	        	}
	        return array[len_1-1][len_2-1];
	    }
	 
	 public static int min(int i,int j,int m){
		 if(i <= j && i <= m)
			 return i; 
		 else if(j <= m)
			 return j;
		 else return m;		 
	 }
	 
	 public static void main(String[]args){
//		 int[] array = new int[3];
//		 int count = 0;
//		 Random ran = new Random();
//		 for(int i:array){
//			 array[count++] = ran.nextInt(50);
//		 }
//		 System.out.printf("%d %d %d\n",array[0],array[1],array[2]);
//		 
//		 System.out.println(min(array[0],array[1],array[2]));
		 System.out.println(minDistance(args[0],args[1]));
	 }
}
