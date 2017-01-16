package com.onebi.utils;

import java.util.HashMap;
import java.util.Map;

import com.onebi.pages.*;

public class PageFactory {

	private static final Map<String, Page> pages = new HashMap<>();
	
	@SuppressWarnings("unchecked")
	private static <T extends Page> T getPage(Class<T> tClass) {
	    
		Page page = pages.get(tClass.getName());
		if (page == null) {
			try {

			    page = tClass.newInstance();
			    pages.put(tClass.getName(), page);
				
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		page.waitForPage();

		return (T) page;
	}
	
	public static Page getRequiredPage(String pageName) {
	
		switch (pageName) {
	    case "Strona glowna":  return getPage(MainPage.class);
	    case "Meteor Onebi":  return getPage(MeteorOnebiPage.class);
	    case "Partnerzy Meteora":  return getPage(MeteorPartners.class);	 
	    case "Upwork":  return getPage(UpworkMainPage.class);
	    default: return null;
	    
		}
		
	}
}
