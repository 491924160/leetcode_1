package leetcode.problem;
import java.util.*;
import java.util.Map.Entry;
public class singleNumber {
	public int singleNumber(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for(int x: A){
        	if(!set.contains(x)){
        		set.add(x);
        	}else{
        		set.remove(x);
        	}
        }
        Iterator<Integer> iter = set.iterator();
        return iter.next();
    }
	public int singleNUmber2(int[] A){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int x: A){
			if(!map.containsKey(x)){
				map.put(x, 1);
			}else{
				int val = map.get(x);
				map.remove(x);
				map.put(x, val + 1);
			}
		}
//		Set<Entry<Integer, Integer>> set1 = map.entrySet();
//		Iterator<Entry<Integer, Integer>> iter = set1.iterator();
//		while(iter.hasNext()){
//			Entry<Integer,Integer> entry = iter.next();
//			if(entry.getValue() == 1)
//				return entry.getKey();
//			else continue;
//		}
//		return 0;
		Set<Integer> set = map.keySet();
		Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()){
			int i = iter.next();
			if(map.get(i) == 1)
				return i;
		}
		return 0;	
	}
	
	public int singleNumber3(int[] A){
		int[] count = new int[64];
		int length = A.length;
		int result = 0;
		for(int i = 0; i < 64; i++){
			for(int j = 0; j < length; j++){
				if(((A[j] >> i) & 1) != 0){
					count[i] ++;
				}
			}
			result |= (count[i]%3) & (1 << i);
		}
		return result;
	}
	
}
