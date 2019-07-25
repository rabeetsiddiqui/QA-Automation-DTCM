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
import com.test.GlobalVaribale
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

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename()+"/en/events/experiences#/")
WebUI.waitForPageLoad(200)

WebUI.scrollToElement(getElement('css', '#events-top > div:nth-child(6) > div > div.content_cell.main_cell > div.no-overflow > div > div.heading.inner > span > h1'), 100)
Thread.sleep(700)
WebUI.click(getElement('css', '#event0 > ul > li.trip_detail.main_cell.valign-top > a > span > h2'))
Thread.sleep(500)
WebUI.scrollToElement(getElement('css', '.content_cell.main_cell > div:nth-child(4)'), 100)
Thread.sleep(500)
WebUI.click(getElement('css', '.content_cell.main_cell > div:nth-child(5) > div .content_section .add-to-cal >span .atcb-link'))
Thread.sleep(500)
WebElement pagerElement = driver.findElement(By.cssSelector(".content_cell.main_cell > div:nth-child(5) > div .content_section .add-to-cal >span .atcb-list > li:nth-child(2) > a:first-child"));
String newTab= pagerElement.getAttribute("target")
println (newTab)
WebUI.click(getElement('css', '.content_cell.main_cell > div:nth-child(5) > div .content_section .add-to-cal >span .atcb-list > li:nth-child(2) > a:first-child'))

ArrayList tabs = new ArrayList (driver.getWindowHandles());
System.out.println(tabs.size());
driver.switchTo().window(tabs.get(1))
Thread.sleep(500)
String NewUrl = WebUI.getUrl();

if(NewUrl.contains("/accounts.google.com") && newTab=="_blank"){
	println ("Test passed")
}

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')
	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
	return newTestObject
}