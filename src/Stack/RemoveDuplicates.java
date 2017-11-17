package Stack;

public class RemoveDuplicates {

	public void removeDuplicates(int[] arr){
		int j=-1;
		int i=0;
		while(i<arr.length){
			if(j==-1 || arr[j]!=arr[i]){
				j++;
				arr[j]=arr[i];
				i++;
			}else{
				while(i<arr.length && arr[i]==arr[j]){
					i++;
					j--;
				}
			}
		}
		
		for(int k=0;k<j;k++){
			System.out.println(arr[k]);
		}
	}
	
	public static void main(String[] args) {
		RemoveDuplicates r = new RemoveDuplicates();
		int[] arr={1,2,2,3,4,4,4,5,6};
		r.removeDuplicates(arr);
	}
}
