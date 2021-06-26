package kNumber;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] result = sol.solution(array, commands);
		for(int next : result){
			System.out.println("next : " + next);
		}
	}

	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands[0].length];
        
        for(int a = 0; a<commands.length; a++){
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];
            
            int[] ary = new int[j - i + 1]; // 5-2 +1 = 4 , 4 4 1
            int idx = 0;
            for(int start = i-1; start < j ; start++){
                ary[idx] = array[start];
                idx++;
            }
            Arrays.sort(ary);
            answer[a] = ary[k-1];
        }
        return answer;
    }
}
