package BinaryHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFormDataStream {

	PriorityQueue<Integer> minheap= new PriorityQueue<Integer>();
	PriorityQueue<Integer> maxheap= new PriorityQueue<Integer>(Collections.reverseOrder());
	
	public void findMedian(int[] arr){
		for(int i:arr){
			addNum(i);
		}
	}
	private void addNum(int num) {
		maxheap.add(num);
		minheap.add(maxheap.poll());
		if(maxheap.size()<minheap.size()){
			maxheap.add(minheap.poll());
		}
	}
	
	public int findMedian(){
		if(maxheap.size()==minheap.size()){
			return (maxheap.poll()+minheap.poll())/2;
		}else{
			return maxheap.poll();
		}
	}
	public static void main(String[] args) {
		FindMedianFormDataStream f = new FindMedianFormDataStream();
		int[] arr={8,1,3,2,5};
		f.findMedian(arr);
		System.out.println(f.findMedian());
	}
}
