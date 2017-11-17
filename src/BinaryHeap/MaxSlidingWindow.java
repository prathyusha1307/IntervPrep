package BinaryHeap;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

	public void maxslide(int[] arr, int k){
		Deque<Integer> queue= new LinkedList<Integer>();
		int i=0;
		for(;i<k;i++){
			while(!queue.isEmpty() && arr[i]>arr[queue.peekLast()]){
				queue.pollLast();
			}
			queue.addLast(i);
		}
	for(;i<arr.length;i++){
		System.out.println(arr[queue.peek()]);
		while(!queue.isEmpty() && queue.peek()<=i-k){
			queue.removeFirst();
		}
		while(!queue.isEmpty() && arr[i]>arr[queue.peekLast()]){
			queue.pollLast();
		}
		queue.addLast(i);
	}
	System.out.println(arr[queue.peekFirst()]);
	}
	public static void main(String[] args) {
		int arr[]={12, 1, 78, 90, 57, 89, 56};
        int k=3;
        MaxSlidingWindow m = new MaxSlidingWindow();
        m.maxslide(arr,k);
	}
}
