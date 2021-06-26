package test2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	enroll	referral	seller	amount	result
	//	["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	
//		["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	["young", "john", "tod", "emily", "mary"]	
//		[12, 4, 2, 5, 10]	[360, 958, 108, 0, 450, 18, 180, 1080]
		
	//	["john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"]	
//		["-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"]	
//		["sam", "emily", "jaimie", "edward"]	
//		[2, 3, 5, 4]	[0, 110, 378, 180, 270, 450, 0, 0]
//		Solution sol = new Solution();
		
		String[] enroll= {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		// ��õ��
		String[] referral= {"-" , "-"	, "mary"  , "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller= {"young", "john", "tod", "emily", "mary"};
		int[] amount= {12	, 			4, 		2, 		5, 	10};
		// [360, 958, 108, 0, 450, 18, 180, 1080]
		int[] result = sol.solution(enroll, referral, seller, amount);
		
		sol.setLog(result);
	}

	// ������� enroll�� ��ϵ� ������ ������
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        boolean[] enroBol = new boolean[enroll.length];
        String[] newbieSeller = new String[enroll.length];
        // 4,  10, 0, 0, 5, 0, 2, 12
        int[] newbiewAmount = new int[enroll.length];
        
        
        // �Ǹſ��� �̸��� �ݾ��� enroll �������� ���� -> ��� ���̼�
        for(int i = 0 ; i< enroll.length; i++){
        	for(int j = 0; j<seller.length; j++){
        		if(enroll[i].equals(seller[j])){
        			newbieSeller[i] = seller[j];
        			newbiewAmount[i] = amount[j];
        			enroBol[i] = true;
        			break;
        		}
        	}
        	if(!enroBol[i]){
        		newbieSeller[i] = "-";
        		newbiewAmount[i] = 0;
        	}
        }
        
        System.out.println("�Ǹſ� ����");
        setLog(newbieSeller);
        System.out.println("�Ǹſ� �ݾ� ����");
        setLog(newbiewAmount);
       
        int nextIndx = -1;
        int nextAmount = -1;
        for(int i = 0 ; i< seller.length; i++){
        	
        	// -----------------------------  while�� �ȿ� �����ҵ� ---------------
        	// ��õ�� �ε����� ����
        	nextIndx = getEnrollIndx(enroll, seller[i]);
        	if(nextIndx == -1){
        		System.out.println("eroor!!!!!!!!");
        		break;
        	}
        	System.out.println("next idx : " + nextIndx);
        	nextAmount = amount[i];

        	int curOwner = 0;
        	int fakeOwner = 0;
        	while(nextAmount * 0.1 < 1 ){
        		// �������� �޾ƾ� �� ��
        		curOwner = nextAmount - (int)Math.ceil(nextAmount * 0.1 );
        		fakeOwner = (int)Math.ceil(nextAmount * 0.1 );
        		
        		newbiewAmount[getEnrollIndx(enroll, seller[i])] = curOwner;
        		newbiewAmount[nextIndx] = fakeOwner;
        		
        		nextIndx = getEnrollIndx(enroll, enroll[i]);
        		if(nextIndx == -1){
        			break;
        		}
        		nextAmount = fakeOwner;
        		
        	}
        	// -----------------------------  while�� �ȿ� �����ҵ� ---------------
        }

        answer = newbiewAmount;
        return answer;
    }
	
	public int getEnrollIndx(String[] enroll, String findIndx){
		for(int i = 0 ;i < enroll.length; i++){
			if(enroll[i].equals(findIndx)){
				return i;
			}
		}
		return -1;
	}
	
	public void setLog(String[] name){
		for(String i : name){
			System.out.println(i + ",");
		}
	}
	public void setLog(int[] amount){
		for(int i : amount){
			System.out.println(i + ",");
		}
	}
}
