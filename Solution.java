package WW;

import java.util.Arrays;

public class Solution {

//	{{0,2},{2,3},{3,4},{4,6}} 답은 2
//
//	추가로 아래 부분들은 질문게시판 내용들 모았습니다.
//
//	cout << solution({ {-20, 15}, {-14, -5}, {-18, -13}, {-5, -3} }); //2
//	cout << endl;
//	cout << solution({ {-2, -1}, {1, 2}, {-3, 0} });//2
//	cout << endl;
//	cout << solution({ {0, 0}, });//1
//	cout << endl;
//	cout << solution({ {0, 1}, {0, 1}, {1, 2} });//1
//	cout << endl;
//	cout << solution({ {0, 1}, {2, 3}, {4, 5}, {6, 7} });//4
//	cout << endl;
//	cout << solution({ {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3} });//2
//	cout << endl;
//	cout << solution({ {-20, 15}, {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3} });//2
//	cout << endl;
//	cout << solution({ {2,2},{0,1},{-10,9} });//2
//	cout << endl;
//	cout << solution({ {-7, 0}, {-6, -4}, {-5, -3}, {-3, -1}, {-1, 4}, {1, 2}, {3, 4} });//4
//	cout << endl;
//	cout << solution({ {-5, -3}, {-4, 0}, {-4, -2}, {-1, 2}, {0, 3}, {1, 5}, {2, 4} });//2
//	cout << endl;
//	cout << solution({ {0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15} });//8
//	cout << endl;
//	cout << solution({ {0, 12}, {1, 12}, {2, 12}, {3, 12}, {5, 6}, {6, 12}, {10, 12} });//2
//	cout << endl;
//	cout << solution({ {-191, -107}, { -184,-151 }, { -150,-102 }, { -171,-124 }, { -120,-114 } }); // 2
//	cout << endl;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
//		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}; // 2
		int[][] routes = {{0,2},{2,3},{3,4},{4,6}}; // 2
		int result = sol.solution(routes);
		System.out.println("result : " + result);
	}

	public static int start = -30001;
	public static int end = -30001;
	
	public int solution(int[][] routes) {
        int answer = 0;
        // 오름차순 정렬
//        print(routes);
        Arrays.sort(routes, (o1, o2) -> (o1[0] -o2[0]));
//        print(routes);
        int needCnt = 0;
        start = routes[0][0];
        end = routes[0][1];
        
        for(int i=1; i<routes.length;i++) {
        	if(end <= routes[i][0]) { // 첫번째 끝나는 지점과 두번째 시작지점이 겹치면
        		start = routes[i][0];
        		if(end != routes[i][1]) {
        			if(end > routes[i][1]) { // 첫번째 끝나는 지점 > 두번째 끝나는 지점
        				end = routes[i][1];
        			}
        		}
        		needCnt++;
        	}else {	// 안겹쳐서 cctv추가
        		needCnt++;
        		start = routes[i][0];
        		end = routes[i][1];
        	}
        }
        
        answer = needCnt;
        
        return answer;
    }
	
	public void print(int[][] routes) {
		System.out.println("print!!#@#");
		for(int i=0; i<routes.length;i++) {
			for(int j=0; j<routes[i].length;j++) {
				System.out.print(routes[i][j] + " ");
			}
			System.out.println("");
			
		}
	}
}
