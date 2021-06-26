package farestNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class farest_node_hny {

	public static int solution(int n, int[][] edge) {
        int answer = 0;
        int max = 0;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();	//노드별 이어져있는 노드
        
        for(int i=0; i<edge.length; i++) {
        	list.add(new ArrayList<Integer>());
        }
        
        for(int[] node : edge) {
        	list.get(node[0]).add(node[1]);
        	list.get(node[1]).add(node[0]);
        }
        
        
        int[] count = new int[edge.length+1];	//1과의 거리 저장
        boolean[] visited = new boolean[edge.length+1];	//방문여부
        
        Queue<Integer> q = new LinkedList<>();
        
        visited[0] = true;
        visited[1] = true;
        q.add(1);
        
        while(!q.isEmpty()) {
        	int now = q.poll();
        	
        	for(int link : list.get(now)) {	// 현 노드와 연결되어 있는 노드들
        		if(!visited[link]) {
	        		count[link] = count[now] + 1;
	        		visited[link] = true;
	        		q.add(link);
        		}
        	}
        }
        
        for(int i=0; i<count.length; i++) {
        	if(max < count[i]) {
        		max = count[i];
        		answer=1;
        	}else if(max == count[i]) {
        		answer++;
        	}
        }
        
        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int edge[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, edge));
	}


}
