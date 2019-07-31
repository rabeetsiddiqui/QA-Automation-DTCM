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
String baseUrl = 'https://www.google.com/'
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
//selenium.open('https://www.visitdubai.com')
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename() + "/en/events#/?type=Leisure")

WebUI.waitForPageLoad(200)
Thread.sleep(500)
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('window.scrollBy(0,1000)')
Thread.sleep(500)
WebUI.click(getElement('css', '.events-tiles > div:nth-child(3)'))
WebElement newsletterElement = driver.findElement(By.cssSelector(".newsletter-container"));
String newsletter= newsletterElement.getAttribute("style")
Thread.sleep(500)
if(newsletter.contains("display: block;"))
{
    WebUI.setText(getElement('css', '.newsletter-container #txt-email'), getSaltString()+'@gmail.com')
    //WebUI.setText(getElement('css', '.newsletter-container #txt-email'), 'tim@gmail.com')
    Thread.sleep(500)
    WebUI.click(getElement("css", ".checkbox-cont .checkbox:first-child > fieldset:nth-child(1) > label"))
    WebUI.click(getElement("css", ".checkbox-cont .checkbox:first-child > fieldset:nth-child(3) > label"))
    WebUI.click(getElement("css", ".newsletter-container .btn-cal-default"))
    WebUI.closeBrowser();
    
}
protected String getSaltString() {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < 10) { // length of the random string.
        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
        salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;
}
TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')
    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
    return newTestObject
}
