package parenthesis;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

		// TEST CASE RESULT
		// "(()())()" "(()())()"
		// ")(" "()"
		// "()))((()" "()(())()"

		// - 올바른 괄호 문자열 "(())()" ( 이 괄호가 먼저 시작해야하고 ( 이 개수와 ) 이 개수가 맞을때
		// 경우의수
		// () (()) ((()))
		// - 균형잡힌 괄호 문자열 "(()))(" 전체적으로 봤을때 개수만 맞으면 됨..

		// 조건
		// u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다. == 문자열 u가
		// "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
		// "(()))(" 일 경우

		sol.solution("(()())()");
	}

	// 올바른 괄호문자열인지 체크
	public boolean isBalanced(String strU) {
		boolean flag = false;
		int cnt = 1;
		char nextChar = strU.charAt(0);
		int cntOfChar = 0;

		for (int i = 1; i < strU.length(); i++) {
			if (nextChar != strU.charAt(i)) {
				if (flag == false) {
					cntOfChar = cnt;
					flag = true;
					nextChar = strU.charAt(i);
					cnt = 1;
					continue;
				} else {
					if (cntOfChar == cnt) {
						nextChar = strU.charAt(i);
						cnt = 1;
						cntOfChar = 0;
						flag = false;
					} else {
						return false;
					}
				}
			} else {
				cnt++;
			}
		}
		return true;
	}

	// public String recursive(String strU, String strV){
	// String result = "";
	// // 올바른 문자열 x
	// if(isBalanced(strU) == false){
	// result +="(";
	// // 재귀
	// recursive(strU, strV) + recursive(strU, strV);
	// }else{
	// // 올바른 문자열
	// // 문자열 v 재귀
	// return strU + recursive(strU, strV);
	// }
	// }

	// 균형잡힌 문자열로 분리
	public String[] seperate(String p) {
		int cntL = 0; // (
		int cntR = 0; // )
		String[] result = new String[2];

		for (int i = 0; i < p.length(); i++) {
			
			if (p.charAt(i) == '(') {
				cntL++;
			} else {
				cntR++;
			}
			System.out.println("********");
			System.out.println("CNTL: " + cntL);
			System.out.println("CNTR: " + cntR);
			System.out.println("********");
			
			if (cntL == cntR) {
				System.out.println("i : " + i);
				System.out.println("chart at i : " + p.charAt(i));
				result[0] = p.substring(0, i+1);
				result[1] = p.substring(i+1, p.length());
				System.out.println("strU : " + result[0]);
				System.out.println("strV : " + result[1]);
				break;
			}
		}

		return result;

	}

	public String reverse(String p) {
		String answer = "";
		for (int i = 0; i < p.length(); i++) {
			if(p.charAt(i) == '('){
				answer+= ")";
			}else{
				answer+= "(";
			}
		}
		return answer;
	}

	public String solution(String p) {
		String answer = "";
		System.out.println("p : " + p);
		if (p.equals("")) { // 빈문자열이면
			return "";
		}

		String[] strSeperate = new String[2];
		// 문자열 u, v 분리
		strSeperate = seperate(p);
		String strU = strSeperate[0];
		String strV = strSeperate[1];

		// 올바른 문자열 x
		if (isBalanced(strU) == false) {
			System.out.println("올바른 문자열이 아닙니다.");
			answer += "(";
			// 재귀
			answer += solution(strV) + ")";
			// 문자열 괄호방향 뒤집기
			answer += reverse(strU.substring(1, strU.length()));
			return answer;
		} else {
			System.out.println("올바른 문자열입니다.");
			// 올바른 문자열
			// 문자열 v 재귀
			return strU + solution(strV);
		}

	}
}
