
package com.onebi.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/test/features"},
	glue = {"com.onebi.steps", "com.onebi.utils"},
	plugin = {"html:target/cukes", "json:target/cucumber-report.json", "junit:target/cucumber-report.xml", "pretty"},
	strict = true,
	tags = {"@run_UpWork"}
)
public class UpWorkTestRunner {}
