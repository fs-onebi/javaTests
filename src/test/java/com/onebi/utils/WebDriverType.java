package com.onebi.utils;

import static org.apache.commons.lang3.StringUtils.EMPTY;

public enum WebDriverType {
	
	CHROME("src\\test\\resources\\drivers\\chromedriver.exe"),
    FIREFOX(EMPTY);
    
    private String driverLocation;
    
    private WebDriverType(String driverLocation) {
    	this.driverLocation =driverLocation;
    }

    public String getDriverLocation() {
        return driverLocation;
    }
}
