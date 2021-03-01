package com.mhr.diary.date;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;

public class PersianDateTime {

	public String webTime() {
		ULocale locale = new ULocale("fa_IR@calendar=persian");
		Calendar calendar = Calendar.getInstance(locale);
		DateFormat dc = DateFormat.getTimeInstance(DateFormat.MEDIUM,locale);	

		return dc.format(calendar);
	}
	
	public String webDate() {
		ULocale locale = new ULocale("fa_IR@calendar=persian");
		Calendar calendar = Calendar.getInstance(locale);
		DateFormat df = DateFormat.getDateInstance(DateFormat.ERA_FIELD , locale);	

		return df.format(calendar);
	}
}
