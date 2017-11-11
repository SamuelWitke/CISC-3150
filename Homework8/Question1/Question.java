import java.util.*;
import java.io.*;
class Question {
	public static void main(String ... args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Path aka /home/user/CISC-3150");
		File root = new File(in.next());
		StringBuffer str = new StringBuffer();
		printDir(str,0,root);
		System.out.println(str);
	}
	public static void printDir(StringBuffer str,int lvl,File dir) {
		if(!dir.isDirectory()) {
			return;
		}
		str.append(addTheBarThings(lvl));
		str.append("---");
		str.append(dir.getName());
		str.append("\n");
		for(File file : dir.listFiles()) {
			if(file.isDirectory()) {
				String s = file.getName();	
				if(!s.contains(".")) {
					printDir(str,lvl+1,file);
				}
			}else
				printFile(str,lvl+1,file);
		}
	}
	public static String addTheBarThings(int amt) {
		StringBuffer str = new StringBuffer();
		for(int i=0;i<amt;i++) {
			str.append("| ");
		}
		return str.toString();
	}
	public static void printFile(StringBuffer str,int lvl,File file){
		str.append(addTheBarThings(lvl));
		str.append("---");
		str.append(file.getName());
		str.append("\n");
	}
}
