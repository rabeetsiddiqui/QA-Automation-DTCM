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
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename()+"/en/shop-dine-relax/shopping")

//after landing on shopping page Closing Newsletter Component to scroll
WebUI.click(getElement('css', '.modal-content.business-modal.visitdubai-modal .modal-header .close.b-close'))
WebUI.scrollToElement(getElement('css','.vdf-col-right .sidebar-dynamic-img .banner-slide-wrap.slick-initialized.slick-slider .slick-dots .aaa-right-pause.aaa-right-control'), 150)

//Click on Itineraries 
WebUI.click(getElement('css','.dropdown_filter .sub_cat_filters.nav.nav-tabs > a:nth-child(2)'))
Thread.sleep(500)
String Default= WebUI.getUrl()
println (Default)

//Click on Detail Itineray
Thread.sleep(1500)
WebUI.mouseOver(getElement('css', '.tab-content .tab-pane.active .dsf_shop_cat_deals > li:nth-child(2) .dsf_shop_cat_deals_info'))
Thread.sleep(1000)
WebUI.click(getElement('css', '.tab-content .tab-pane.active .dsf_shop_cat_deals > li:nth-child(2) .dsf_shop_cat_deals_info > a:nth-child(2)'))
Thread.sleep(1000)
String New= WebUI.getUrl()
println (New)

if(Default != New && Default == New == false)
{
	println ("Success")
}
else
	{
		KeywordUtil.markFailed('Failed')
	}

Thread.sleep(1000);
WebUI.scrollToElement(getElement('css','#plhcontent_0_repeaterPanels_pnlCell2_0 > div > div.cms > div.chip_content'), 10)

//Click on View on Map
Thread.sleep(1000);
WebUI.click(getElement('css','.panel .desc .btn.print.viewmap.itinerary_btn'))
//WebUI.click(getElement('xpath', '//*[@id="divHomeWrap"]/div/div[3]/div[1]/div[2]/div/div/div[3]/div[1]/a[2]'))
Thread.sleep(1000)

//Verify Text present on map to check is it open or not
WebUI.verifyTextPresent("Satellite", false)
Thread.sleep(3000)
WebUI.click(getElement('css', '.lightbox.lightboxMap.video-contains .lb-dataContainer.top-text.font_55 .lb-close.r-arrow.aaa-screenreader-hidden-Text'))

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}

WebUI.closeBrowser()