package findRoute;

import java.util.PriorityQueue;

public class path_finding_game_HNY {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		path_finding_game_HNY sol = new path_finding_game_HNY();
		int[][] nodeInfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } };

		// test case
		// result: [[7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]]

		int[][] result = new int[2][nodeInfo.length];
		result = sol.solution(nodeInfo);
		
		for(int i = 0 ; i< result.length; i++){
			for(int j = 0 ; j< result[0].length; j++){
				System.out.print(result[i][j]+ " ");
			}
			System.out.println("");
		}
	}
	
	public static int index = 0;

	static class Node {
		int x;
		int y;
		int num;
		Node left;
		Node right;

		Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
			left = null;
			right = null;
		}

	}
	
	// ROOT LEFT RIGHT
	public void preOrder(Node cur, int[] preOrder){
		if(cur == null){
			return;
		}
		preOrder[index++] = cur.num;
		preOrder(cur.left, preOrder);
		preOrder(cur.right, preOrder);
	
	}
	
	// LEFT RIGHT ROOT
	public void postOrder(Node cur, int[] postOrder){
		if(cur == null){
			return;
		}
		postOrder(cur.left, postOrder);
		postOrder(cur.right, postOrder);
		postOrder[index++] = cur.num;
	}

	public int[][] solution(int[][] nodeinfo) {
		// nodeinfo.length가 노드의 개수
		int[][] answer = new int[2][nodeinfo.length];

		PriorityQueue<Node> priQ = new PriorityQueue<Node>((n1, n2) -> {
			return (n2.y > n1.y) ? 1 : (n1.y > n2.y) ? -1 : (n1.x > n2.x) ? 1 : (n2.x > n1.x) ? -1 : 0;
		});

		Node root = null;
		Node cur = null;
		Node prv = null;
		int[] preOrder = new int[nodeinfo.length];
        int[] postOrder =new int[nodeinfo.length];
        answer[0] = preOrder;
        answer[1] = postOrder;

		// node 추가
		for (int i = 0; i < nodeinfo.length; i++) {
			// nodeinfo[i] 는 i + 1번 노드의 좌표, 우선순위 큐는 offer
			priQ.offer(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));	// x, y, number
		}
		
		root = priQ.poll();
		
		while(!priQ.isEmpty()){
			cur = root;
			Node nextNode = priQ.poll();
			
			while(cur != null){
				if(nextNode.x < cur.x){	// 왼쪽
					prv = cur;
					cur = cur.left;
				}else if(nextNode.x > cur.x){	// 오른쪽
					prv = cur;
					cur = cur.right;
				}
			}
			
			if(prv.left == null && nextNode.x < prv.x){
				prv.left = nextNode;
			}
			
			if(prv.right == null && nextNode.x > prv.x){
				prv.right = nextNode;
			}
		}
		
		preOrder(root, preOrder); // 전위순회
		index = 0; // 인덱스 초기화
		postOrder(root, postOrder); // 후위순회
		
		return answer;
	}
}
