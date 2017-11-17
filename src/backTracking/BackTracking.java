package backTracking;

public class BackTracking {
	
	public int sort(int[] a,int index){
		if(index==0){
			return 1;
		}
		else{
			return a[index]<a[index-1]?0:sort(a,index-1);
		}
	}
	
	
	public void towerOfHanoi(int shift, String  start, String aux, String destination){
		if (shift == 1)
        {
            return;
        }
		towerOfHanoi(shift - 1, start, destination, aux);
        System.out.println("Move \"" + shift + "\" from " + start + " --> " + destination);
        towerOfHanoi(shift - 1, aux, start, destination);
	}

	public static void main(String[] args) {
		BackTracking b = new BackTracking();
		int[] a ={3,2,4,5,6};
		System.out.println(b.sort(a, a.length-1));
	}
}
