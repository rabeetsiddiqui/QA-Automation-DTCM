import com.kms.katalon.core.testobject.TestObject

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
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

WebUI.openBrowser('https://www.katalon.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.katalon.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
selenium.open("https://www.visitdubai.com/en")
selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='Skip to main content'])[1]/following::a[1]")
selenium.click("id=tbUsername")
selenium.type("id=tbUsername", "rabeet.siddiqui08@gmail.com")
selenium.click("id=tbPassword")
selenium.type("id=tbPassword", "Ovrlod@12345")
//selenium.selectFrame("index=3")
//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='reCAPTCHA'])[1]/preceding::div[8]")
//selenium.selectFrame("relative=parent")
//selenium.selectFrame("index=4")
//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='store front'])[1]/following::img[3]")
//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='store front'])[1]/following::img[8]")
//selenium.click("id=recaptcha-verify-button")
//selenium.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='store front'])[1]/following::img[4]")
//selenium.click("id=recaptcha-verify-button")
//selenium.selectFrame("relative=parent")
//selenium.click("id=plhcontent_0_lbtnSubmit")
//selenium.click("id=btnLogout")

String Verify =  WebUI.verifyElementPresent(getElement('css', '#recaptcha1 > div > div > iframe'), 0)
println (Verify) 
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}

