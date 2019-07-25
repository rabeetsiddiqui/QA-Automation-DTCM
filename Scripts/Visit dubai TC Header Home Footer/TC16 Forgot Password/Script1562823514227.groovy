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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return
import org.junit.After
import org.openqa.selenium.By as By
import com.test.GlobalVaribale as GlobalVaribale
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.thoughtworks.selenium.Selenium
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.test.GlobalVaribale
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = 'https://www.google.com/'
String base = driver.getWindowHandle();
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()

GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename()+"/en/account/login" )

WebUI.click(getElement('css', '.form > a.more_link'))
Thread.sleep(600)
WebUI.setText(getElement('css', '#txtResetPasswordEmail'), "testovrlod123@gmail.com")
Thread.sleep(400)
WebUI.click(getElement('css', '.rs_preserve > div:nth-child(2) #resetpassworddiv .text-holder-find-account .banner-buttons-red.font_41.color_2'))
Thread.sleep(500)

// Open new tab and concatinantion of email in the URL
JavascriptExecutor js = ((driver) as JavascriptExecutor)
Thread.sleep(500);

//Open Email Url in New Tab
String CreateAccountUrl = 'https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin';
String command = "window.open('" + CreateAccountUrl + "');";
System.out.println(command);
js.executeScript(command)

ArrayList tabs = new ArrayList (driver.getWindowHandles());
System.out.println(tabs.size());
driver.switchTo().window(tabs.get(1));

//Login Email
WebUI.setText(getElement('css', "#identifierId"), "testovrlod123@gmail.com")
WebUI.click(getElement('css', ".RveJvd.snByac"))
Thread.sleep(600)
WebUI.setText(getElement('css', '#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input'), "ovrlod_321321")
Thread.sleep(500)
WebUI.click(getElement('css', ".RveJvd.snByac"))
Thread.sleep(500)
WebUI.click(getElement('css', ".F.cf.zt > tbody >tr"))
Thread.sleep(600)
String text = driver.findElement(By.cssSelector('.a3s.aXjCH > div:nth-child(2) > table > tbody > tr > td > center > table:nth-child(2) > tbody > tr:nth-child(3) > td > table > tbody > tr > td:nth-child(1) > b')).getText()
println (text)
Thread.sleep(400)

driver.switchTo().window(base);
WebUI.setText(getElement('css', '#txtToken'), text) // Token Number Will be paste here 
Thread.sleep(400)
WebUI.click(getElement('css', '.rs_preserve > div:nth-child(2) #verifytokendiv .text-holder-find-account  .banner-buttons-red.font_41.color_2')) // ToClick on Verify CTA to redirect on Reset Password Page


TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}

