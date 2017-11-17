package Arrays;

public class UnionArrays {

	public void union(int[] arr1, int[] arr2){
		int m=arr1.length;
		int n=arr2.length;
		int x=m+n+1;
		int[] arr= new int[x];
		int i=0;
		int j=0;
		int k=0;


		while(i<arr1.length && j<arr2.length){
			if(arr1[i]<arr2[j]){
				arr[k]=arr1[i];
				k++;
				i++;
			}
			else if(arr1[i]==arr2[j]){
				arr[k]=arr1[i];
				i++;
				j++;
				k++;
			}else{
				arr[k]=arr2[j];
				k++;
				j++;
			}

		}

		while(i<arr1.length ){
			arr[k]=arr1[i];
			k++;
			i++;
		}

		while(j<arr2.length ){
			arr[k]=arr2[j];
			k++;
			j++;
		}

		for(int p:arr){
			System.out.println(p);
		}
	}
	
	public void findIntersection(int[] arr1, int[] arr2){
		int i=0;
		int j=0;
		while(i<arr1.length && j<arr2.length){
			if(arr1[i]<arr2[j]){
				i++;
			}
			else if(arr2[j]<arr1[i]){
				j++;
			}else{
				System.out.println(arr1[i]);
				i++;
				j++;
			}
		}
		
	
	}
	
	public static void main(String[] args) {
		UnionArrays u = new UnionArrays();
		int[] a= {1,2,3,4,7,8};
		int[] b= {4,5,6,7,8,9};
		//u.union(a, b);
		u.findIntersection(a, b);
	}
	
}
