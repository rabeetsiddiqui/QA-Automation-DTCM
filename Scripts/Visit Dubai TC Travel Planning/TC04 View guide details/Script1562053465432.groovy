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
selenium.open(gv.getWebsitename())
WebUI.waitForPageLoad(20000)
String BackgroundColorPink = "rgba(194, 44, 145, 1)"

selenium.click("css=.homepage_section .mobile_nav .main-nav .nav-section > li:nth-child(5)")
WebUI.waitForPageLoad(20000)

String Colorcode  = driver.findElement(By.cssSelector('.homepage_section .mobile_nav .main-nav .nav-section > li:nth-child(5) > a')).getCssValue("color");
System.out.println(Colorcode);
if(Colorcode == BackgroundColorPink  && Colorcode != BackgroundColorPink == false)
{
	System.out.println('Font color is Pink')
}
else{
	KeywordUtil.markFailed('Font color is not changed')
}

WebUI.waitForPageLoad(20000)
Thread.sleep(500);

WebUI.click(getElement("xpath","//*[@id='bussiness-newslettermodal']/div[1]/button"))
WebUI.mouseOver(getElement('css', '#dubaiessentials > div > div > div:nth-child(3) > a > div.article_image > h5'))
Thread.sleep(300);
WebUI.click(getElement('css', '#dubaiessentials > div > div > div:nth-child(3) > a > div.article_image > h5'))
WebUI.waitForPageLoad(20000)

Thread.sleep(1500);
WebUI.scrollToElement(getElement('css', '#rock_menu > ul > li:nth-child(13) > a'), 05)
Thread.sleep(1500);
WebUI.click(getElement('css', '#rock_menu > ul > li:nth-child(13) > a'))


 
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}