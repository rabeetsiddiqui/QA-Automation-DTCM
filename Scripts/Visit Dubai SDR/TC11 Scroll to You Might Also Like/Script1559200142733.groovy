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
import org.openqa.selenium.By as By
import com.test.GlobalVaribale


WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename()+"/en/shop-dine-relax/shopping")

//after landing on shopping page Closing Newsletter Component to scroll
WebUI.click(getElement('css','#bussiness-newslettermodal > div.modal-header > button'))
WebUI.scrollToElement(getElement('css','#flights > div.booking_controls_wrap.active.in > div.booking_dates > label:nth-child(1) > div'), 10)

//click on Articles
WebUI.click(getElement('css','#dsf_shop_sub_cat_filters > dl > dd > div > a:nth-child(1)'))
Thread.sleep(500)
String Default = WebUI.getUrl()
println (Default)
Thread.sleep(2000)

//Click on Article Listing
WebUI.scrollToElement(getElement('css', '#Articles_categoryDataRoot > li:nth-child(3) > div > a'), 10)
WebUI.mouseOver(getElement('css', '#Articles_categoryDataRoot > li:nth-child(5) > div > a'))
Thread.sleep(2000)
WebUI.click(getElement('css', '#Articles_categoryDataRoot > li:nth-child(5) > div > a'))
String New = WebUI.getUrl()

println (New)

if(Default != New)
{
	println ("Success")
}
else(Default == New).call(
{
	println ("Failed")
})

WebUI.scrollToElement(getElement('css','#divHomeWrap > div > div.newCategory > div.content_wrap.hotel-location-detail.deals-detail-content-wrap > div.content_cell.main_cell.detail-page-container > span:nth-child(11) > div > p:nth-child(43) > span'), 10)
WebUI.click(getElement('css', '#divHomeWrap > div > div.tiles-container.tiles-container-bottom.new-tiles-container > div:nth-child(1) > div.tout_copy_v2.color_2.promotional-tiles > div.tout_header_v2.font_35'))
WebUI.scrollToElement(getElement('css','#plhcontent_0_youmayalsolike_0_rptPromotions_divTile_0'), 10)
String NewestOnce = WebUI.getUrl()
println (NewestOnce)
if(New != NewestOnce)
{
	println ("Success")
}
else(New == NewestOnce).call(
{
	println ("Failed")
})

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}