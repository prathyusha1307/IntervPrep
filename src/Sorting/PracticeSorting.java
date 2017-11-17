package Sorting;

public class PracticeSorting {

	public void sort(int[] arr){
		int n=arr.length;
		for(int i=1;i<n;i++){
			int j=i-1;
			int key=arr[i];
			while(j>=0 && key<arr[j]){
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
				
		}
	}
	private void merge(int[] arr, int l, int m,int r) {
		int n1=	m-l+1;
		int n2=r-m;
		int[] L= new int[n1];
		int[] R= new int[n2];
		for(int i=0;i<n1;i++){
			L[i]=arr[l+i];
		}
		
		for(int j=0;j<n2;j++){
			R[j]=arr[m+1+j];
		}
		
		int i=0;
		int j=0;
		int k=l;
		while(i<n1 && j<n2){
			if(L[i]<=R[j]){
				arr[k]=L[i];
				i++;
			}else{
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1){
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2){
			arr[k]=R[j];
			j++;
			k++;
		}
		
	}
	public static void main(String[] args) {
		PracticeSorting p = new PracticeSorting();
		int[] arr= {2,1,3,5,4,6,9,8};
		p.sort(arr);
		for(int k:arr){
			System.out.println(k);
		}
	}
}
