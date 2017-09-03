import java.util.Scanner;
class Question{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Radius ");
		while(input.hasNext()){
			int r = input.nextInt();
			double area = Math.PI * Math.pow(r, 2);
			System.out.printf("Given the radius %d, the area is %f\n",r,area);
		}	
	}
}
