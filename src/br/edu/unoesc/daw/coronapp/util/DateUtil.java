/*
 * FormatUtils.java
 *
 * Created on 20 de Março de 2008, 19:41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package br.edu.unoesc.daw.coronapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author robers
 */
public class DateUtil {

	private static final String formatoDataUsuario = "dd/mm/yyyy";
	private static final String formatoDataJdbc = "yyyy-mm-dd";

	public static String formataDataJdbc(String data) {
		SimpleDateFormat f = new SimpleDateFormat(formatoDataUsuario);
		Date d1 = null;
		try {
			d1 = f.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SimpleDateFormat format = new SimpleDateFormat(formatoDataJdbc);

		data = format.format(d1);

		return data;
	}

	public static String formataDataUsuario(String data) {
		SimpleDateFormat f = new SimpleDateFormat(formatoDataJdbc);
		Date d1 = null;
		try {
			d1 = f.parse(data);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SimpleDateFormat format = new SimpleDateFormat(formatoDataUsuario);

		data = format.format(d1);

		return data;
	}
	
	public static Date converteStringToDate(String data) {
		try {
			return new SimpleDateFormat(formatoDataJdbc).parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}