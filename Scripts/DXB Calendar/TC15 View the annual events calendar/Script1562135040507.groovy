import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import internal.GlobalVariable as GlobalVariable
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
import java.util.regex.Pattern

import javax.persistence.Convert

import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.interactions.Actions
import com.kms.katalon.core.util.KeywordUtil
import com.test.GlobalVaribale

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()

GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename() + "/en/events#/?type=Leisure")

//selenium.open("https://www.visitdubai.com/en/events#/?type=Leisure")
WebUI.waitForPageLoad(200)
Thread.sleep(500);
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,1000)");
Thread.sleep(500)
WebElement pagerElement = driver.findElement(By.cssSelector(".events-tiles > div:nth-child(1) > a"));
String newTab= pagerElement.getAttribute("target")
println (newTab)
WebUI.click(getElement('css','.events-tiles > div:nth-child(1)'))
WebUI.waitForPageLoad(200)

Thread.sleep(500);
String newUrl = driver.getCurrentUrl()
String winHandleBefore = driver.getWindowHandle();
	
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
			newUrl = driver.getCurrentUrl();
			
		}
if(newUrl.contains("annual%20calendars") && newTab=="_blank"){
	println ("Test passed")
}
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')
	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
	return newTestObject
}