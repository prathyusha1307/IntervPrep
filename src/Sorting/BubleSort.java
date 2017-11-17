package Sorting;

public class BubleSort {

	public void sort(int[] a, int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
		for(int i:a){
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		BubleSort b = new BubleSort();
		int[] a ={3,1,9,4};
		b.sort(a, a.length-1);
	}
}
