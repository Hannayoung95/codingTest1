package entrance_rvew;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class entrance_rvew_hny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		entrance_rvew_hny sol = new entrance_rvew_hny();

		int n = 6;
		int[] times = { 7, 10 };

		System.out.println(sol.solution(n, times));
	}

	class Rvewer {
		int workingT; // 작업시간 , 7 , 10
		int scheduledT; // 7, 14, 21, 28, 35
						// 10, 20, 30,40
		int nextScheduledT; // 14
							// 20

		public Rvewer(int workingT, int scheduledT, int nextScheduledT) {
			this.workingT = workingT;
			this.scheduledT = scheduledT;
			this.nextScheduledT = nextScheduledT;
		}

	}

	public long solution(int n, int[] times) {
		long answer = 0;

		List<Rvewer> rvewerList = new ArrayList<Rvewer>();
		// 심사관 생성
		for (int i = 0; i < times.length; i++) {
			Rvewer r1 = new Rvewer(times[i], 0, 0);
			rvewerList.add(r1);
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < rvewerList.size(); j++) {
				Rvewer next = rvewerList.get(j);
				if (next.scheduledT == 0) { // 처음 생성한 후
					next.scheduledT += next.workingT;
				} else {
					// 심사관의 예정작업시간을 비교
					next.nextScheduledT = next.scheduledT + next.workingT;
				}
			}

			if(rvewerList.get(0).nextScheduledT == 0){
				continue;
			}else{
				rvewerList.sort(new Comparator<Rvewer>() {
					@Override
					public int compare(Rvewer o1, Rvewer o2) {
						// TODO Auto-generated method stub
						return o1.nextScheduledT > o2.nextScheduledT ? 1: -1;
					}
				});
				
				for(int j = 0 ; j<rvewerList.size(); j++){
					Rvewer next = rvewerList.get(j);
					if(j == 0){
						next.scheduledT = next.nextScheduledT;
						next.nextScheduledT = 0;
						rvewerList.set(j, next);
					}else{
						next.scheduledT = next.scheduledT;
						next.nextScheduledT = 0;
						rvewerList.set(j, next);
					}
				}
			}
		}
		rvewerList.sort(new Comparator<Rvewer>() {
			@Override
			public int compare(Rvewer o1, Rvewer o2) {
				// TODO Auto-generated method stub
				return o1.scheduledT > o2.scheduledT ? 1: -1;
			}
		});
		
		answer = rvewerList.get(0).scheduledT;
		
		return answer;
	}
}
