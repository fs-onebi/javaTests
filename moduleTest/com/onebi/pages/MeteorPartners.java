
package com.onebi.pages;

import org.openqa.selenium.By;

import com.onebi.utils.Field;
import com.onebi.utils.FieldType;
import com.onebi.utils.Page;
import com.onebi.utils.Storable;

public class MeteorPartners extends Page {

	public enum FieldName implements Storable {
		COMPANY_NEXT,
		COMPANY_VALUES
	}

	public MeteorPartners() {
		addField(FieldName.COMPANY_NEXT, new Field(FieldType.BUTTON, By.xpath("//div[contains(@class, 'partner-pagination')][1]/a[contains(@class, 'next_link')]")));
		addField(FieldName.COMPANY_VALUES, new Field(FieldType.TEXT, By.xpath("//div[contains(@class, 'partner-item')]/div[2]/p[1]/strong")));
	}
}
