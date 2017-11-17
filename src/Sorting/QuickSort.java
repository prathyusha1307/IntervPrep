package Sorting;

public class QuickSort {

	public void sort(int[] arr, int l, int r){
		if(l<r){
			int p= partition(arr, l, r);
			sort(arr,l,p-1);
			sort(arr,p+1,r);
		}
	}
	
	
 
 
	
	private int partition(int[] arr, int low, int high) {
		int i=low-1;
		int pivot=arr[high];
		for(int j=low;j<high;j++){
			if(pivot>arr[j]){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		return i+1;
	}





	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		int[] arr= {2,1,3,5,4,6,9,8};
		q.sort(arr, 0, arr.length-1);
		for(int k:arr){
			System.out.println(k);
		}
	}
}
