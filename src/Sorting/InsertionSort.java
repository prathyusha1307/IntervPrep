package Sorting;

public class InsertionSort {

	public void insertionSort(int[] a){
		int n=a.length;
		for(int i=1;i<n;i++){
			int key=a[i];
			int j=i-1;
			while(j>=0 && a[j]>key){
				a[j+1]=a[j];
				j=j-1;
			}
			a[j+1]=key;
		}
		
	}
	public static void main(String[] args) {
		InsertionSort i = new InsertionSort();
		int[] a = {4,3,2,5,8,6};
		i.insertionSort(a);
		for(int k:a){
			System.out.println(k);
		}
	}
}
