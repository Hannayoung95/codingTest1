package greedy.makeBiggerNumber;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
//		"18765432", 3, "87654"
//		"77413258", 2, "774358"
//		"12345678901234567890", 19, "9"
//		"01010", 3, "11"
//		"559913", 1, "59913"
//		"9191919", 1, "991919"
//		"00100", 2, "100"
//		4177252841 , 4, 775841
//		87654321", 3, "87654"
		
//		String number = "4177252841"; 
//		int k = 4;
		String number = "4177252841"; 
		int k = 4;
//		String number = "9191919"; 
//		int k = 1	;
//		String number = "87654321"; 
//		int k = 3;
//		String number = "01010"; 
//		int k = 3;
		String result = sol.solution(number, k);
		System.out.println("result : " + result);
	}
	
	public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
