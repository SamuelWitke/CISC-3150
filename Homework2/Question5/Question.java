import java.util.*;
class Question {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		in.useDelimiter(",");
		while(in.hasNextLine()){
			System.out.printf("%s\n",in.next());
		}
		in.close();
	}
}
