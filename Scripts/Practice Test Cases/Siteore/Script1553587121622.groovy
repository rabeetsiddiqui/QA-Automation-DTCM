import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*

import java.lang.annotation.Documented
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;


WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "http://arb-enhc-dev/sitecore/login"
JavascriptExecutor js = (JavascriptExecutor) driver;
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize();
selenium.open("http://arb-enhc-dev/sitecore/login")
selenium.click("id=UserName")
selenium.type("id=UserName", "rabeet")
Thread.sleep(500);
selenium.type("id=Password", "mirum_r")
Thread.sleep(500);
selenium.click("id=LogInBtn")
Thread.sleep(1000);

selenium.open("http://arb-enhc-dev/sitecore/client/Applications/Launchpad?sc_lang=en#dateFrom=26-12-2018&dateTo=26-03-2019")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Marketing Control Panel'])[1]/following::img[1]")
Thread.sleep(3000);
selenium.click("id=Tree_Glyph_C7FB05E4FCD5442AA064AD5437A9A1C8")
				//String AlrajhiSaudia = "document.getElementById("Tree_Glyph_7FF2221ED64845EEBB68843C5FA0F696";
Thread.sleep(1000);
selenium.click("id=Tree_Glyph_7FF2221ED64845EEBB68843C5FA0F696")
				//js.executeScript("document.querySelectorAll('#Tree_Glyph_7FF2221ED64845EEBB68843C5FA0F696')[0].click()");
Thread.sleep(500);
selenium.click("id=Tree_Glyph_F246AAC64DAA4676A803CA9BFC8C186F")
Thread.sleep(500);
System.out.println("Failed");
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Templates'])[1]/following::div[2]")
selenium.click("id=Tree_Glyph_0E5A89A3C5724BA2BA22FCA5720FE7A7")
Thread.sleep(500);

js.executeScript("document.getElementById('Tree_Node_EA3B969E154343CD858C50AA3F407939').click()");
Thread.sleep(500);

					//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='element-about-offer-and-discounts'])[1]/following::span[1]")
					//assertEquals("Please wait while the Content Editor is loading.", selenium.getAlert());
					//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Subitems Sorting'])[1]/following::td[4]")
					//selenium.selectWindow("win_ser_1")



js.executeScript("document.getElementById('RibbonEA3B969E154343CD858C50AA3F407939_Nav_PublishStrip').click();");
Thread.sleep(500);

js.executeScript("document.querySelectorAll('.scRibbonToolbarSmallButton')[0].click()");
Thread.sleep(45000);



//driver.switchTo().frame(driver.findElements(By.id("scWebEditRibbon")));
//driver.findElement(By.cssSelector('.sc-quickbar-button:nth-child(3)')).click();
//

//WebElement frame = driver.findElement(By.className('scWebEditRibbon'));
//driver.switchTo().frame(frame);
//driver.findElement(By.cssSelector('.sc-quickbar-button:nth-child(3)')).click();

driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
//driver.findElement(By.cssSelector('.sc-quickbar-button:nth-child(3)')).click();
JavascriptExecutor js2 = (JavascriptExecutor) driver;
js2.executeScript("(Documented.querySelectorAll('.sc-quickbar-button')[2])");

	
//selenium.selectFrame("index=1");ss
//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Rabeet Siddiqui'])[1]/following::a[3]")

 
//Clicking inside Iframe
//driver.switchTo().frame(1);


//driver.findElement(By.cssSelector('.sc-quickbar-button:nth-child(3)')).click();

//JavascriptExecutor js2 = (JavascriptExecutor) driver;
//js2.executeScript("(document.querySelectorAll('.sc-quickbar-button')[2]).click()")

//Thread.sleep(500);
//js.executeScript("document.querySelectorAll('scInsertionHandle')[12].click();")
//Thread.sleep(5000);
