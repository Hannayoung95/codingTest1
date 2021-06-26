package num124;

import java.util.Scanner;

public class Solution {

	public static int[] ary = {1, 2, 4};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String result = sol.solution(n);
		System.out.println("result : " + result);
	}

	public int getDigits(int n){
		// n 500,000,000 юлго
		// 3 * 1  + 3 *2 + 3 * 3 + 3 *4 
		int temp = 0;
		int count = 0;
		for(int i= 1 ; i< 166666667; i++){
			temp += 3*i;
			count++;
			if(n <= temp){
				return count;
				
			}
		}
		return -1;
	}
	
	public String solution(int n) {
		String answer = "";
		int digit = getDigits(n);
		System.out.println("digit ? " + digit);
		
		int a = n / 3;
		int b = n % 3;
		
		return answer;
	}
}