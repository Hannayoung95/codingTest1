package newId;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

//		String new_id = "...!@BaT#*..y.abcdefghijklm"; // "bat.y.abcdefghi"
//		String new_id = "z-+.^."; //"z--"
		String new_id = "=.="; // "aaa"
		// String new_id = "123_.def"; // "123_.def"
		// String new_id = "abcdefghijklmn.p"; // "abcdefghijklmn"
		String result = sol.solution(new_id);
		System.out.println(result);
	}

	public String solution(String new_id) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		String match = "[^0-9a-z\\s-_.]";
		
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll(match, "");
        
        boolean del = false;
        
        for(int i=0; i<new_id.length(); i++) {
           char cur = new_id.charAt(i);
           
           if(cur == '.') {
              if(!del) sb.append(cur); 
              del = true;
           } else {
        	   sb.append(cur);
              del = false;
           }
        }
        
		if(!sb.toString().isEmpty() && '.' == sb.charAt(0)){
			sb.deleteCharAt(0);
		}
		
		if(!sb.toString().isEmpty() && '.' == sb.charAt(sb.length() -1)){
			sb.deleteCharAt(sb.length()-1);
		}
//		if(sb.equals("")){
		if(sb.toString().isEmpty()) {
			sb.append("a");
		}
		
		if(sb.length() >= 16){
			sb.delete(15, sb.length());
		}
		if(!sb.toString().isEmpty() && '.' == sb.charAt(sb.length()-1)){
			sb.deleteCharAt(sb.length()-1);
		}
		
		if(sb.length() <= 2){
			while(sb.length() < 3){
				sb.append(sb.charAt(sb.length()-1));
			}
		}
		
		answer = sb.toString();
		return answer;
	}

}
