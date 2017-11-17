package Sorting;

public class BucketImpl {
	
	private int maximumGap(int[] num) {
		if(num.length==0 || num.length<2){
			return 0;
		}
		int min=num[0];
		int max=num[0];
		for(int i=0;i<num.length;i++){
			min=Math.min(min, num[i]);
			max=Math.max(max, num[i]);
		}
		
		Bucket[] buckets= new Bucket[num.length+1];
		for(int i=0;i<buckets.length;i++){
			buckets[i]= new Bucket();
		}
		double interval = (double) num.length / (max - min);
		for(int i=0;i<num.length;i++){		
			int index= (int) ((num[i]-min)*interval);
			if(buckets[index].low==-1){
				buckets[index].low=num[i];
				buckets[index].high=num[i];
			}else{
				buckets[i].low=Math.min(num[i], buckets[i].low);
				buckets[i].high=Math.max(num[i], buckets[i].high);
			}
		}
		int result=0;
		int prev=buckets[0].high;
		for(int i=1;i<buckets.length;i++){
			if(buckets[i].low!=-1){
				result=Math.max(result, buckets[i].low-prev);
				prev=buckets[i].high;
			}
		}
		return result;
	}
	 

	public static void main(String[] args) {
		BucketImpl b = new BucketImpl();
		int[] num = {1,2,3,8,9,11};
		System.out.println(b.maximumGap(num));
	}

	
}

class Bucket{
	int low;
	int high;
	Bucket(){
		low=-1;
		high=-1;
	}
}
