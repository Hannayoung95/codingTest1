package makeZero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public class Node {
		int a; // 가중치
		int num; // 노드의 번호
//		ArrayList<Node> childList;
		ArrayList<Integer> childList;

		public Node(int a, int num) {
			this.a = a;
			this.num = num;
//			this.childList = new ArrayList<Node>();
			this.childList = new ArrayList<Integer>();
		}

		void addA(int a){
			this.a += a;
		}
		
		void addNode(int nodeNum) {
			this.childList.add(nodeNum);
		}
	}

	public LinkedList<Node> nodeList = new LinkedList<Node>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();

		int[] a = { -5, 0, 2, 1, 2 };
		int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };
		long result = sol.solution(a, edges);
		System.out.println("reusutl : " + result);
	}

	public long solution(int[] a, int[][] edges) {
		long answer = -2;

		int sum = 0;
		int zeroCnt = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] == 0){
				zeroCnt++;
			}
			sum += a[i];
		}
		if(zeroCnt == a.length) // 처음부터 트리의 모든 정점의 가중치가 0이라면
			return 0;
		
		if (sum != 0) {
			return -1;
		}
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			Node node = new Node(a[i], i);
			nodeList.add(i, node);
			queue.add(i);
		}

		for (int i = 0; i < edges.length; i++) {
			Node node = nodeList.get(edges[i][0]);
			Node nextNode = nodeList.get(edges[i][1]);

			node.addNode(edges[i][1]);
			nextNode.addNode(edges[i][0]);

			nodeList.set(edges[i][0], node);
			nodeList.set(edges[i][1], nextNode);
		}

		int cnt = 0;

		
		
		while (!queue.isEmpty()) {
			//System.out.println("!");
			int nextNodeNum = queue.peek();

//			System.out.println(nextNodeNum + " nodeList.get(nextNodeNum).childList.size() : " + nodeList.get(nextNodeNum).childList.size()+ " 변경전 가중치 : " + nodeList.get(nextNodeNum).a);
			int childSize = nodeList.get(nextNodeNum).childList.size();
			if (childSize == 1) { // 자식 없으면 queue에서 삭제
				// 삭제하려는 노드의 가중치를 연결된 노드의 가중치에 더함 
				
				int g = nodeList.get(nextNodeNum).a; // 삭제하려는 노드의 가중치
				int linkedNodeNum = nodeList.get(nextNodeNum).childList.get(0); // 삭제하려는 노드와 연결된 노드
				Node linkedNode = nodeList.get(linkedNodeNum); // 삭제하려는 노드와 연결된 노드
				
				if(linkedNode.childList.contains(nextNodeNum)) {
					linkedNode.childList.remove(linkedNode.childList.indexOf(nextNodeNum));
				}
				
//				for(int i=0; i<linkedNode.childList.size(); i++) {
//					if(linkedNode.childList.get(i) == nextNodeNum) {
//						linkedNode.childList.remove(i);
//						break;
//					}
//				}
				linkedNode.addA(g); // 연결된 노드에 가중치를 더 함.
				nodeList.set(linkedNode.num, linkedNode); // nodeList에 반영
				queue.remove(); // queue에서 삭제
				cnt += Math.abs(g); // 반복횟수 더하기
			}else if (childSize == 0){
				queue.remove();
				break;
			}else{
				nextNodeNum = queue.poll(); // 마지막에 넣기
				queue.add(nextNodeNum);
			}
		}
		answer = cnt;
		return answer;
	}

}
