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
import org.openqa.selenium.remote.server.handler.FindElement
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.test.GlobalVaribale as GlobalVaribale
import com.test.GlobalVaribale
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
//selenium.open(gv.getWebsitename()+"/en/shop-dine-relax/shopping")
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())
WebUI.waitForPageLoad(2000)

WebUI.click(getElement('css','.meta_nav .meta_nav_wrap > div:nth-child(4)'))//click on font icon to open header
String precolor=driver.findElement(By.cssSelector(".main_nav")).getCssValue("background-color");
println (precolor)
if(precolor=="rgba(255, 255, 255, 1)")
{
	Thread.sleep(500)
	WebUI.click(getElement('css','.accessibility-section > div > div.accessibility-category.color-cont > ul > li:nth-child(2) > label'))//click on blind mode
	Thread.sleep(800)
	String postcolor = WebUI.getCSSValue(getElement("css", ".main_nav"), "background-color")
	println (postcolor)
	Thread.sleep(300)
	if(postcolor=="rgba(0, 0, 0, 1)"){
		println("test passed")
		WebUI.closeBrowser()
	}
	else(postcolor!="rgba(0, 0, 0, 1)")
		{
			KeywordUtil.markFailed('Page color is not changed into greyscale')
		}
	
}


TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')
	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
	return newTestObject
}

//WebUI.closeBrowser()