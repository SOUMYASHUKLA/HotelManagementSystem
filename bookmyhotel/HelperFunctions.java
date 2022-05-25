package bookmyhotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HelperFunctions {

	// helper function to check date format
	public boolean isValidFormat(String format, String value) {
	    Date date = null;
	    try {
	        SimpleDateFormat sdf = new SimpleDateFormat(format);
	        date = sdf.parse(value);
	        if (!value.equals(sdf.format(date))) {
	            date = null;
	        }
	    } catch (ParseException ex) {
	        ex.printStackTrace();
	    }
	    return date != null;
	}
	
	// Helper function to get No. of days given date range
	public int getDuration(Date checkin, Date checkout) {
		long diffInMillies = Math.abs(checkout.getTime() - checkin.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		int duration = (int)diff;
		
		return duration;
	}
	
	// Helper function to add x days to Date
	public Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	
}
