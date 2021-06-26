package triangle;

public class integer_triangle_hny {

	public static int max = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}

	public static void getMax(int[][] tri, int x, int y, int val, int t) {
		if(tri.length - 1  <= t) {
			if(max < val) {
				max = val;
			}
			return;
		}
		
		t = t + 1;
		if(y>=0) {
			getMax(tri, t, y, val + tri[t][y], t);
		}
		
		if(y< tri.length - 1) {
			getMax(tri, t, y+1, val + tri[t][y+1], t);
			
		}
	}
	public static int solution(int[][] triangle) {
		getMax(triangle, 0, 0, triangle[0][0], 0);
		return max;
	}
}



