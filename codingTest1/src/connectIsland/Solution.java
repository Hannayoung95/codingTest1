package connectIsland;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		// 4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int result = sol.solution(n, costs);
		System.out.println("result : " + result);
	}

	public static int[] nodes;
	public int solution(int n, int[][] costs) {
        int answer = 0;
        nodes = new int[n];
        
        for(int i = 0; i<nodes.length; i++) {
        	nodes[i] = i;
        }
        
        // ����ġ ������ ������ ����
        Arrays.sort(costs, (int[] o1, int o2[]) -> (o1[2] - o2[2]) );
        int total = 0;
        for(int i = 0; i<costs.length; i++) {
        	int x = costs[i][0];
        	int y = costs[i][1];
        	int cost = costs[i][2];
        	
        	int xRoot = findRoot(x);
        	int yRoot = findRoot(y);
        	
        	// ����Ŭ�� ������ �ʰ� 
        	if(xRoot == yRoot) {
        		continue;
        	}
        	
        	total += cost;
        	nodes[yRoot] = nodes[xRoot];
        }
        answer = total;
        return answer;
    }
	
	public int findRoot(int node) {
		// �ڱ��ڽ��� �θ����
		if(nodes[node] == node) {
			return node;
		}
		
		return nodes[node] = findRoot(nodes[node]);
	}
	
}
