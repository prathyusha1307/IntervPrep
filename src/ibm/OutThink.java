package ibm;

public class OutThink {

	public void print(int n, int a,int b){
		for(int i=0;i<n;i++){
			 if(i%(a*b)==0){
					System.out.println("OUTTHINK");
					}
			 else if(i%a==0){
				System.out.println("OUT");
			}
			else if(i%b==0){
				System.out.println("THINK");
			}else{
				System.out.println(i);
			}
		}
	}
	public static void main(String[] args) {
		OutThink o = new OutThink();
		o.print(15, 2, 3);
	}
}
