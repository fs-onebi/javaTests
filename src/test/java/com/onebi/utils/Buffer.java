package com.onebi.utils;

import java.util.HashMap;
import java.util.Map;

public class Buffer {

	private static final ThreadLocal<Map<String, String>> buffer = new ThreadLocal<Map<String, String>>() {
		@Override
		protected Map<String, String> initialValue() {
			return new HashMap<String, String>();
		}
	};

	public static Map<String, String> get() {
		return buffer.get();
	}

	public static void initialize() {
	    
		get().clear();
	}

	public static void set(String key, String value) {
	    
		get().put(key, value);
	}

	public static String get(String key) {
		return get().get(key);
	}
	
	public static boolean containsKey(String key) {
		return get().containsKey(key);
	}
}
