import java.lang.reflect.*;
import java.util.*;
import java.io.*;
import java.net.*;


public class Question {
	public static void main(String ...args) throws Throwable {
		File dir = new File("./plugins");
		List<File> files = new ArrayList<File>();
		List<String> names = new ArrayList<String>();
		System.out.println("Here is your list of plugins");
		int i=0;
		for(File file : dir.listFiles()) {
			if(!file.getName().contains("MyPlugin") && !file.getName().contains(".java")){
				String s = file.getName();
				s = s.substring(0, s.length() - 6);
				files.add(file);
				names.add(s);
				System.out.printf("%d: %s\n",i,s);
				i++;
			}
		}
		Scanner in = new Scanner(System.in);
		System.out.println("Select the number of the plugin to run");
		int choice = in.nextInt();
		Class<?> cls = null;
		Method myMethod = null;
		Object obj = null;
		Method m[] =  null;
		URL url = dir.toURI().toURL();
		URL[] classUrls = { url };
		URLClassLoader ucl = new URLClassLoader(classUrls);
		if( choice == 0){
        cls = ucl.loadClass(names.get(0)); 
				obj = cls.newInstance();
        m = cls.getDeclaredMethods();
		}else {
  		cls = ucl.loadClass(names.get(1)); 
			obj = cls.newInstance();
      m = cls.getDeclaredMethods();
		}
		for(int k=0;k<2;k++){
			myMethod = cls.getMethod(m[k].getName());
			myMethod.invoke(obj);
		}
	}
}
