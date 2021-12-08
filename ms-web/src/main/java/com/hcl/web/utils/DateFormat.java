/**
 * 
 */
package com.hcl.web.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author SANTOSH
 *
 */
public class DateFormat {
	public static void main(String arg[]) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = formatter.format(new Date());
		System.out.println("dsd"+s);
	}
	public static String convertDateToString(String val){
		Format formatter = new SimpleDateFormat(val);
	    return formatter.format(new Date());
	}
	

}
