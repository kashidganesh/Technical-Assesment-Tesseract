package com.PageObject;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testCases.TC01;

public class SignInPage {
	private static final Logger log = Logger.getLogger(TC01.class);
	WebDriver driver;

	public SignInPage(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//div[@class=\'logged\']")
	@CacheLookup
	WebElement logged;
	
	public void clickOnSignIn() {
		try {
			logged.click();
		} catch (Exception e) {
			log.info("Exception : "+e.getMessage());
		}
		
	}
	
	
	@FindBy(xpath = "//*[@id=\"loginfirst_mobileno\"]")
	@CacheLookup
	WebElement EntrNo;
	
	@FindBy(xpath = "//button[@class=\'btn-signpass arrowbtn\']")
	@CacheLookup
	WebElement Entr;
	
	public void EntrPhNo(String PhNo) throws InterruptedException {
		
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		EntrNo.sendKeys(PhNo);
	}
	
	public void click() {
		Entr.click();
	}
	
	@FindBy(xpath = "//input[@class='form-control ng-pristine ng-invalid ng-touched']")
	@CacheLookup       
	WebElement EntrOTP;
	
	
	
	
//	@FindBy(xpath = "//input[@class='singalotpcol logotp ng-pristine ng-invalid ng-touched']")
//	@CacheLookup                     
//	WebElement EntrOTP1;
	
	
	@FindBy(xpath = "//button[@class=\"btn-login\"]")
	@CacheLookup
	WebElement Verify;
	
	public void EntrOTP() throws InterruptedException {
		JavascriptExecutor executor= (JavascriptExecutor) driver;
		executor.executeScript("alert('Enter The OTP recived from given number')");
		Thread.sleep(7000);
		//EntrOTP1.sendKeys(Keys.TAB);
		Thread.sleep(10000);
		//EntrNo.sendKeys(Keys.TAB);
		//EntrNo.sendKeys(Keys.TAB);
		
		//JavascriptExecutor executor= (JavascriptExecutor) driver;
		//executor.executeScript("alert('Enter The OTP recived from given number')");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void VerifyOnclick() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Verify.click();
	}
	
}
