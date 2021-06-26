package kNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class maxNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxNumber sol = new maxNumber();
		int[] array  = {3, 30, 34, 5, 9};
//		int[] array  = {3, 30, 34};
		String result = sol.solution(array);
		System.out.println("reult : " + result);
//		System.out.println("max : " + max);
	}
	
	public String solution(int[] numbers) {
        String answer = "";

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return (o2 + 01).compareTo(o1+ o2); 
			}
		});
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				// 양수인 경우 두 객체의 자리가 변경 (음수 또는 0이면 자리가 유지)
//				// 기준값.compareTo 비교값일때  기준값 > 비교값이면 양수 리턴
//				// {30 3}이 있을때 330 > 303 이므로 {3 30}으로 변경 
//				return (o2 + 01).compareTo(o1+ o2); 
//			}
        Collections.sort(list, (a, b) -> {
        	// Integer를 string으로 변환하고
            String as = String.valueOf(a), bs = String.valueOf(b);
            // "330" "303"을 각각 int로 바꿔서 비교하고 
            return -Integer.compare(Integer.parseInt(as + bs), Integer.parseInt(bs + as));
        });
        StringBuilder sb = new StringBuilder();
        for(Integer i : list) {
            sb.append(i);
        }
        answer = sb.toString();
        if(answer.charAt(0) == '0') {
            return "0";
        }else {
            return answer;
        }
    }


//	public String solution(int[] numbers) {
//		String answer = "";
//
//		// 0 만 있는경우 0 리턴
//		String[] newNumber = new String[numbers.length];
//		for(int i = 0 ; i< newNumber.length; i++){
//			newNumber[i] = String.valueOf(numbers[i]);
//		}
//		Arrays.sort(newNumber, new Comparator<String>(){
//			@Override
//			public int compare(String o1, String o2) {
//				// TODO Auto-generated method stub
//				// 양수인 경우 두 객체의 자리가 변경 (음수 또는 0이면 자리가 유지)
//				// 기준값.compareTo 비교값일때  기준값 > 비교값이면 양수 리턴
//				// {30 3}이 있을때 330 > 303 이므로 {3 30}으로 변경 
//				return (o2 + 01).compareTo(o1+ o2); 
//			}
//		});
//		
//		System.out.println("arrya sort result : " + Arrays.toString(newNumber));
//		if(newNumber[0].equals("0")){
//			return "0";
//		}
//		
//
//		StringBuffer sb2 = new StringBuffer();
//        for(String next : newNumber){
//            sb2.append(next);
//        }
//        answer = sb2.toString();
//        
//        boolean[] visited = new boolean[newNumber.length];
//        String[] temp = new String[newNumber.length];
//		makePermut(newNumber.length, temp, 0, visited, newNumber);
//		answer = max;
//		return answer;
//	}

}
