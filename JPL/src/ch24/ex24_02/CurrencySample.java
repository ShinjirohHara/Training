package ch24.ex24_02;

import java.util.Currency;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

public class CurrencySample {
	private static Set<Locale> locs = new HashSet<Locale>();
	static {
		locs.add(Locale.CANADA);
		locs.add(Locale.CHINA);
		locs.add(Locale.US);
		locs.add(Locale.JAPAN);
		locs.add(Locale.GERMANY);
		locs.add(Locale.ITALY);
		
		
	}
	public static void main (String[] args) {
		for (Iterator<Locale> locIte = locs.iterator(); locIte.hasNext();) {
			Locale loc = locIte.next();
			for (Iterator<Locale> locIte2 = locs.iterator(); locIte2.hasNext();) {
				Locale loc2 = locIte2.next();
				Currency currency = Currency.getInstance(loc);
				System.out.println("Currency:"+currency+", DisplayLocale:"+loc2+", Display:"+currency.getSymbol(loc2));
			}
		}
		
	}

}
