package lifeboat;

import java.util.Arrays;

public class lifeboart_hny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		lifeboart_hny sol = new lifeboart_hny();

		// [70, 50, 80, 50] 100 3
		// [70, 80, 50] 100 3

//		int[] people = { 70, 50, 80, 50 };
		int[] people = { 70, 80, 50 };
		int limit = 100;
		System.out.println("���!!!!!!!!!!1");
		System.out.println(sol.solution(people, limit));
	}

	public int solution(int[] people, int limit) {
		int answer = 0;

		int[] answerList = new int[people.length];
		int curWeight = -1;
		for (int i = 0; i < people.length; i++) {
			// ���� �ʱ�ȭ
			curWeight = people[i];
			
			for (int j = 0; j < people.length; j++) {
				// ���������� ������
				if (j == people.length - 1) {
					if ((curWeight + people[j]) > limit) {
						answer += 2;
						answerList[i] = answer;
						answer = 0;
					} else {
						answer++;
						answerList[i] = answer;
						answer = 0;
					}
				}else{
					if (i == j){ // ���� ����
						continue;
					}
					else {
						if ((curWeight + people[j]) > limit) { // ���� ������ �������� ���Ѻ���
							answer++;
							curWeight = people[j];
							
						} else {
							curWeight += people[j];
							answer++;
						}
					}
				}
			}
		}

		Arrays.sort(answerList);
		answer = answerList[0];
		return answer;
	}

}
