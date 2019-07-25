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

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())
String Color = "rgba(248, 156, 27, 1)";

WebUI.waitForPageLoad(600)
WebUI.mouseOver(getElement('css', '#ctl16_hlEventsCalendar'))
String CurrentUrl = WebUI.getUrl()
println (CurrentUrl)

//CLick on Dubai Calendar Page
WebUI.click(getElement('css', '#ctl16_hlEventsCalendar'))
String AfterClick = WebUI.getUrl()
println (AfterClick)

//Verifing the Click event of Dubai Calendar
if(CurrentUrl != AfterClick)
{
	println ('Success')
}
else(CurrentUrl == AfterClick).call(
{
		println ('Failed')
})

//Scroll to the page
WebUI.scrollToElement(getElement('css', '#event-calendar-banner-carousel > div > div > div > div.bx-controls.bx-has-pager.bx-has-controls-direction.bx-has-controls-auto > div.bx-controls-auto'),10)
Thread.sleep(1000)

selenium.click('css=.filter-btn')

int TagsLength = driver.findElements(By.cssSelector('.search-filter-dsf .filters a')).size()

System.out.println('number of languages: ' + TagsLength)

for(int i =2 ; i <= TagsLength ; i++)
{	
	WebUI.mouseOver(getElement('css', '.search-inner .filters > a' + ':nth-child(' + i + ')'))
	String TagName = WebUI.click(getElement('css', '.search-filter-dsf .filters > a' + ':nth-child(' + i + ')'))
	
	Thread.sleep(1000)
	String TxtBoxContent = WebUI.getText(getElement('css', '.heading.inner > small')).toString()
	println(TxtBoxContent)
	
	WebUI.click(getElement('css', '.search-filter-dsf .filters > a:nth-child('+i+')'))
	Thread.sleep(1000)
	
}

Thread.sleep(4000)
WebUI.closeBrowser()

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}
