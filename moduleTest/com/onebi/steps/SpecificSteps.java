package com.onebi.steps;

import static com.onebi.utils.PageFactory.*;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.By.xpath;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.onebi.utils.Buffer;
import com.onebi.utils.FileStuff;
import com.onebi.utils.WebDriverProvider;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class SpecificSteps {

	
	@When("^(.+): Dla listy (.+) znajdz nowe wartosci i zapisz raport do (.+)$")
	public void findNewItemsInPaginatedUsingFileStoredList(String pageName, String listName, String rememberAs) {
   	    JavascriptExecutor js;
		List<String> companies = new ArrayList<String>();
		
		if(listName.equals("COMPANY"))
		{
		boolean isNextPage = true;
		WebElement next;
		while(isNextPage){

			List<WebElement> ele = getRequiredPage(pageName).getFieldWebElements(listName + "_VALUES");
			for(WebElement company: ele){
				if(!companies.contains(company.getText()))
					companies.add(company.getText());
				else
					isNextPage = false;
			}
			next = getRequiredPage(pageName).getFieldWebElement(listName + "_NEXT");
			js = (JavascriptExecutor) WebDriverProvider.get();
	        js.executeScript("arguments[0].click();",next);
		}
		}
		else{
			List<WebElement> ele = getRequiredPage(pageName).getFieldWebElements(listName + "_VALUES");
			for(WebElement company: ele){
				if(!companies.contains(company.getText()))
					companies.add(company.getText());	
			}
		}
		
		List<String> comparedList = new FileStuff().run(listName, companies);
		
		if(comparedList.size() > 0)	{
			if(listName.equals("COMPANY"))
			{
			String emailcontent="Nowi partnerzy meteora:\n";
			for(String company: comparedList)
				emailcontent+=company+"\n";
			
			Buffer.set(rememberAs, emailcontent);
			}
			else{
				String list="";
				for(String company: comparedList)
					list+=company+"\n";
				
				Buffer.set(rememberAs, list);
				
			}
		}
		assertTrue(true);
	}
	@Then("^Upwork : Przefiltruj liste (.+) i zapisz do bazy$")
	public void filtrAndSave(String listName) {
		if(!Buffer.containsKey(listName))
			return;
		
		MongoClientURI uRI = new MongoClientURI("mongodb://login:password@ds055885.mongolab.com:55885/joboffers");
		MongoClient mongoClient = new MongoClient(uRI);
	    MongoDatabase db = mongoClient.getDatabase(uRI.getDatabase());
		
		
		WebDriver driver = WebDriverProvider.get();
		List<String> list = new ArrayList<String>();
	    Arrays.asList(Buffer.get(listName).split("\n")).stream().forEach(a -> list.add(a.trim()));
	        
	        for(String item : list)
	        { 
            
	           WebElement link =WebDriverProvider.get().findElement(By.linkText(item));
	      	    link.click();
	      	  String country ="";
	      	  String jobForm ="";  
	          String experience  ="";
	          String budget="";
	          String avgPaid ="0";
	          String headline="";
	          String details="";
	          for(WebElement i : driver.findElements(By.xpath("//div[contains(@class,'p-0-right')]"))){
	        	  if(i.getText().contains("Level"))
	        		  experience= i.getText();
	        	  else if(i.getText().contains("Budget"))
	        		  budget= i.getText();
	        	  else 
	        		  jobForm = i.getText();
	          }
	          for(WebElement i : driver.findElements(By.xpath(" //*[@id='layout']/div[1]/div[3]/div[2]//p")))
	          {
	        	  if(i.getText().contains("PM") | i.getText().contains("AM"))
	        		  country= i.getText();
	        	  else if(i.getText().contains("Avg Hourly Rate Paid"))
	        		  avgPaid= i.findElement(xpath(".//strong")).getText();
	        	 
	          }
	   
	      	    headline = item;
	      	    details = driver.findElement(By.xpath("//*[@id='layout']/div[1]/div[3]/div[1]/div[2]/div[1]/p[1]")).getAttribute("outerHTML");
	      	    String offertLink = driver.getCurrentUrl();
	      	    ObjectId gID = ObjectId.get();
	      	    String id = gID.toString();
	      	 
	          	Date date = new Date();
	      	    db.getCollection(listName).insertOne(
	      	    			new Document()
	      	    			.append("_id", id)
	      	    			 .append("createdAt", date)
	      	    			 .append("headline", headline)
	      	    	     	.append("budget", budget)
	      	    			.append("details", details)
	      	    			.append("experience", experience)
	      	    			.append("jobForm", jobForm)
	      	    			.append("offertLink", offertLink)
	      	    			.append("avgPaid", avgPaid)
	      	    			.append("country", country)
	      	    			);
	      	    
	      	    driver.navigate().back();
	        }
	       mongoClient.close();
	}

}
