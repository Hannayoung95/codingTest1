package test1;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		lottos	win_nums	result
//		[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]	[3, 5]
//		[0, 0, 0, 0, 0, 0]	[38, 19, 20, 40, 15, 25]	[1, 6]
//		[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]	[1, 1]
		
		Solution sol = new Solution();
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] result = new int[2];
		result= sol.solution(lottos, win_nums);
		
//		result.toString();
		System.out.println(result[0] +"," + result[1] );
	}

	// 구매, 당첨
	public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0; // 당첨된 구매한 번호 개수
        int zeroCount = 0; // 0인 번호개수
        
        for(int i = 0 ; i < win_nums.length; i++){
        	for(int j = 0; j<lottos.length; j++){
        		if(lottos[j] == win_nums[i]){
        			count++;
        			break;
        		}
        	}
        }
        
        for(int j = 0; j<lottos.length; j++){
        	if(lottos[j] == 0){
        		zeroCount++;
        	}
        }
        // 최저
        answer[0] = getRank(count + zeroCount);
        answer[1] = getRank(count);
        
        return answer;
    }
	
	public int getRank(int cnt){
		switch(cnt){
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
		
	}
}
