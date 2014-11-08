package classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//used in HttpBasicAuth to generate the current date for use in fileName
//returns a String Array with 3 fields: year, month, day
public class DateGenerator { 

	public String[] generateDate(){
		
		DateFormat dateFormat_year = new SimpleDateFormat("yyyy");
	    DateFormat dateFormat_month = new SimpleDateFormat("MM");
	    DateFormat dateFormat_day = new SimpleDateFormat("dd");
	    
	    Date date = new Date();
	    String[] dateArray = {"0000","00","00"};
	  
	    dateArray[0] = dateFormat_year.format(date);
	    dateArray[1] = dateFormat_month.format(date);
	    dateArray[2] = dateFormat_day.format(date);
	    
	    return dateArray;
	}
    
}
