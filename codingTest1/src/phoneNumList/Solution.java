package phoneNumList;

//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map.Entry;
//import java.util.Set;
import java.util.*;
import java.util.Map.Entry;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

		// "119", "97674223", "1195524421"] false
		// ["123","456","789"] true
		// ["12","123","1235","567","88"] false

		String[] phone_book = { "119", "97674223", "1195524421" };
//		String[] phone_book = { "123", "456", "789" };
//		String[] phone_book = { "123", "124", "12356" };
		boolean result = sol.solution(phone_book);
		System.out.println("result : " + result);
	}

	public boolean solution(String[] phone_book) {
        boolean answer = true;
        System.out.println(Arrays.toString(phone_book));
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for(int i = 0 ; i < phone_book.length; i++){
			map.put(phone_book[i], i);
        }
		
		for(String key : map.keySet()){
			for(int i = 1; i < key.length(); i++ ){
				if(map.containsKey(key.substring(0, i))){
					answer = false;
					return answer;
				}
			}
		}
		
        return answer;
        
    }
	
}