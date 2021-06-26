package joystick;

public class joy_stick_hny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		joy_stick_hny sol = new joy_stick_hny();

		// JEROEN 56
		// JAN 23
		System.out.println(sol.solution("JEROEN"));
		System.out.println(sol.solution("JAN"));

	}

	public int getUpDownCount(char next) {
		int count = 0;
		switch (next) {
		/*
		 * case 'A': count = 0; return count;
		 */
		case 'B':
			count = 1;
			return count;
		case 'C':
			count = 2;
			return count;
		case 'D':
			count = 3;
			return count;
		case 'E':
			count = 4;
			return count;
		case 'F':
			count = 5;
			return count;
		case 'G':
			count = 6;
			return count;
		case 'H':
			count = 7;
			return count;
		case 'I':
			count = 8;
			return count;
		case 'J':
			count = 9;
			return count;
		case 'K':
			count = 10;
			return count;
		case 'L':
			count = 11;
			return count;
		case 'M':
			count = 12;
			return count;
		case 'N':
			count = 13;
			return count;
		case 'O':
			count = 12;
			return count;
		case 'P':
			count = 11;
			return count;
		case 'Q':
			count = 10;
			return count;
		case 'R':
			count = 9;
			return count;
		case 'S':
			count = 8;
			return count;
		case 'T':
			count = 7;
			return count;
		case 'U':
			count = 6;
			return count;
		case 'V':
			count = 5;
			return count;
		case 'W':
			count = 4;
			return count;
		case 'X':
			count = 3;
			return count;
		case 'Y':
			count = 2;
			return count;
		case 'Z':
			count = 1;
			return count;
		}
		return count;
	}

	public static boolean[] nameB;
	
	
	public boolean isFinished(){
		for(int i = 0; i<nameB.length; i++){
			if(nameB[i] == false){
				return false;
			}
		}
		return true;
	}
	
	public int nextIndx(){
		int result = 0;
		return result;
	}
	
	public int solution(String name) {
		int answer = 0;

		int lRCount = 0;
		int upDownCnt = 0;
		StringBuilder sb = new StringBuilder();

		// name 개수만큼 nameD에 A 생성
		for (int i = 0; i < name.length(); i++) {
			sb.append("A");
		}
		
		nameB = new boolean[sb.length()];
		
		while(!isFinished()){
			int indx = nextIndx();
			
		}
		
		
		// 위아래 이동
		for (int i = 0; i < name.length(); i++) {
			// name.charAt(i) 가 A면 위아래 이동이 필요없음 -> 왼쪽으로 갈지 오른쪽으로 갈지 결정. -> 최소이동
			if (name.charAt(i) == 'A') {

			} else {
				upDownCnt = getUpDownCount(name.charAt(i));

			}
		}
		return answer;
	}
}
