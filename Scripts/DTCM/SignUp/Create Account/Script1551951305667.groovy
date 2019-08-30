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
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import com.test.GlobalVaribale

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()

String baseUrl = "https://www.katalon.com/"
String email = "rabeet.siddiqui@ovrlod.com"
String password = "Qwerty#1";
String name = "Rabeet";
String lastname= "Siddiqui";
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize();
//Submitting all the fields in create account page
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename() + "/en/account/create-account")

//selenium.open("https://qacd2.testvisitdubai.com/en/account/create-account")
selenium.click("id=firstName")
Thread.sleep(500);
selenium.type("id=firstName", name)
Thread.sleep(500);
selenium.type("id=lastName", lastname)
Thread.sleep(500);
selenium.type("id=password", password)
Thread.sleep(500);
selenium.type("id=confirmPassword", password)
Thread.sleep(500);
selenium.type("id=email", email)
Thread.sleep(500);
//WebUI.click(getElement("css", ".dd-selected.active-shadow .dd-selected-text"))
//selenium.click("css=.dd-selected.active-shadow .dd-selected-text")
Thread.sleep(500);
//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Country/Region'])[4]/following::label[1]")
Thread.sleep(500);
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Privacy Policy'])[1]/following::label[1]")
Thread.sleep(1500);
selenium.click("id=plhcontent_0_lbtnSubmit")
Thread.sleep(1500);
//after Submiting insert email that you entered in email create account page in the URL and getting token id 
//after getting token inserting in the URL for succesfull Create account 
selenium.open(gv.getWebsitename() + "/en/account/create-account?UT=" + email)
Thread.sleep(3000);
WebElement ParentElement = driver.findElement(By.id("divHomeWrap"))
List ChildList = ParentElement.findElements(By.tagName("h2"))
WebElement otp = ChildList.get(0)
String value = otp.getText();
Thread.sleep(2500);
String stringurl = gv.getWebsitename() + "/en/account/token-verification?register=1&token=" + value;
Thread.sleep(1500);
selenium.open(stringurl);
Thread.sleep(1500);


//selenium2 = new WebDriverBackedSelenium(driver)
//selenium.open("https://qacd2.testvisitdubai.com/en/account/create-account?UT=muhammad.saad@ovrlod.com")

//selenium = new WebDriverBackedSelenium(driver, baseUrl)
//selenium.open("https://qacd2.testvisitdubai.com/en/account/login?v=78798789")
//Thread.sleep(2000);
//selenium.click("id=tbUsername")
//selenium.type("id=tbUsername", email)
//Thread.sleep(500);
//selenium.type("id=tbPassword", password)
//Thread.sleep(500);
//selenium.click("id=plhcontent_0_lbtnSubmit")
//Thread.sleep(2000);
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}
