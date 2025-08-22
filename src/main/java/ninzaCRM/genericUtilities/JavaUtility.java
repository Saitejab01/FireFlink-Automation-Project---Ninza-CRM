package ninzaCRM.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class will perform all java related operations
 * @author Bandi Saiteja
 */
public class JavaUtility {
	/**
	 * this method will give random numbers based on the int you provide
	 * @param uptonum
	 * @return
	 */
	public int getRandomNumber(int uptonum) {
		Random random = new Random();
		return random.nextInt(uptonum);
	}
	/**
	 * this method will generate the system date and returns it
	 * @return
	 */
	public String getStringDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		return sdf.format(d);
	}
	
}
