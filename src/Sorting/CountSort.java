package Sorting;

public class CountSort {

	public void sort(int[] nums){
		if(nums.length==0 || nums.length<2){
			return;
		}
		int[] countArray= new int[4];
		for(int i=0;i<nums.length;i++){
			countArray[nums[i]]++;
		}
		int j=0;
		int k=0;
		int[] arr= new int[nums.length+2];
		while(j<=3){
			if(countArray[j]!=0){
				arr[k++]=j;
				countArray[j]=countArray[j]-1;
			}else{
				j++;
			}
		}
		for(int l:arr){
			System.out.println(l);
		}
	}
	public static void main(String[] args) {
		CountSort c = new CountSort();
		int[] nums= {1,2,1,2,3,1};
		c.sort(nums);
	}
}
