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

selenium = new WebDriverBackedSelenium(driver, baseUrl)

driver.manage().window().maximize()

GlobalVaribale gv = new GlobalVaribale()

selenium.open(gv.getWebsitename())

String BackgroundColorPink = 'rgba(194, 44, 145, 1)'

//hover on Shopping Dine Relax
WebUI.mouseOver(getElement('css', '.homepage_section .mobile_nav .main-nav .nav-section > li:nth-child(3)'))

Thread.sleep(1000)

//Expand Shopping Under Shopping Dine Relax
WebUI.click(getElement('css', '.mobile_nav .main-nav .nav-section > li:nth-child(3) > ul > li:nth-child(3)'))
Thread.sleep(700)

//Click on any of the Item Under Shopping
WebUI.click(getElement('css', '.mobile_nav .main-nav .nav-section > li:nth-child(3) > ul > li:nth-child(3) .sub-level.hidden > li:nth-child(3)'))
Thread.sleep(700)

WebUI.click(getElement('css', '.modal-content.business-modal.visitdubai-modal .modal-header .close.b-close'))
Thread.sleep(700)
WebUI.scrollToElement(getElement('css', '.vdf-col-right .slick-track'), 16)
Thread.sleep(700)

WebUI.click(findTestObject('Object Repository/Visit Dubai SDR/TC04 FeaturedVideo Button'))


int width = WebUI.getCSSValue(findTestObject('Object Repository/Visit Dubai SDR/TC04 width'), "width")
println (width)
int height = WebUI.getCSSValue(findTestObject('Object Repository/Visit Dubai SDR/TC04 height'), "height")
println(height)


TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')
    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
    return newTestObject
}

