package com.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.w3c.dom.UserDataHandler;

import com.aventstack.extentreports.utils.FileUtil;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class BaseClass {
	private static final Logger log = Logger.getLogger(BaseClass.class);

	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getApplicationURL();
	public static WebDriver driver;

	// public static Logger Logger;

//	@BeforeTest(dependsOnMethods = {"loginTest"})
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {

		// PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readConfig.getChromePath());
			driver = new ChromeDriver();
			log.info("OpanCrome Browser");

		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
			log.info("Opan firefox Browser");
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new InternetExplorerDriver();
			log.info("Opan ie Browser");
		}

		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDwon() {
		driver.quit();
		log.info("Close Browser");
	}

	@DataProvider(name = "AddressDetails")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/testData/CustInfo.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet2");
		System.out.println("rownum :" + rownum);
		log.info("rownum :" + rownum);
		int colcount = XLUtils.getCellCount(path, "Sheet2", 1);
		log.info("colcount :" + colcount);
		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet2", i, j);
			}
		}

		return logindata;
	}

	@DataProvider(name = "PhoneNo")
	String[][] getData01() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/java/com/testData/CustInfo.xlsx";
		// String path = "D:/Testing/Technical Assessment Jio/Jio
		// Tesseract/JioMart/src/test/java/com/testData/CustInfo.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		System.out.println("rownum :" + rownum);
		log.info("rownum :" + rownum);
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		log.info("colcount :" + colcount);
		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}

		return logindata;
	}

	public static void takeScreenShot(String fileName) throws IOException {
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/Screenshots/" + fileName + ".jpg"));

	}

}
