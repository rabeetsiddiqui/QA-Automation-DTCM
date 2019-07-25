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
import org.openqa.selenium.By as By
import org.openqa.selenium.interactions.Action as Action
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.openBrowser('https://www.google.com/')

def driver = DriverFactory.getWebDriver()

String baseUrl = 'https://www.google.com/'

selenium = new WebDriverBackedSelenium(driver, baseUrl)

driver.manage().window().maximize()

selenium.open('https://www.visitdubai.com/en')

//
////To redirect on Facebook Page
//String Facebook = "https://www.facebook.com/visitdubai";
//
//WebUI.click(getElement("xpath","//*[@id='bussiness-newslettermodal']/div[1]/button"))
//WebUI.scrollToElement(getElement("xpath", "//*[@id='ctl18_divSocial']/a[2]"), 15)
//WebUI.click(getElement("xpath", "//*[@id='ctl18_divSocial']/a[2]"))
//
//ArrayList tabs = new ArrayList (driver.getWindowHandles());
//System.out.println(tabs.size());
//driver.switchTo().window(tabs.get(1));
//
//String CurrentUrl = WebUI.getUrl()
//println(CurrentUrl);
//
//if(CurrentUrl == Facebook)
//{
//	println("Success")
//}
//else(CurrentUrl != Facebook).call(
//{
//	println("Failed")
//})


//To redirect on YouTube to run this please comment above Facebook Session
String YouTube = "https://www.youtube.com/visitdubai";

//WebUI.click(getElement("xpath","//*[@id='bussiness-newslettermodal']/div[1]/button"))
Thread.sleep(500)
WebUI.scrollToElement(getElement("css", ".footer-social.container > a:nth-child(3)"), 15)
Thread.sleep(500)
WebUI.click(getElement("css", ".footer-social.container > a:nth-child(3)"))
Thread.sleep(500)
ArrayList tabs = new ArrayList (driver.getWindowHandles());
System.out.println(tabs.size());
driver.switchTo().window(tabs.get(1));

String CurrentUrl = WebUI.getUrl()
println(CurrentUrl);

if(CurrentUrl == YouTube)
{
	println("Success")
}
else(CurrentUrl != YouTube).call(
{
	println("Failed")
})




TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

