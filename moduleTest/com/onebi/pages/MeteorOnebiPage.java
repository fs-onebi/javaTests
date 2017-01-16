package com.onebi.pages;

import org.openqa.selenium.By;
import com.onebi.utils.Field;
import com.onebi.utils.FieldType;
import com.onebi.utils.Page;
import com.onebi.utils.Storable;

public class MeteorOnebiPage extends Page {

	public enum FieldName implements Storable {
		TEAM
	}
	
	public MeteorOnebiPage() {
		addField(FieldName.TEAM, new Field(FieldType.BUTTON, By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[3]/a")));
	}
}
