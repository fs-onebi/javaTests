package com.onebi.utils;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.openqa.selenium.By.xpath;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.onebi.utils.ConfigHelper.glueString;
public class Page {

	public void waitForPage() {
		
		final String SCRIPT_WAIT_FOR_AJAX = 
				"if(window.hasOwnProperty('jQuery')) {" +
				"  return window.jQuery.active == 0;" +
				"} else {" +
				"  return true;" +
				"}";
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new WebDriverWait(WebDriverProvider.get(), 120).until(
				new ExpectedCondition<Boolean>() {
					@Override
					public Boolean apply(WebDriver driver) {
						return (Boolean)((JavascriptExecutor)driver).executeScript(SCRIPT_WAIT_FOR_AJAX);
					}
				}
			);
	}
	
	/**
	 * Stores current page fields.
	 */
	protected Map<String, Field> fields = new HashMap<>();
	
	public void addField(Storable fieldName, Field field) {
	    
		if(fields.containsKey(fieldName.toString()))
			throw new RuntimeException("Field with a given name already exists on the page: " + fieldName);
		
		fields.put(fieldName.toString(), field);
	}
	
	public Field getField(String fieldName) {
	    
		Field field = this.fields.get(fieldName);
		
		if(field == null)
			throw new RuntimeException("field " + fieldName + " not defined");
		
		return field;
	}
	
	protected void switchToFrames(String... frames) {
	    
		WebDriver driver = WebDriverProvider.get();
		
		driver.switchTo().defaultContent();
		
		for(String frame : frames)
			driver.switchTo().frame(frame);
	}
	
	public void click(String fieldName) {
	    
		Field field = getField(fieldName);
		
		switchToFrames(field.getFrames());
		WebElement weField = WebDriverProvider.get().findElement(field.getLocator());
		weField.click();
		
		waitForPage();
	}
	
	public void setFieldValue(String fieldName ,String Value)
	{
        Field field = getField(fieldName);
		WebElement weField = WebDriverProvider.get().findElement(field.getLocator());
		weField.sendKeys(Value);
	}
	public void pointMouse(String fieldName) {
	    
		Field field = getField(fieldName);
		
		switchToFrames(field.getFrames());
		WebElement weField = WebDriverProvider.get().findElement(field.getLocator());
		new Actions(WebDriverProvider.get()).moveToElement(weField).perform();
	}
	
	public boolean isDisplayed(String fieldName) {
	    
		Field field = getField(fieldName);
		
		switchToFrames(field.getFrames());
		
		List<WebElement> items = WebDriverProvider.get().findElements(field.getLocator());
		if(items.size() == 0)
			return false;
		
		return items.get(0).isDisplayed();
	}
	
	public WebElement getFieldWebElement(String fieldName){
		Field field = getField(fieldName);
		return WebDriverProvider.get().findElement(field.getLocator());
		
	}
	
	
	public List<WebElement> getFieldWebElements(String fieldName){
		Field field = getField(fieldName);
		List<WebElement> items = WebDriverProvider.get().findElements(field.getLocator());
		return items;
	}
	public static void waitForNSecond(int seconds)
	{
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
public static BigDecimal getNumberFromAmount(String amount) {
	    
		
		amount = amount.replaceAll("\\s+", EMPTY).replace(EMPTY + (char)160, EMPTY);
		
		String decimalPoint = amount.lastIndexOf(".") > amount.lastIndexOf(",") ? "." : ",";
		String separatorToRemove = decimalPoint.equals(".") ? "," : ".";
		
		amount = amount.replace(separatorToRemove, "");
		
		amount=amount.replaceAll("[^0-9,.]",EMPTY);

		
		BigDecimal number = null;
		try {
			amount = amount.replace(",", ".");
			number = new BigDecimal(amount);
			
		} catch(NumberFormatException nfEx) {
			
			nfEx.initCause(new NumberFormatException("unexpected value - not a number: " + amount));
			throw nfEx;
		}
		
		return number;
	}
}
