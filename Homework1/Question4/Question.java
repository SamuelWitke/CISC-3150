import java.util.Scanner;
import java.io.*;
class Question {
	public static void main(String [] args) {
		Scanner input;
		try{	
			input = new Scanner(new File(args[0]));
			while(input.hasNext()){
				double buff = input.nextDouble();
				System.out.printf("%.2f\n",buff);
			}
			input.close();
		}catch(IOException ex) {
			System.out.println("IOException ");
			ex.printStackTrace();
		}catch(ArrayIndexOutOfBoundsException ex){
			System.out.println("Run Program With The File Name");
		}
	}
}
