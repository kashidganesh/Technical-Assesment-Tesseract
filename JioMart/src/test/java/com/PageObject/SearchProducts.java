package com.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testCases.TC01;

public class SearchProducts {
	private static final Logger log = Logger.getLogger(TC01.class);
	WebDriver driver;

	public SearchProducts(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@class=\"aa-Input input-text\"]")
	@CacheLookup
	WebElement SearchProductName;

	@FindBy(xpath = "//*[@id=\"hits\"]/div/div/ol/li[1]")
	@CacheLookup
	WebElement SelectProduct;

	@FindBy(xpath = "//button[@class=\"toCart addtocartbtn prodbtn\"]")
	@CacheLookup
	WebElement AddToCart;

	@FindBy(xpath = "//span[@class=\"counter-number\"]")
	@CacheLookup
	WebElement ClickOnCart;

	@FindBy(xpath = "//button[@class='btn-checkout btn btn_to_checkout ng-star-inserted']")
	@CacheLookup
	WebElement PlaceOrder;

	public void SearchProductName() {

		SearchProductName.sendKeys("apple fruit");
		SearchProductName.sendKeys(Keys.ENTER);
	}

	public void SelectProduct() {
		SelectProduct.click();
	}

	public void AddToCart() {
		AddToCart.click();
	}

	public void ClickOnCart() throws InterruptedException {
		try {

			Thread.sleep(5000);
			ClickOnCart.click();
		} catch (Exception e) {
			log.info("ClickOnCart" + e.getMessage());
		}

	}

	public void PlaceOrder() {
		PlaceOrder.click();
	}
}
