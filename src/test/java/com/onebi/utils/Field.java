package com.onebi.utils;

import org.openqa.selenium.By;

public class Field {

	private FieldType fieldType;
	private By locator;
	private String[] frames;
	
	public Field(FieldType fieldType, By locator, String... frames) {
		this.fieldType = fieldType;
		this.locator = locator;
		this.frames = frames;
	}
	
	public FieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}
	public By getLocator() {
		return locator;
	}
	public void setLocator(By locator) {
		this.locator = locator;
	}
	public String[] getFrames() {
		return frames;
	}
	public void setFrames(String[] frames) {
		this.frames = frames;
	}
}
