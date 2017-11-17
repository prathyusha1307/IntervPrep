package BinaryHeap;

public class BinaryHeapImpl {

	int[] array;
	int capacity;
	int heap_type;
	int count;
	
	public BinaryHeapImpl(int capacity) {
		this.capacity=capacity;
		this.array= new int[capacity];
		this.count=0;
	}
	
	public int parent(int i){
		if(i<=0 || i>=this.count){
			return -1;
		}
		return (i-1)/2;
	}
	
	public int leftChild(int i){
		int left=2*i+1;
		if(left>this.count){
			return -1;
		}
		return left;
	}
	
	public int rightChild(int i){
		int right=2*i+2;
		if(right>=this.count){
			return -1;
		}
		return right;
	}
	
	public void heapifyDown(int i){
		int left=leftChild(i);
		int right=rightChild(i);
		int max=i;
		if(left!=-1 && array[left]>array[i]){
			max=left;
		}
		if(right!=-1 && array[right]>array[i]){
			max=right;
		}
		if(max!=i){
			int t=array[i];
			array[i]=array[max];
			array[max]=t;
		}
		heapifyDown(max);
	}
	
	public int deleteMax(){
		if(count==0){
			return -1;
		}
		int temp=array[0];
		array[0]=array[count-1];
		count--;
		heapifyDown(0);
		return temp;
	}
	
	public void sort(int[] a){
		int n=a.length;
		for(int i=n/2-1;i>=0;i--){
			heapify(a,n,i);
		}
		// One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
 
            // call max heapify on the reduced heap
            heapify(a,i,0);
        }
	}
	
	private void heapify(int[] a, int n, int i) {
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		if(left<n && a[left]>a[i]){
			largest=left;
		}
		
		if(right<n && a[right]>a[i]){
			largest=right;
		}
		
		if(largest!=i){
			int temp=a[i];
			a[i]=a[largest];
			a[largest]=temp;
			heapify(a, n, largest);
		}
	}

	static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
	public static void main(String[] args) {
		  int arr[] = {12, 11, 13, 5, 6, 7};
	        int n = arr.length;
	 
	        BinaryHeapImpl ob = new BinaryHeapImpl(6);
	        ob.sort(arr);
	        ob.printArray(arr);
	 
	}
}
