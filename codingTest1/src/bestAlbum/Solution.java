package bestAlbum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Solution {

	// �����Ѱ� v
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
//		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
//		int[] plays = {500, 600, 150, 800, 2500};
//		String[] genres = {"A", "A", "B", "A", "B", "B"};
//		int[] plays = {5, 5, 6, 5, 7, 7};  
//		String[] genres = {"A", "A", "B", "A"};
//		int[] plays = {5, 5, 6, 5};  
//		String[] genres = {"A", "A", "B", "A"};
//		int[] plays = {2,2,2,3};  
//		String[] genres = {"A", "B", "C", "D"};
//		int[] plays = {1,2,3,1};  
//		String[] genres = {"A", "B", "C"};
//		int[] plays = {1,2,3};  
		String[] genres = {"A", "A", "B"};
		int[] plays = {600, 500, 300};  
		
//		'pop' 'pop' 'pop' 'rap' 'rap' [45,50,40, 60, 70] ==> [ 1, 0, 4, 3]
				
//		String[] genres = {"pop", "pop", "pop", "rap", "rap"};
//		int[] plays = {45,50,40, 60, 70};
		
		int[] result = sol.solution(genres, plays);
		for(int i : result){
			System.out.print(i + ",");
		}
	}
	
	public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        // �帣�� ����� Ƚ�� ����
        // �帣, ����� Ƚ��
        HashMap<String, Integer> genreCntMap = new HashMap<String, Integer>();
        // �帣�� ������ȣ����Ʈ
        // �帣, ������ȣ
        HashMap<String, LinkedList<Integer>> genreUniqNo = new HashMap<String, LinkedList<Integer>>();

        int cnt = 0;
        for(int i = 0 ;i <genres.length; i++){
        	String nextGenre = genres[i];
        	int nextPlay = plays[i];
        	if(genreCntMap.containsKey(nextGenre)){
        		cnt = genreCntMap.get(nextGenre);
        		genreCntMap.put(nextGenre, (cnt + nextPlay));
        	}else{
        		genreCntMap.put(nextGenre, nextPlay);
        	}
        }
        
        LinkedList<Integer> uniqNoAry;
        for(int i = 0 ;i <genres.length; i++){
        	String nextGenre = genres[i];
        	int play = plays[i];
        	System.out.println("*********** 1  ************");
        	System.out.println("next GENRE : " + nextGenre);
        	System.out.println("play : "  + play);
        	System.out.println("��ü�Ϸ��� ������ȣ : " +  i);
        	System.out.println("***********************");
        	System.out.println("");
        	if(genreUniqNo.containsKey(nextGenre)){ // �帣, ������ȣ ����Ʈ
        		System.out.println("Ű �� ����");
        		uniqNoAry = genreUniqNo.get(nextGenre);
        		
        		for(int j = 0 ; j<uniqNoAry.size(); j++){
        			int uniqNo = uniqNoAry.get(j); // ������ȣ
        			System.out.println("***********  2  ************");
        			System.out.println("uniqNo : " + uniqNo);
        			System.out.println("plays[uniqNo] : " + plays[uniqNo]);
        			System.out.println("***********************");
        			
        			if(plays[uniqNo] > play ){
        				/*String[] genres = {"A", "A", "B"};
        				int[] plays = {600, 500, 300};  
        				=> 0, 1, 2*/
        				boolean flag = true;
        				for(int z = j+1; z<uniqNoAry.size(); z++){
        					int nextUniqNo = uniqNoAry.get(z);
        					if(plays[nextUniqNo] > play){
        						continue;
        					}
        					uniqNoAry.add(z, i);
        					flag = false;
        					break;
        				}
        				
        				if(flag){
        					uniqNoAry.add(i);
        				}
        				break;
        			}else if(plays[uniqNo] < play  ){ // ���Ƚ���� ���� ������ ����
        				uniqNoAry.add(j, i);
        				System.out.println("��ü");
        				break;
        			}else { // ���Ƚ���� ������ ������ȣ�� ���� �뷡�� ���� ���� -> ���Ƚ���� ���� ������ ����
						/*String[] genres = {"A", "A", "B", "A", "B", "B"};
						int[] plays = {5, 5, 6, 5, 7, 7};  
        				=> 4, 5, 0, 1*/
        				boolean flag = true;
        				for(int z = j+1; z<uniqNoAry.size(); z++){
        					int nextUniqNo = uniqNoAry.get(z);
        					if(plays[nextUniqNo] == play){
        						continue;
        					}
        					uniqNoAry.add(z, i);
        					flag = false;
        					break;
        				}
        				
        				if(flag){
        					uniqNoAry.add(i);
        				}
        				break;
        			}
        		}
        		
        		genreUniqNo.put(nextGenre, uniqNoAry);
        		System.out.println("������ȣ ����Ʈ >>> " + genreUniqNo.keySet().toString());
        		System.out.println(" >>> " + genreUniqNo.entrySet().toString());
        		System.out.println("");
        	}else{
        		System.out.println("Ű �� ����");
        		System.out.println("");
        		uniqNoAry = new LinkedList<Integer>();
        		uniqNoAry.add(i);
        		genreUniqNo.put(nextGenre, uniqNoAry);
        	}
        }
        
        List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(genreCntMap.entrySet());
        Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue()); // �������� ����
			}
		});
        
        
        ArrayList<Integer> tempAry = new ArrayList<Integer>();
        for(Entry<String, Integer> next : list_entries){
        	LinkedList<Integer> nextUniqAry;
        	
        	if(genreUniqNo.containsKey(next.getKey())){
        		nextUniqAry = genreUniqNo.get(next.getKey());
        		
        		if(nextUniqAry.size() == 1){
        			tempAry.add(nextUniqAry.get(0));
        			continue;
        		}
        		
        		int tempCnt = 0; // �ִ� 2�������� ����
        		for(int uniqNo : nextUniqAry){
        			if(tempCnt == 2){
        				break;
        			}
        			tempAry.add(uniqNo);
        			tempCnt++;
        		}
        	}
        }
        answer = new int[tempAry.size()];
        int index = 0;
        for(int nextInt : tempAry){
        	answer[index] = nextInt;
			index++;
        }
        return answer;
    }

}
