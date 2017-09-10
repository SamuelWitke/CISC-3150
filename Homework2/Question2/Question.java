import java.util.*;
import java.text.DateFormatSymbols;
class Question {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Year");
		int year = in.nextInt();
		System.out.println("What day the first of January fell on ex, Su Mo Tu We Th Fr Sa");
		//Calendar cal = Calendar.getInstance();
		//cal.set(year,1,1);
	   	//cal.setFirstDayOfWeek(Calendar.MONDAY);
		//int startDay = cal.getFirstDayOfWeek()-1;
		int startDay=1;
		for(int i=1;i<=12;i++){
			String month = getMonth(i);	
			printMonthTitle(year,month);	
			int numDays = getMonthDays(i,year); 
			startDay = printMonthBody(startDay,numDays);
		}
		
	}
  	static void printMonthTitle(int year, String month) {
    	System.out.printf("         %s,%d",month,year);
    	System.out.println("-----------------------------");
    	System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
  	}
  	/** Print month body */
  	static int printMonthBody(int startDay, int numOfDaysInMonth) {
    	// Pad space before the first day of the month
    	int i = 0;
    	for (i = 0; i < startDay; i++)
      		System.out.print("    ");
    	for (i = 1; i <= numOfDaysInMonth; i++) {
      		if (i < 10)
        		System.out.printf("   %d",i);
      		else
        		System.out.printf("  %d",i);
      		if ((i + startDay) % 7 == 0)
        		System.out.println();
    	}
    	System.out.println();
    	return (i+startDay-1)%7 ;
  	}
  	static String getMonth(int month) {
    	return new DateFormatSymbols().getMonths()[month-1];
	} 

	static int getMonthDays(int month,int year){
		if (month == 4 || month == 6 || month == 9 || month == 11)
			return 30;
		else 
			if (month == 2) 
				return  (isLeapYear(year) ? 29 : 28);
		else 
			 return 31;
	}
	static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		} else {
			return false;
		}
    }
}

