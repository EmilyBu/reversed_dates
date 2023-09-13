import java.time.LocalDate;                                                   //library for date format and date calculations
import java.time.Month;                                                       //library for month
import java.time.temporal.ChronoUnit;                                         //library for date calculations and arithmetics 

public class Datos {                                                           //class Datos created
	
	public static void printBonusDatesBetween(int fromYear, int toYear){       //method to check all dates fromYear x toYear y and print only reversed dates that match 
		System.out.println("Output of reversed dates:");                       //prints text "Output of reversed dates:"

        LocalDate startDate = LocalDate.of(fromYear, Month.JANUARY, 1);        //LocalDate - build in JAVA class from the library; object startDate is created, it contains arguments and a date to start with
        LocalDate endDate = LocalDate.of(toYear, Month.DECEMBER, 31);          //method endDate is created, it holds a date to end calculations with

        while (!startDate.isAfter(endDate)) {                                  //while the start date is not the same as the end date, the function goes in a cycle
            if (isReversedDate(startDate)) {                                   //startDate is sent to isReversedDate method, method is called to execute 
                System.out.println(startDate);                                 //date is printed if it matches if condition above
            }
            startDate = startDate.plus(1, ChronoUnit.DAYS);                    //ads 1 day to startDate to proceed the while function in a cycle
        }
	}
	
    public static void main(String[] args) {                                   //main method
		printBonusDatesBetween(2010, 2015);                                    //printBonusDatesBetween() method is called 
    }

    public static boolean isReversedDate(LocalDate date) {                    //method returns boolean value true if date is same when reversed and false if not
        String dateStr = date.toString().replace("-", "");                    //variable dateStr is created which transforms object date to a string, to do so hyphens should be removed 
        String reversedDateStr = new StringBuilder(dateStr).reverse().toString(); //variable reversedDateStr is created which holds an object StringBuilder that uses reverse method to reverse dateStr and reverse it back to a string
        return dateStr.equals(reversedDateStr);                                //dateStr is compared to reversedDateStr, if both are equal, method returs true
    }
}
