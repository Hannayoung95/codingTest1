package spyCloth;

import java.util.HashMap;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		String[][] clothes = {};
		int result = sol.solution(clothes);
	}

	public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map =new HashMap<String, Integer>();
        
        int cnt = 0;
        for(int i = 0; i<clothes.length; i++){
        	String kind = clothes[i][1];
        	if(map.containsKey(kind)){
        		cnt = map.get(kind);
        		map.put(kind, ++cnt );
        	}else{
        		map.put(kind, 1);
        	}
        }
        
        int temp = 1;
        for(String key : map.keySet()){
        	temp *=(map.get(key)+1);
        }
        
        answer = temp -1;
        return answer;
    }
}
