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
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize();
selenium.open("http://thepetsplanet.somee.com/")
Thread.sleep(500);
selenium.click("document.querySelectorAll('.nav-link')[4]");

selenium.click("id=US_Name")
selenium.type("id=US_Name", "Ashar")
Thread.sleep(500);

selenium.click("id=US_Phone")
selenium.type("id=US_Phone", "03112050228")
Thread.sleep(500);

WebUI.sendKeys(getElement('css', '#US_Address'), 'A-49 block 11 Fb area karachi')

selenium.type("id=US_Email", "ashar.baig@ovrlod.com")
Thread.sleep(500);

selenium.type("id=US_Password", "Qwerty@123")
Thread.sleep(500);
WebUI.sendKeys(getElement('css', '#US_ConfirmPassword'), 'Qwerty@123')

//selenium.type("id=US_ConfirmPassword", "Qwerty#1")
Thread.sleep(500);

//WebUI.click(getElement('css', 'body > section.inner-pages.py-5 > div > section > form > div > div:nth-child(7) > div > button'))
//WebUI.sendKeys(getElement('css', '#US_Address'))

WebUI.executeJavaScript("document.querySelector('.btn.btn-primary').click()", [])

//selenium.click("document.querySelector('.btn.btn-primary')");
System.out.println("Test Case is Passed");




TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}
