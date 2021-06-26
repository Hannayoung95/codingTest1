package makeZero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public class Node {
		int a; // ����ġ
		int num; // ����� ��ȣ
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
		if(zeroCnt == a.length) // ó������ Ʈ���� ��� ������ ����ġ�� 0�̶��
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

//			System.out.println(nextNodeNum + " nodeList.get(nextNodeNum).childList.size() : " + nodeList.get(nextNodeNum).childList.size()+ " ������ ����ġ : " + nodeList.get(nextNodeNum).a);
			int childSize = nodeList.get(nextNodeNum).childList.size();
			if (childSize == 1) { // �ڽ� ������ queue���� ����
				// �����Ϸ��� ����� ����ġ�� ����� ����� ����ġ�� ���� 
				
				int g = nodeList.get(nextNodeNum).a; // �����Ϸ��� ����� ����ġ
				int linkedNodeNum = nodeList.get(nextNodeNum).childList.get(0); // �����Ϸ��� ���� ����� ���
				Node linkedNode = nodeList.get(linkedNodeNum); // �����Ϸ��� ���� ����� ���
				
				if(linkedNode.childList.contains(nextNodeNum)) {
					linkedNode.childList.remove(linkedNode.childList.indexOf(nextNodeNum));
				}
				
//				for(int i=0; i<linkedNode.childList.size(); i++) {
//					if(linkedNode.childList.get(i) == nextNodeNum) {
//						linkedNode.childList.remove(i);
//						break;
//					}
//				}
				linkedNode.addA(g); // ����� ��忡 ����ġ�� �� ��.
				nodeList.set(linkedNode.num, linkedNode); // nodeList�� �ݿ�
				queue.remove(); // queue���� ����
				cnt += Math.abs(g); // �ݺ�Ƚ�� ���ϱ�
			}else if (childSize == 0){
				queue.remove();
				break;
			}else{
				nextNodeNum = queue.poll(); // �������� �ֱ�
				queue.add(nextNodeNum);
			}
		}
		answer = cnt;
		return answer;
	}

}
