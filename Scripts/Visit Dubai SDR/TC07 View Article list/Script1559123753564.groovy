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
selenium.open(gv.getWebsitename())

//Hover on shop,dine,Relax
WebUI.mouseOver(getElement("css",".homepage_section .mobile_nav .main-nav .nav-section > li:nth-child(3)"))
Thread.sleep(1000)
//Open Shopping Dropdown under Shop dine Relax
WebUI.click(getElement("css", ".mobile_nav .main-nav .nav-section > li:nth-child(3) > ul > li:nth-child(3)"))
Thread.sleep(500)
//Click on See more Subitem under Shopping 
WebUI.click(getElement("css",".mobile_nav .main-nav .nav-section > li:nth-child(3) > ul > li:nth-child(3) .sub-level.hidden > li:nth-child(7)"));

//after landing on shopping page Closing Newsletter Component to scroll
WebUI.click(getElement('css', '.modal-content.business-modal.visitdubai-modal .modal-header .close.b-close'))
WebUI.scrollToElement(getElement('css','.vdf-col-right .sidebar-dynamic-img .banner-slide-wrap.slick-initialized.slick-slider .slick-dots .aaa-right-pause.aaa-right-control'), 150)

//Click on Itineraries to show changes in Articles
WebUI.click(getElement('css', '.dropdown_filter .sub_cat_filters.nav.nav-tabs > a:nth-child(2)'))
Thread.sleep(500)
String Default= WebUI.getText(getElement('css', '.tab-content .tab-pane.active .dsf_shop_cat_deals > li:nth-child(1) .dsf_shop_cat_deals_info > a:nth-child(2) > h4'))
println (Default)
Thread.sleep(1500)

//click on Articles
WebUI.click(getElement('css','.dropdown_filter .sub_cat_filters.nav.nav-tabs > a:nth-child(1)'))
Thread.sleep(500)
String New = WebUI.getText(getElement('css', '.tab-content .tab-pane.active .dsf_shop_cat_deals > li:nth-child(1) .dsf_shop_cat_deals_info > a > h4'))
println (New)

if(Default != New)
{
	println ("Success")
}
else(Default == New).call(
	{
		println ("Failed")
	})

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}