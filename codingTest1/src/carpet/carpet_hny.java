package carpet;

public class carpet_hny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		carpet_hny sol = new carpet_hny();

//		int brown = 10;
		 int brown = 8;
//		 int brown = 24;
//		int yellow = 2;
		 int yellow = 1;
//		 int yellow = 24;
		int[] result = sol.solution(brown, yellow);
		for(int i = 0 ; i<result.length; i++){
			System.out.println(result[i]);
		}
	}

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		int a = 3; // 가로
		int b = 2; // 세로
		int sum = (brown + 4) / 2;
		z: for (a = 3; a <= yellow + 3; a++) {
			for (b = 3; b <= yellow + 3; b++) {
				if ((a - 2) * (b - 2) == yellow && (a+b) == sum) {
					if(a > b){
						answer[0] = a;
						answer[1] = b;
					}else{
						answer[0] = b;
						answer[1] = a;
					}
					break z;
				}
			}
		}
		return answer;
	}

}
