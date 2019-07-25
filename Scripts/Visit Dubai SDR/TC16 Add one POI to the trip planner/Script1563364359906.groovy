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
selenium.open(gv.getWebsitename()+"en/shop-dine-relax/shopping" )

WebUI.scrollToElement(getElement('css', ".trip-planner-right-block.dss-rightColumn > div:nth-child(4)  > div > div > div.booking_tabs > a.active"), 15)
Thread.sleep(400)
WebUI.click(getElement('css', '#dsf_shop_sub_cat_filters > dl > dd > div > a:nth-child(2)'))
Thread.sleep(600)
WebUI.click(getElement('css', '#Itineraries_categoryDataRoot > li:nth-child(2) > div > a:nth-child(2) > h4'))
Thread.sleep(500)
WebUI.mouseOver(getElement('css', '#nav > div > div > ul > li:nth-child(4) > a'))
Thread.sleep(500)
WebUI.click(getElement('css', '#nav > div > div > ul > li:nth-child(4) > a'))
Thread.sleep(500)

WebUI.click(getElement('css', '.header .nav .cnt .sub_menu > ul > li:nth-child(4) > a'))
WebUI.click(getElement('css', '.header > div:nth-child(2) > div > div .desc .tiles_win > div .tiles.layout9 > div > div .chart > div .row > div:nth-child(1) > ul > li:nth-child(1) > h4 > a'))

String tripCount = WebUI.getText(getElement('css', '#tripPlannerIcon > span.trip_count.tp_badge'))
println (tripCount)

int tripCountInt= Integer.parseInt(tripCount)
if(tripCountInt > 0)
{
	println ("passed  =  " + tripCount)	
}

else(tripCountInt = 0).call(
{
	println ("Failed" + tripCount)
})

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}

