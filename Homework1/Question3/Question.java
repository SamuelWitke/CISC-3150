import java.text.DateFormatSymbols;
class Question{
	public static void main(String[] args){
		int range = (12 - 1) + 1;     
   		int monthDate = (int)(Math.random() * range) + 1;//https://stackoverflow.com/questions/7961788/math-random-explained	
		String monthString = new DateFormatSymbols().getMonths()[monthDate-1]; // https://stackoverflow.com/questions/5799140/java-get-month-string-from-integer
		System.out.println(monthString);
	}
}
