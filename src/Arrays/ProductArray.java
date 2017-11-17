package Arrays;

public class ProductArray {

	public void product(int[] arr){
		int n=arr.length;
		int[] left= new int[n];
		int[] right= new int[n];
		int[] product= new int[n];
		
		left[0]=1;
		right[n-1]=1;
		for(int i=1;i<n;i++){
			left[i]=left[i-1]*arr[i-1];
		}
		
		for(int j=n-2;j>=0;j--){
			right[j]=right[j+1]*arr[j+1];
		}
		
		for(int i=0;i<n;i++){
			product[i]=left[i]*right[i];
			System.out.println(product[i]);
		}
	}
	public static void main(String[] args) {
		ProductArray p = new  ProductArray();
		int arr[] = {10, 3, 5, 6, 2};

		p.product(arr);
	}
}
