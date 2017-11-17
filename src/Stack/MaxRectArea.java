package Stack;

import java.util.Stack;

public class MaxRectArea {

	int maxarea=0;
	int rectarea=0;
	int top=0;
	Stack<Integer> s = new Stack<Integer>();
	
	public void findRectArea(int[] arr){
		int i=0;
		for(;i<arr.length;){
			if(s.isEmpty() ||  arr[s.peek()]<=arr[i]){
				s.push(i++);
			}else{
				top=s.peek();
				s.pop();				
					rectarea=s.isEmpty()?arr[top]*i:arr[top]*(i-s.peek()-1);
				if(maxarea<rectarea){
					maxarea=rectarea;
				}
			}
		}
		while(!s.isEmpty()){
			top=s.peek();
			s.pop();
			rectarea=s.isEmpty()?arr[top]*i:arr[top]*(i-s.peek()-1);
			if(maxarea<rectarea){
				maxarea=rectarea;
			}
		}
		System.out.println(maxarea);
		
	}
	public static void main(String[] args) {
		MaxRectArea m = new MaxRectArea();
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };
		m.findRectArea(hist);;
	}
}
