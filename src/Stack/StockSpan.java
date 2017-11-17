package Stack;

import java.util.Stack;

public class StockSpan {

	Stack<Integer> s= new Stack<Integer>();
	
	public void findSpan(int[] arr, int[] span){
		s.push(0);
		span[0]=1;
		for(int i=1;i<arr.length;i++){
			while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
				s.pop();
			}
			span[i]=(s.isEmpty())?(i+1):(i-s.peek());
			s.push(i);
		}
	}
	public void print(int[] span){
		for(int i:span){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		StockSpan s = new StockSpan();
		 int price[] = {10, 4, 5, 90, 120, 80};
	        int n = price.length;
	        int S[]=new int[n];
	        s.findSpan(price, S);
	        s.print(S);
	}
}
