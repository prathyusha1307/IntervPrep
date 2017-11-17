package Sorting;

public class HeapSort {

	public void sort(int[] arr,int n){
		for(int i=n/2-1;i>=0;i--){
			heapify(arr,n,i);
		}
		for(int i=n-1;i>=0;i--){
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			heapify(arr,i,0);
		}
	}
	private void heapify(int[] arr, int n, int i) {
		int parent=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && arr[left]>arr[parent]){
			parent=left;
		}
		if(right<n && arr[right]>arr[parent]){
			parent=right;
		}
		if(parent!=i){
			int temp=arr[i];
			arr[i]=arr[parent];
			arr[parent]=temp;
			heapify(arr,n,parent);
		}
	}
	public static void main(String[] args) {
		int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;
 
        HeapSort ob = new HeapSort();
        ob.sort(arr,arr.length);
        for(int i:arr){
        	System.out.println(i);
        }
 
	}
}
