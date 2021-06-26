package diskController;

import java.util.PriorityQueue;

public class disk_controller_hny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		disk_controller_hny disk = new disk_controller_hny();

		// 작업이 요청되는 시점, 작업의 소요시간
		int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		disk.solution(jobs);
	}

	static class ArriveNode {
		int arriveTime;
		int jobTime;
		int num;
		ArriveNode left;
		ArriveNode right;

		ArriveNode(int arriveTime, int jobTime, int num) {
			this.arriveTime = arriveTime;
			this.jobTime = jobTime;
			this.num = num;
			left = null;
			right = null;
		}

	}

	static class JobNode {
		int arriveTime;
		int jobTime;
		int num;
		JobNode left;
		JobNode right;

		JobNode(int arriveTime, int jobTime, int num) {
			this.arriveTime = arriveTime;
			this.jobTime = jobTime;
			this.num = num;
			left = null;
			right = null;
		}

	}

	// 먼저 들어온 작업
	public int fcfs(int[][] jobs) {
		PriorityQueue<ArriveNode> arrivePriQ = new PriorityQueue<ArriveNode>((n1, n2) -> {
			return (n2.arriveTime > n1.arriveTime) ? -1 : 1;
		});

		for (int i = 0; i < jobs.length; i++) {
			arrivePriQ.offer(new ArriveNode(jobs[i][0], jobs[i][1], i));
		}
		
		// 유휴시간(다음 노드가 들어올때까지 남는 시간)
		int idleTime = 0;
		ArriveNode curNode = arrivePriQ.poll();
		// int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		// 0, 1, 2
		// 3, 9, 6
		int endTime = curNode.jobTime; // 3
		int takeTime = curNode.jobTime;
		
		while (!arrivePriQ.isEmpty()) {
			ArriveNode nextNode = arrivePriQ.poll();
			
			// 유후시간 = 현재노드의 도착시간 - 이전노드의 종료시간
			idleTime = nextNode.arriveTime - endTime;
			System.out.println("idleTime : " + idleTime);
			if (idleTime >= 0) { // 유휴시간이 있으면
				// 여태까지의 종료시간 = 이전노드의 종료시간 + 현재노드의 작업시간 + 유휴시간
				takeTime += nextNode.jobTime + idleTime;
				endTime += nextNode.jobTime + idleTime + 1;
			} else { // 유휴시간이 없으면
				// 여태까지의 종료시간 = 이전노드의 종료시간 + 현재노드의 작업시간 - 현재노드의 도착시간
				takeTime += nextNode.jobTime - nextNode.arriveTime;
				endTime += nextNode.jobTime - nextNode.arriveTime + 1;
			}
			System.out.println("종료시간 : " + endTime);

			curNode = nextNode;
		}

		return endTime;
	}

	// 작업시간이 짧은것부터
	public int sjf(int[][] jobs) {
		PriorityQueue<JobNode> JobPriQ = new PriorityQueue<JobNode>((n1, n2) -> {
			return (n2.jobTime > n1.jobTime) ? 1 : -1;
		});
		return 0;

	}

	public int[] heap(int[] task) {
		for (int i = 1; i < task.length; i++) {
			int child = i;
			while (child > 0) {
				int parent = (child - 1) / 2;
				if (task[child] > task[parent]) {
					int temp = task[parent];
					task[parent] = task[child];
					task[child] = temp;
				}
				child = parent;
			}
		}

		return task;
	}

	public int solution(int[][] jobs) {
		int answer = 0;

		int arriveTime = fcfs(jobs);

		int jobTime = sjf(jobs);

		System.out.println("arriveTime : " + arriveTime);
		/*
		 * if (arriveTime > jobTime) { answer = arriveTime; return arriveTime; }
		 * else { answer = jobTime; return jobTime; }
		 */
		// 하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.

		return answer;
	}
}
