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
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.apache.poi.hssf.record.PageBreakRecord.Break
import org.openqa.selenium.By as By
import com.test.GlobalVaribale
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())

WebUI.waitForPageLoad(600)
WebUI.mouseOver(getElement('css', '.calendar_button.icon_button'))
String CurrentUrl = WebUI.getUrl()
println (CurrentUrl)

//CLick on Dubai Calendar Page
WebUI.click(getElement('css', '.calendar_button.icon_button'))
String AfterClick = WebUI.getUrl()
println (AfterClick)

//Verifing the Click event of Dubai Calendar
if(CurrentUrl != AfterClick)
{
	println ('Success')
}
else(CurrentUrl == AfterClick)(
{
		KeywordUtil.markFailed('Failed')
})

//Scroll to the page
WebUI.scrollToElement(getElement('css', '#event-calendar-banner-carousel > div > div > div > div.bx-controls.bx-has-pager.bx-has-controls-direction.bx-has-controls-auto > div.bx-controls-auto'),10)
Thread.sleep(1000)
WebUI.click(getElement('css', '.ng-scope .search-filter-dsf .search-inner #search-box .aaa-fieldset .view-btns > a:nth-child(2)'))

//BackgroundColor Featured Icon before click
String BeforeClickBackgroundcolor = WebUI.getCSSValue(getElement('css','.ng-scope .search-filter-dsf .search-inner #search-box .aaa-fieldset .view-btns > a.star-btn'), 'background-color')
println (BeforeClickBackgroundcolor)

//CLick on Featured Icon
WebUI.click(getElement('css', '.ng-scope .search-filter-dsf .search-inner #search-box .aaa-fieldset .view-btns > a:nth-child(1)'))
Thread.sleep(1000)
//BackgroundColor Featured Icon before click
String AfterClickBackgroundcolor = WebUI.getCSSValue(getElement('css','.ng-scope .search-filter-dsf .search-inner #search-box .aaa-fieldset .view-btns .star-btn.active'), 'background-color')
println (AfterClickBackgroundcolor)


if(BeforeClickBackgroundcolor != AfterClickBackgroundcolor)
{
	println ("-----Success-----")
}
else(BeforeClickBackgroundcolor == AfterClickBackgroundcolor)(
{

	KeywordUtil.markFailed('Failed')
})


int eventsinpagecount = driver.findElements(By.cssSelector('.events-dsf.ng-scope >div:nth-child(3) > ul > li')).size()
println (eventsinpagecount)

int FeaturedIcon = driver.findElements(By.cssSelector('.events-dsf.ng-scope >div:nth-child(3) > ul > li >a .featured-sign.ng-scope')).size()
println (FeaturedIcon)

if(eventsinpagecount == FeaturedIcon)
{
	println ("The Featured event count is =" + FeaturedIcon + "-------Success-----")
}
else(eventsinpagecount != FeaturedIcon)(
{

	println ("It is also showing unfeatured events = " + FeaturedIcon + "  -------Failed-----")
	KeywordUtil.markFailed('Failed')
})


WebUI.closeBrowser()
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}
