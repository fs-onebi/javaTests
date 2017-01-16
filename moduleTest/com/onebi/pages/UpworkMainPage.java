package com.onebi.pages;

import org.openqa.selenium.By;

import com.onebi.utils.Field;
import com.onebi.utils.FieldType;
import com.onebi.utils.Page;
import com.onebi.utils.Storable;

public class UpworkMainPage extends Page {

	public enum FieldName implements Storable {
		
		ADVANCED_SEARCH,
		ADVANCED_SEARCH_BUTTON,
		CANCEL,
		CATEGORY,
		ENTRY_LEVEL,
		EXPERT,
		FIXED_PRICE,
		FULL_TIME,
		HOURLY,
		HOURS_OR_DAYS,
		INTERMEDIATE,
		LOCATION,
		LOGIN,
		LOGIN_BUTTON,
		METEOR_OFFERT_VALUES,
		MONTHS,
		MORE_THAN_SIX_MONTHS,
		NOT_SPECIFIED_DURATION,
		NOT_SPECIFIED_WORKLOAD,
		NO_HIRES,
		PASSWORD,
		POSTGRESQL_OFFERT_VALUES,
		SELENIUM_OFFERT_VALUES,
		USERNAME,
		SEARCH,
		SEARCH_BUTTON,
		SKILLS_SEARCH,
		TITLE_SEARCH
	}
	
	public UpworkMainPage() {
		

		addField(FieldName.ADVANCED_SEARCH, new Field(FieldType.BUTTON, By.xpath("//a[contains(@data-ng-click,'jsuAdvancedSearch')]")));
		addField(FieldName.ADVANCED_SEARCH_BUTTON, new Field(FieldType.BUTTON, By.xpath("//button[@class='btn btn-primary m-lg-top']")));
		addField(FieldName.CANCEL, new Field(FieldType.BUTTON, By.xpath("//button[@class='btn btn-primary m-lg-top']")));
		addField(FieldName.CATEGORY, new Field(FieldType.LIST, By.xpath("//span[contains(@class,'eo-select-label')]")));
		addField(FieldName.ENTRY_LEVEL, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'exp-filter')]/div/div[2]/label/span[1]")));
		addField(FieldName.EXPERT, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'exp-filter')]/div/div[4]/label/span[1]")));
		addField(FieldName.FIXED_PRICE, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'job-type')]/div/div[3]/label/span[1]")));
		addField(FieldName.FULL_TIME, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'workload-filter')]/div/div[3]/label/span[1]")));
		addField(FieldName.HOURLY, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'job-type')]/div/div[2]/label/span[1]")));
		addField(FieldName.HOURS_OR_DAYS, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'duration-filter')]/div/div[2]/label/span[1]")));
		addField(FieldName.INTERMEDIATE, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'exp-filter')]/div/div[3]/label/span[1]")));
		addField(FieldName.LOCATION, new Field(FieldType.LIST, By.xpath("//a[contains(@class,'select2-choice')]")));
		addField(FieldName.LOGIN, new Field(FieldType.BUTTON, By.xpath("//ul[@class='user-links list-inline pull-right']/li[2]/a")));
		addField(FieldName.METEOR_OFFERT_VALUES, new Field(FieldType.TEXT, By.xpath("//a[contains( @class,'break visited')]")));
		addField(FieldName.MONTHS, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'duration-filter')]/div/div[4]/label/span[1]")));
		addField(FieldName.MORE_THAN_SIX_MONTHS, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'duration-filter')]/div/div[5]/label/span[1]")));
		addField(FieldName.NOT_SPECIFIED_DURATION, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'duration-filter')]/div/div[6]/label/span[1]")));
		addField(FieldName.NOT_SPECIFIED_WORKLOAD, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'workload-filter')]/div/div[4]/label/span[1]")));
		addField(FieldName.NO_HIRES, new Field(FieldType.TEXT, By.xpath("//section[contains(@class,'hires-filter')]/div/div[2]/label/span[1]")));
		addField(FieldName.LOGIN_BUTTON, new Field(FieldType.BUTTON, By.xpath("//*[@id='layout']/div[1]/div/form/div[3]/div[1]/button")));
		addField(FieldName.PASSWORD, new Field(FieldType.TEXT, By.id("login_password")));
		addField(FieldName.POSTGRESQL_OFFERT_VALUES, new Field(FieldType.TEXT, By.xpath("//a[contains( @class,'break visited')]")));
		addField(FieldName.SELENIUM_OFFERT_VALUES, new Field(FieldType.TEXT, By.xpath("//a[contains( @class,'break visited')]")));
		addField(FieldName.USERNAME, new Field(FieldType.TEXT, By.id("login_username")));
		addField(FieldName.SEARCH, new Field(FieldType.TEXT, By.id("search-box-el")));
		addField(FieldName.SEARCH_BUTTON, new Field(FieldType.TEXT, By.id("submit")));
		addField(FieldName.SKILLS_SEARCH, new Field(FieldType.TEXT, By.id("skills-input")));
		addField(FieldName.TITLE_SEARCH, new Field(FieldType.TEXT, By.id("title")));
		
		
	}
	public void login(){
		
		waitForPage();
		
		setFieldValue(UpworkMainPage.FieldName.USERNAME.name(), "*******");
		setFieldValue(UpworkMainPage.FieldName.PASSWORD.name(), "*******");
		waitForNSecond(2);
		click(UpworkMainPage.FieldName.LOGIN_BUTTON.name());
		waitForPage();
	}
}
