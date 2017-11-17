package backTracking;

import java.util.Arrays;

public class NBitStrings {

	int[] arr;
	public  NBitStrings(int n){
		arr= new int[n];
	}
	public void findBits(int n){
		if(n<=0){
			System.out.println(Arrays.toString(arr));
		}else{
			arr[n-1]=0;
			findBits(n-1);
			arr[n-1]=1;
			findBits(n-1);
		}
	}
	
	public void generateStringLenN(int n, int k){
		if(n==0){
			System.out.println(Arrays.toString(arr));
		}else{
			for(int j=0;j<k;j++){
				arr[n-1]=j;
				generateStringLenN(n-1, k);
			}
		}
	}
	 public static void main(String[] args) {
		NBitStrings n1 = new NBitStrings(3);
		//n1.findBits(3);
		n1.generateStringLenN(3, 8);
	}
}
