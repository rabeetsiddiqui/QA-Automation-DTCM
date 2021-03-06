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
import org.openqa.selenium.remote.server.handler.FindElement
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.test.GlobalVaribale
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename()+"/en/shop-dine-relax/shopping")

WebUI.waitForPageLoad(2000)
//after landing on shopping page Closing Newsletter Component to scroll
WebUI.click(getElement('css','#bussiness-newslettermodal > div.modal-header > button'))
WebUI.scrollToElement(getElement('css','#flights > div.booking_controls_wrap.active.in > div.booking_dates > label:nth-child(1) > div'), 10)
String DefaultUrl = WebUI.getUrl();
println (DefaultUrl)

//click/GetText on Articles

String Default = WebUI.getText(getElement('css', '#Articles_categoryDataRoot > li:nth-child(1) > div > a > h4'))
println (Default)
Thread.sleep(1500)

//Click on Experiences
WebUI.click(getElement('css', '#dsf_shop_sub_cat_filters > dl > dd > div > a:nth-child(3)'))
Thread.sleep(1000)
String New= WebUI.getText(getElement('css', '#POIS_categoryDataRoot > li:nth-child(1) > div > a:nth-child(2) > h4'))
println (New)
Thread.sleep(1000)
if(Default != New && Default == New == false)
{
	println ("Success")
}
else
	{
		KeywordUtil.markFailed('Failed')
	}

WebUI.click(getElement('css','#POIS_categoryDataRoot > li:nth-child(2) > div > a:nth-child(2)'))
Thread.sleep(1000)

String beforeclick = WebUI.getCSSValue(getElement('css', '#tabMenu'), 'background-color')
println (beforeclick)
Thread.sleep(1000)

WebUI.mouseOver(getElement('css', '#tabMenu> li'))
WebUI.mouseOver(getElement('css', '#tabMenu > li.ratings'))
Thread.sleep(1000)
WebUI.click(getElement('css', '#tabMenu > li.ratings'))
Thread.sleep(1500)
WebUI.getCSSValue(getElement('css', '#tabMenu > li.ratings.active_tab'), 'background-color')
Thread.sleep(1500)
WebUI.click(getElement("css", "#tabMenu > li.overview.mouseout"))
Thread.sleep(1600)
String overviewBg = WebUI.getCSSValue(getElement('css', '#tabMenu > li.overview.mouseout'), 'background-color')
println (overviewBg)
Thread.sleep(1000)
if(overviewBg == "rgba(72, 72, 72, 1)" && overviewBg != "rgba(72, 72, 72, 1)" == false)
{
	println ("Passed")
	WebUI.closeBrowser()
}
else
{
	KeywordUtil.markFailed('Failed')
}


TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}


