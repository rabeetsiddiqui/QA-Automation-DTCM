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
import com.kms.katalon.core.webui.keyword.builtin.VerifyTextPresentKeyword as VerifyTextPresentKeyword
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty as SystemProperty
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import java.util.List as List
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.test.GlobalVaribale as GlobalVaribale

WebUI.openBrowser('https://www.google.com/')

def driver = DriverFactory.getWebDriver()
String baseUrl = 'https://www.google.com/'
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename() + '/en/travel-planning/itineraries/shop-like-arabian#day1')
driver.manage().window().maximize()
String CssSelector = '.dubai .nav .sub_menu li'
String ActiveStateColor = "rgba(17, 136, 215, 1)";

WebUI.click(getElement('css', '.lb-dataContainer.top-text.font_55 .top-holder > a'))
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('document.querySelectorAll(\'.dubai .nav .sub_menu li\')') 

int TravelDayNavigation = driver.findElements(By.cssSelector('.dubai .nav .sub_menu li')).size()
Thread.sleep(1500)

for (int i = 1; i <= TravelDayNavigation; i++) {
	WebUI.click(getElement('css', CssSelector + ":nth-child("+ i +")"))
	Thread.sleep(500)
	String Activecolor = WebUI.getCSSValue(getElement('css', CssSelector + ":nth-child("+ i +")" + ' .clicked '), "color")
	println (Activecolor)
	
	if(ActiveStateColor == Activecolor)
	{
		println ("Color has been Changed ")
	}
	else(ActiveStateColor != Activecolor).call( 
		{ 
			println ("Color not Changed ")
		})
	Thread.sleep(2000)
}

TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

