package test3;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		// String s = "[](){}";
		String s = "}]()[{"; // 2
		int result = sol.solution(s);
		System.out.println("result: " + result);

		// ---------------------------- 1---------
		// int[] absolutes = { 4, 7, 12 };
		// boolean[] signs = { true, false, true };
		// int[] absolutes = { 1, 2, 3 };
		// boolean[] signs = { false, false, true };
		// int result = sol.solution(absolutes, signs);
	}

	public char getCharAsci(char next) {
		switch (next) {
		case '(':
			return ')';
		case ')':
			return '(';
		case '[':
			return ']';
		case ']':
			return '[';
		case '{':
			return '}';
		case '}':
			return '{';
		default:
			System.out.println("����");
		}
		return '-';
	}

	public boolean isOpen(char next) {

		switch (next) {
		case '(':
			return true;
		case ')':
			return false;
		case '[':
			return true;
		case ']':
			return false;
		case '{':
			return true;
		case '}':
			return false;
		default:
			System.out.println("����");
		}
		return false;
	}

	public String rotate(String s) {
		StringBuffer sb = new StringBuffer();
		sb.append(s);
		// �Ǿտ� ���� �����ؼ� �ڿ� ���̱�
		// �������� ȸ��
		char first = sb.charAt(0);
		sb.insert(sb.length(), first);
		sb.deleteCharAt(0);
		return sb.toString();
	}

	public int solution(String s) {
		int answer = -1;

		// Ȧ����
		if (s.length() % 2 != 0) {
			answer = 0;
			return answer;
		}

		StringBuffer sb = new StringBuffer();
		Stack<Character> st = new Stack<Character>();

		sb.append(s);

		int cnt = 0;
		boolean flag = false;

		for (int i = 0; i < sb.length(); i++) {
			for (int j = 0; j < sb.length(); j++) {
				System.out.println("stack : " + st.toString());
				if (isOpen(sb.charAt(j))) { // ���� ��ȣ�̸�
					System.out.println("���� ��ȣ �ֱ� : " + sb.charAt(j));
					st.push(sb.charAt(j));
				} else { // �ݴ� ��ȣ�̸�
					if (st.size() == 0) {
						System.err.println("stack size 0 �ε� �ݴ� ��ȣ rotate �ʿ�");
						flag = true;
						break;
					}
					if (getCharAsci(sb.charAt(j)) == st.peek()) { // ���ÿ� ������
																	// �ִ��Ŷ� ����
																	// ���̸�
						char popData = st.pop();
						System.out.println("popdata : " + popData);
					} else {
						System.err.println("���� ���� �ƴ�");
						break;
					}
				}
			}
			if (st.isEmpty() && flag == false) {
				cnt++;
			}
			// �������� rotate
			sb.replace(0, sb.length(), rotate(sb.toString()));
			flag = false;
		}

		answer = cnt;
		return answer;
	}

	// public int solution(int[] absolutes, boolean[] signs) {
	// int answer = 123456789;
	//
	// int temp = 0;
	// for(int i = 0; i<signs.length; i++){
	// if(signs[i]){ // ���
	// temp = temp + absolutes[i];
	// }else{
	// temp = temp - absolutes[i];
	// }
	// }
	//
	// answer = temp;
	// return answer;
	// }

}
