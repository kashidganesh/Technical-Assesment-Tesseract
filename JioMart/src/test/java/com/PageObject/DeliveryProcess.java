package com.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testCases.TC01;

public class DeliveryProcess {
	private static final Logger log = Logger.getLogger(TC01.class);
	WebDriver driver;

	public DeliveryProcess(WebDriver rdriver) {
		driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id='addressmodal']/div/div/div[2]/div[1]/div[5]")
	@CacheLookup
	WebElement typeYourAddres;

	@FindBy(xpath = "//input[@placeholder='Pin Code *']")
	@CacheLookup
	WebElement EnterPinCode;

	@FindBy(xpath = "//input[@id='flat_or_house_no']")
	@CacheLookup
	WebElement EnterHouseNo;

	@FindBy(xpath = "//input[@id='floor_no']")
	@CacheLookup
	WebElement FloorNo;

	@FindBy(xpath = "//input[@id='tower_no']")
	@CacheLookup
	WebElement TowerNo;

	@FindBy(xpath = "//input[@id='building_name1']")
	@CacheLookup
	WebElement BuildingName;

	@FindBy(xpath = "//input[@id='building_address']")
	@CacheLookup
	WebElement Address;

	@FindBy(xpath = "//input[@id='area_name']")
	@CacheLookup
	WebElement LandMark;

	@FindBy(xpath = "//input[@id='landmark']")
	@CacheLookup
	WebElement CityState;

	@FindBy(xpath = "//input[@id='addressee_name']")
	@CacheLookup
	WebElement PersonName;

	@FindBy(xpath = "//input[@id='mobile_no']")
	@CacheLookup
	WebElement ContactNo;

	@FindBy(xpath = "//label[@for='nhome']")
	@CacheLookup
	WebElement AddressSaveAsHome;
	
	@FindBy(xpath = "//label[@for='nwork']")
	@CacheLookup
	WebElement AddressSaveAsWork;
	
	
	@FindBy(xpath = "//label[@for='nother']")
	@CacheLookup
	WebElement AddressSaveAsOther;
	
	

	@FindBy(xpath = "//button[@class='btn']")
	@CacheLookup
	WebElement SaveAddress;

	@FindBy(xpath = "//button[@class='btn-checkout btn btn_to_checkout m-0']")
	@CacheLookup
	WebElement MakePayment;

	public void TypeYourAddress() {
		try {
			typeYourAddres.click();
		} catch (Exception e) {
			log.info("TypeYourAddress" + e.getMessage());
		}

	}

	public void EnterPinCode(String PinCode) {

		try {
			EnterPinCode.sendKeys(PinCode);
		} catch (Exception e) {
			log.info("EnterPinCode" + e.getMessage());
		}
	}

	public void EnterHouseNo(String HouseNo) {

		try {
			EnterHouseNo.sendKeys(HouseNo);
		} catch (Exception e) {
			log.info("EnterHouseNo" + e.getMessage());
		}

	}

	public void FloorNo(String FloorN) {

		try {
			FloorNo.sendKeys(FloorN);
		} catch (Exception e) {
			log.info("FloorNo" + e.getMessage());
		}
	}

	public void TowerNo(String TowerN) {

		try {
			TowerNo.sendKeys(TowerN);
		} catch (Exception e) {
			log.info("TowerNo" + e.getMessage());
		}
	}

	public void BuildingName(String BuildingN) {

		try {
			BuildingName.sendKeys(BuildingN);
		} catch (Exception e) {
			log.info("BuildingName" + e.getMessage());
		}
	}

	public void Address(String Addres) {

		try {
			Address.sendKeys(Addres);
		} catch (Exception e) {
			log.info("Address" + e.getMessage());
		}

	}

	public void LandMark(String Landmark) {

		try {
			LandMark.sendKeys(Landmark);
		} catch (Exception e) {
			log.info("LandMark" + e.getMessage());
		}
	}

//	public void CityState() {
//		CityState.sendKeys("Maharashtra,Navi Munbai");
//	}

	public void PersonName(String PersonN) {

		try {
			PersonName.clear();
			PersonName.sendKeys(PersonN);
		} catch (Exception e) {
			log.info("PersonName" + e.getMessage());
		}

	}

	public void ContactNo(String ContactN) {
		try {
			ContactNo.clear();
			ContactNo.sendKeys(ContactN);
		} catch (Exception e) {
			log.info("ContactNo" + e.getMessage());
		}

	}

	public void AddressSaveAs(String AddresSaveAs) {
		try {
			
			String SaveAs = AddresSaveAs;
			
			switch (SaveAs) {
			case "Home":
				AddressSaveAsHome.click();
				break;	
			case "Work":
				AddressSaveAsWork.click();
				break;	
			default:
				AddressSaveAsOther.click();
				break;
			}
			
		} catch (Exception e) {
			log.info("AddressSaveAs :"+AddresSaveAs+" "+e.getMessage());
		}

	}

	public void SaveAddress() {
		try {
			SaveAddress.click();
		} catch (Exception e) {
			log.info("SaveAddress" + e.getMessage());
		}

	}

	public void MakePayment() {
		try {
			MakePayment.click();
		} catch (Exception e) {
			log.info("MakePayment" + e.getMessage());
		}

	}

}
