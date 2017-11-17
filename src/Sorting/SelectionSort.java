package Sorting;

public class SelectionSort {

	public void sort(int[] a, int n){
		int index=0;
		for(int i=0;i<n;i++){
			index=i;
			for(int j=i+1;j<n;j++){
				if(a[index]>a[j]){
					index=j;
				}
			}
			int temp=a[index];
			a[index]=a[i];
			a[i]=temp;
		}
		for(int i:a){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		SelectionSort b = new SelectionSort();
		int[] a ={3,1,9,4};
		b.sort(a, a.length-1);
	}
}
