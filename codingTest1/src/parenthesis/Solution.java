package parenthesis;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

		// TEST CASE RESULT
		// "(()())()" "(()())()"
		// ")(" "()"
		// "()))((()" "()(())()"

		// - �ùٸ� ��ȣ ���ڿ� "(())()" ( �� ��ȣ�� ���� �����ؾ��ϰ� ( �� ������ ) �� ������ ������
		// ����Ǽ�
		// () (()) ((()))
		// - �������� ��ȣ ���ڿ� "(()))(" ��ü������ ������ ������ ������ ��..

		// ����
		// u�� "�������� ��ȣ ���ڿ�"�� �� �̻� �и��� �� ����� �ϸ�, v�� �� ���ڿ��� �� �� �ֽ��ϴ�. == ���ڿ� u��
		// "�ùٸ� ��ȣ ���ڿ�" �̶�� ���ڿ� v�� ���� 1�ܰ���� �ٽ� �����մϴ�.
		// "(()))(" �� ���

		sol.solution("(()())()");
	}

	// �ùٸ� ��ȣ���ڿ����� üũ
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
	// // �ùٸ� ���ڿ� x
	// if(isBalanced(strU) == false){
	// result +="(";
	// // ���
	// recursive(strU, strV) + recursive(strU, strV);
	// }else{
	// // �ùٸ� ���ڿ�
	// // ���ڿ� v ���
	// return strU + recursive(strU, strV);
	// }
	// }

	// �������� ���ڿ��� �и�
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
		if (p.equals("")) { // ���ڿ��̸�
			return "";
		}

		String[] strSeperate = new String[2];
		// ���ڿ� u, v �и�
		strSeperate = seperate(p);
		String strU = strSeperate[0];
		String strV = strSeperate[1];

		// �ùٸ� ���ڿ� x
		if (isBalanced(strU) == false) {
			System.out.println("�ùٸ� ���ڿ��� �ƴմϴ�.");
			answer += "(";
			// ���
			answer += solution(strV) + ")";
			// ���ڿ� ��ȣ���� ������
			answer += reverse(strU.substring(1, strU.length()));
			return answer;
		} else {
			System.out.println("�ùٸ� ���ڿ��Դϴ�.");
			// �ùٸ� ���ڿ�
			// ���ڿ� v ���
			return strU + solution(strV);
		}

	}
}
