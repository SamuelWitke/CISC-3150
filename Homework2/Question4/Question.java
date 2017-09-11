public class Question {
	public static void main(String [] args){
		int x= 4282;
		System.out.printf("x>>32 = %32s\n",Integer.toBinaryString((x>>>32)));
		System.out.printf("x>>0  = %32s\n",Integer.toBinaryString((x>>>0)));
		System.out.printf("x     = %32s\n",Integer.toBinaryString((x)));
		for(int i=0;i<35;i++){  
			System.out.printf("%d\t\t%32s\n",i,Integer.toBinaryString(x>>>i));  
		}  
		for(int i=0;i<35;i++){  
			System.out.printf("%d\t\t%32s\n",i,Integer.toBinaryString(x));  
			x = x >>> i;  
		}  
	}
}
