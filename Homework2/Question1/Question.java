import java.util.*;
class Question {
	public static void main(String []args) {
		int n;
        Scanner s=new Scanner(System.in);
		System.out.println("Enter Number");
        n=s.nextInt();
		int j;
		for(int i=1;i<=n;i++) {
			j=1;
			while(j<=(n-i)){
				System.out.print("  ");
				j++;
			}
			j=1;
			while(j<i+1){
				System.out.printf("%d ",j);	
				j++;
			}
			j=i-1;
			while(j >= 1){
				System.out.printf("%d ",j);
				j--;
			}
			System.out.println("");
		}
	}
}
