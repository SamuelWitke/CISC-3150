import java.util.*;
class Question {
	public static void main(String []args){
		Scanner in = new Scanner(System.in);
		in.useDelimiter("");
		while(in.hasNext()){
			try{
				char a = in.findInLine(".").charAt(0);
				System.out.println(a);
			}catch(NullPointerException e){break;}
		}
		in.close();
	}
}
