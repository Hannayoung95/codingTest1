package greedy;

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

	public static int K = -1;
	public static StringBuilder list;
	public String solution(String number, int k) {
        String answer = "";
        list = new StringBuilder();
        for(int i = 0; i<number.length(); i++) {
        	list.append(number.charAt(i));
        }
        K = k;
        while(true) {
        	
        	String temp1 = makeNum();
        	if(K == 0) {
        		answer = temp1;
        		break;
        	}
        	String temp2 = makeNum();
        	if(K == 0) {
        		answer = temp2;
        		break;
        	}
        	
        	if(temp1.equals(temp2)) {
        		answer = temp1.substring(0, temp1.length()-K);
        		break;
        	}
        }
        return answer;
    }
	
	public String makeNum() {
		for(int i = 1; i< list.length(); i++) {
    		if(K == 0) {
    			break;
    		}
    		if(list.charAt(i-1)-'0' < list.charAt(i) - '0') {
    			list.deleteCharAt(i-1);
    			K--;
    			i--;
    			
    		}
    		
    		if(list.charAt(0) - '0' == 0) {
    			list.deleteCharAt(0);
    			K--;
    		}
    	}
		return list.toString();
		
	}
}
