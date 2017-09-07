import java.util.*;
class Question {
	public static boolean isPalindrome(String str){
		int left = 0;
		int right = str.length() -1;
		while(right > left){
			if(str.charAt(left++) != str.charAt(right--)){
				return false;
			}
		}
		return true;
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter String eg, madamimadam");
		String s = in.next();
		System.out.printf(isPalindrome(s.toLowerCase()) ? 
		"String %s is a Palindrome\n" : "String %s is not a Palindrome\n",s);
	}
}
