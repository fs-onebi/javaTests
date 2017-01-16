package com.onebi.pages;

import org.openqa.selenium.By;

import com.onebi.utils.Field;
import com.onebi.utils.FieldType;
import com.onebi.utils.Page;
import com.onebi.utils.Storable;

public class MainPage extends Page {

	public enum FieldName implements Storable {
		OUR_APPROACH,
		SERVICES
	}
	
	public MainPage() {
		addField(FieldName.OUR_APPROACH, new Field(FieldType.BUTTON, By.xpath("//div[@class='nav-wrapper']//ul/li[3]/a")));
		addField(FieldName.SERVICES, new Field(FieldType.BUTTON, By.xpath("//div[@class='nav-wrapper']//ul/li[4]/a")));
	}
}
