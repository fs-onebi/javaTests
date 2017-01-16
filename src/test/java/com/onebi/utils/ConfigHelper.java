package com.onebi.utils;

import static java.lang.System.getProperty;

public class ConfigHelper {
	
	public static String getProjectLocation() {
	    
	    return getProperty("user.dir");
	}
	
	public static String glueString(String... parts) {
		
		StringBuilder sb = new StringBuilder();
		
		for(String part : parts){
		    
		    sb.append(part);
		}
		
		return sb.toString();
	}
}
