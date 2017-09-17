import java.util.*;
class MyString {
	private char[] charArray;
	public MyString(char[] chars){
		charArray = new char[chars.length];
		for(int i=0;i<chars.length;i++) {
			this.charArray[i] = chars[i];
		}
	}
	public char charAt(int index){
		return charArray[index];
	}
	public int length(){
		return charArray.length;
	}
	public MyString substring(int begin, int end){
		char [] arr = new char[begin + end];
		if(end > this.charArray.length)
			throw new IndexOutOfBoundsException();
		for(int i=begin;i<end;i++){
			arr[i] = this.charArray[i];
		}
		return new MyString(arr);
		
	}
	 /*
	 * https://stackoverflow.com/questions/3696441/converting-a-char-to-uppercase
	 */	
	public MyString toLowerCase(){
		char [] arr = new char[(this.charArray.length)];
		for(int i=0;i<this.charArray.length;i++){
			arr[i] =(char) ((this.charArray[i] & 0x5f)^0x20);
		}
		return new MyString(arr);
	}
	public MyString toUpperCase(){
		char [] arr = new char[(this.charArray.length)];
		for(int i=0;i<this.charArray.length;i++){
			arr[i] = (char) (this.charArray[i] & 0x5f);
		}
		return new MyString(arr);
	}

	public boolean equals(MyString s){
		MyString mystring = s.getMyString();
		if(mystring.length() > this.charArray.length){
			return false;
		}
		for(int i=0;i<this.charArray.length;i++){
			if(mystring.charAt(i) !=  charArray[i])
				return false;
		}
		return true;
	}
	public MyString getMyString(){
		return new MyString(this.charArray);
	}
	public String toString(){
		String s = "";
		for(int i=0;i<this.charArray.length;i++)
			s+=charArray[i];
		return s;
	}
	public static MyString valueOf(int i){
		char[] temp = new char[1];
		temp[0]=(char) (i + '0');
		return new MyString(temp);
	}
}
public class Question {
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter String to test MyString");
		while(in.hasNext()){
			String s = in.next();
			MyString myS = new MyString(s.toCharArray());
			System.out.printf("charAt 0: %s\n",myS.charAt(0));
			System.out.printf("Length: %d\n",myS.length());
			System.out.printf("Substring: 1,5 %s\n",myS.substring(1,5));
			System.out.printf("Lowercase: %s\n",myS.toLowerCase());
			System.out.printf("Uppercase: %s\n",myS.toUpperCase());
			System.out.printf("Equals: cool %b\n",myS.equals(new MyString("cool".toCharArray())));
			System.out.printf("Equals: clone of itself %b\n",myS.equals(myS.getMyString()));
			System.out.println(myS);
			System.out.printf("Value of 1: %s\n",myS.valueOf(1));
		}
	}
}
