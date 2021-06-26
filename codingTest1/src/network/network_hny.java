package network;

public class network_hny {

public static int groupId = 10;
	
	public static void makeGroup(int[][] computers, int x, int y, int group) {
		if(computers[x][y] == 1) {
			computers[x][y] = group;
			computers[y][x] = group;
			computers[x][x] = group;
			computers[y][y] = group;
		}
		
		for(int i=0; i<computers.length; i++) {
			if(i == y) {
				for(int j=0; j<computers[i].length; j++) {
					if(computers[i][j]==1) makeGroup(computers, i, j, group);
				}
			}
			else if(i == y) {
				for(int j=0; j<computers[i].length; j++) {
					if(computers[i][j]==1) makeGroup(computers, i, j, group);
				}
			}
		}
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		for(int i=0; i<computers.length; i++) {
			for(int j=0; j<computers.length; j++) {
				//¹«¼Ò¼Ó
				if(computers[i][j] == 1) {
					makeGroup(computers, i, j, groupId++);
				}
			}
		}
		
		for(int i=0; i<computers.length; i++) {
			for(int j=0; j<computers.length; j++) {
				System.out.print(computers[i][j] + " ");
			}
			System.out.println();
		}
		answer = groupId - 10;
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		solution(n,computers);
	}

}
