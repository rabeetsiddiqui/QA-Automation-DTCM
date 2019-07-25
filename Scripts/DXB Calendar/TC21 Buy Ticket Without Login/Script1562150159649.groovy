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
import javax.persistence.Convert as Convert
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import java.util.Date as Date
import org.apache.commons.lang.time.DateUtils as DateUtils
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.By as By
import com.test.GlobalVaribale

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())

WebUI.mouseOver(getElement('css', '.main_nav_container > div > div > ul > li:nth-child(3) > a'))
Thread.sleep(600)
WebUI.click(getElement('css', '.main_nav_container > div > div > ul > li:nth-child(3) > a'))
Thread.sleep(400)
WebUI.scrollToElement(getElement('css', '#events-top > div:nth-child(9) > div > div.heading > a'), 15)
Thread.sleep(400)

String DXBhomepage = WebUI.getUrl()
println (DXBhomepage)

WebUI.mouseOver(getElement('css', '#events-top > div:nth-child(9) > div > div:nth-child(3) > ul > li:nth-child(1) > div > a > h2'))
Thread.sleep(400)
WebUI.click(getElement('css', '#events-top > div:nth-child(9) > div > div:nth-child(3) > ul > li:nth-child(1) > div > a > h2'))

String EventDetailPage = WebUI.getUrl()
println (EventDetailPage)

if(DXBhomepage !=  EventDetailPage)
{
	println ("Passed")
}
else(DXBhomepage ==  EventDetailPage).call(
{
	println ("Failed")
})

WebUI.scrollToElement(getElement('css', '.content_box_body.tab_panels_wrap > div >div:nth-child(1) > div'), 15)

WebUI.click(getElement('css', '.btn-calendar-ticket.btn-ticket.btn-buy-ticket'))

WebElement BuyTicketOverlay = driver.findElement(By.cssSelector(".modal.fade.modal-login-alert"));
String Overlay= BuyTicketOverlay.getAttribute("style")
Thread.sleep(500)

if(Overlay.contains("display: block;"))
{
	println ("Passed")
}
else(Overlay.contains("display: none;")).call(
{
	println ("Failed")
})

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}
