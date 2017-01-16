package com.onebi.utils;

import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Robot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BackgroundSteps {

	@Before
	public void before() {

		WebDriverProvider.initialize();
		
		try {
			new Robot().mouseMove(
			      0,
			      (int)GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getHeight() + 100
			    );
		} catch (HeadlessException | AWTException e) {
		    
			System.out.println("exception when moving mouse pointer out of browser window");
			e.printStackTrace();
		}
	}
	
	@After
	public void after(Scenario scenario) {
	    
		WebDriverProvider.quit();
		System.out.print(scenario.getName());
	}
}
