package com.redefine.util;

public class Util {

	public static boolean isNull(Object object) {
		return object == null;
	}
	
	public static boolean isNullOrEmpty(String string) {
		return (string == null || string.trim().length() == 0);
	}
	
	public static boolean hasValue(Object object) {
		return object != null;
	}
	
	public static boolean hasValue(String string) {
		return (string != null && string.length() > 0);
	}
}
