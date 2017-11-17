package Stack;

import java.util.Stack;

public class FindPalindrome {

	public boolean isPalindrome(String str){
		char[] arr=str.toCharArray();
		boolean flag=true;
		Stack<Character> s = new Stack<Character>();
		int j=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]!='x'){
				s.push(arr[i]);
			}else{
				j=i+1;
				break;
			}
		}
			while(!s.isEmpty() && j<arr.length){
				if(s.pop()!=arr[j]){
					flag=false;
				}
				j++;
			}
		
		return flag;
	}
	public static void main(String[] args) {
		FindPalindrome f = new FindPalindrome();
		System.out.println(f.isPalindrome("abxba"));
	}
}
