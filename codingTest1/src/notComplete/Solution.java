package notComplete;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// participant completion return
		// ["leo", "kiki", "eden"] ["eden", "kiki"] "leo"
		// ["marina", "josipa", "nikola", "vinko", "filipa"] ["josipa",
		// "filipa", "marina", "nikola"] "vinko"
		// ["mislav", "stanko", "mislav", "ana"] ["stanko", "ana", "mislav"]
		// "mislav"

		// String[] participant = { "leo", "kiki", "eden" };
		// String[] completion = { "eden", "kiki" };
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		Solution sol = new Solution();
		String result = sol.solution(participant, completion);
		System.out.println("result : " + result);
	}

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < participant.length; i++) {
			if(map.containsKey(participant[i])){
				int cnt = map.get(participant[i]);
				map.put(participant[i], ++cnt);
			}else{
				map.put(participant[i], 1);
			}
		}
		
		for (int i = 0; i < completion.length; i++) {
			if(map.containsKey(completion[i])){
				int cnt = map.get(completion[i]);
				if(cnt == 1){
					map.remove(completion[i]);
				}else{
					map.put(completion[i], --cnt);
				}
			}
		}
		for(String s : map.keySet()){
			answer = s;
		}
		
		return answer;
	}

	public static <K, V> K getKey(HashMap<K, V> map, V value) {
		for (K key : map.keySet()) {
			if (value.equals(map.get(key))) {
				return key;
			}
		}
		return null;
	}
}
