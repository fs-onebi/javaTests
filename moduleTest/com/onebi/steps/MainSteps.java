package com.onebi.steps;

import com.onebi.pages.UpworkMainPage;
import com.onebi.utils.Buffer;
import com.onebi.utils.WebDriverProvider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import static org.junit.Assert.*;


import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static com.onebi.utils.PageFactory.*;
import static com.onebi.utils.Page.waitForNSecond;
public class MainSteps {
	private static String EMAIL_USERNAME = "fwfafdasdasdasdsad@gmail.com";
	private static String EMAIL_PASSWORD = "123aaa123";
	private static Properties EMAIL_PROPS = new Properties();
	
	static {
		EMAIL_PROPS.put("mail.smtp.auth", "true");
		EMAIL_PROPS.put("mail.smtp.starttls.enable", "true");
		EMAIL_PROPS.put("mail.smtp.host", "smtp.gmail.com");
		EMAIL_PROPS.put("mail.smtp.port", "587");
	};
	
	@Given("^Otworz strone (.+)$")
	public void openPage(String url) {

		WebDriverProvider.get().get(url);
	}

	@When("^(.+): adres strony zawiera (.+)$")
	public void pageUrlContains(String pageName, String pageUrl) {
		
		assertTrue(WebDriverProvider.get().getCurrentUrl().contains(pageUrl));
	}

	@Then("^(.+): (kliknij|odznacz) (.+)$")
	public void clickInField(String pageName,String type ,String fieldName) {
		
		getRequiredPage(pageName).click(fieldName);
	}
	
	@Then("^Poczekaj (\\d+) sekund$")
	public void wait(int seconds) {
	    
		waitForNSecond(seconds);
		
	}
	
	@Then("^Wyslij email o temacie (.+) o zapamietanej tresci (.+) do (.+)$")
	public void sendEmailUsingRemeberedContent(String subject, String remeberedContentName, String to) {
		if(!Buffer.containsKey(remeberedContentName))
			return;
		
		Session session = Session.getInstance(EMAIL_PROPS, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL_USERNAME));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(Buffer.get(remeberedContentName));
			Transport.send(message);
		}
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	 @Given("^(.+): Zaloguj sie do (.+)$")
	    public void login(String pageName, String loginPage) {
	        if (loginPage.equals("upwork")) {
	            if (getRequiredPage(pageName) instanceof UpworkMainPage){
	                ((UpworkMainPage) getRequiredPage(pageName)).login();
	        }
	        
	        }
	    }

		@Given("^(.+): w pole ([^ ]+) wprowadz wartosc (.+)$")
		public void setFieldValue(String pageName, String fieldName, String value) {
			
			 WebDriverProvider.get().findElement(getRequiredPage(pageName).getField(fieldName).getLocator()).sendKeys(value);
		}
}
