package br.com.fmchagas.loucademia.application.util;

public class StringUtils {

	public static boolean isEmpty(String s) {
		if (s == null) {
			return true;
		}
		
		return s.trim().length() == 0;
	}
	
	public static String leftZeroes(int value, int finalSize) {
		StringBuffer sb = new StringBuffer();
		sb.append("%0")
		.append(finalSize)
		.append("d");
		
		return String.format(sb.toString(), value);
	}
	
}
