package name.liuxun1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalTime {

	private static final ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue(){
			return new SimpleDateFormat("YYYY_MM_DD");
		}
	};
	public static Date getSimpleDateFormat(String source) throws ParseException{
		return tl.get().parse(source);
	}
}
