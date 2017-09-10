import java.util.*;
import java.text.DateFormatSymbols;
class Question {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Year");
		int year = in.nextInt();
		System.out.println("What day the first of January fell on ex, Su Mo Tu We Th Fr Sa");
		String dayBuff = in.next();
		Map<String,Integer> numToDays = new HashMap<String,Integer>();
		numToDays.put("Su",0);
		numToDays.put("Mo",1);
		numToDays.put("Tu",2);
		numToDays.put("We",3);
		numToDays.put("Th",4);
		numToDays.put("Fr",5);
		int startDay = numToDays.get(dayBuff);	
		for(int i=1;i<=12;i++){
			String month = getMonth(i);	
			printMonthTitle(year,month);	
			int numDays = getMonthDays(i,year); 
			startDay = printMonthBody(startDay,numDays);
		}
		
	}

  	static void printMonthTitle(int year, String month) {
    	System.out.printf( "|%23s,%d|\n",month,year);
    	System.out.println("|----------------------------|");
    	System.out.println("| Sun Mon Tue Wed Thu Fri Sat|");
  	}

  	static int printMonthBody(int startDay, int numOfDaysInMonth) {
    	int i = 0;
    	for (i = 0; i < startDay; i++){
      		System.out.print("   ");
		}
    	for (i = 1; i <= numOfDaysInMonth; i++) {
      		if (i < 10){
        		System.out.printf("   %d",i);
			}
      		else{
        		System.out.printf("  %d",i);
			}
      		if ((i + startDay) % 7 == 0){
        		System.out.printf(" |\n");
			}
    	}
    	System.out.println();
    	return (i+startDay-1)%7 ;
  	}

  	static String getMonth(int month) {
    	return new DateFormatSymbols().getMonths()[month-1];
	} 

	static int getMonthDays(int month,int year){
		if (month == 4 || month == 6 || month == 9 || month == 11){
			return 30;
		}
		else {
			if (month == 2) {
				return  (isLeapYear(year) ? 29 : 28);
			} else {
				return 31;
			}
		}
	}

	static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		} else {
			return false;
		}
    }
}

