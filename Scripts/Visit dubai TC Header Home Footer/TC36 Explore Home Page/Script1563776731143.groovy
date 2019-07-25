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
import org.openqa.selenium.Point;
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
//selenium.open(gv.getWebsitename()+"/en/shop-dine-relax/shopping")
selenium.open("https://www.visitdubai.com/en/");
WebUI.waitForPageLoad(2000)

//for 
WebElement leftStickyElement = driver.findElement(By.cssSelector(".sub_menu"));
Point prepointside = leftStickyElement.getLocation();
int initialxcord = prepointside.getX();//initial value before scroll x-axis
println (initialxcord)
int initialycord = prepointside.getY(); //initial value before scroll y-axis
System.out.println("Element's Position from top side Is "+initialycord +" pixels.");


//for header
WebElement headerStickyElement = driver.findElement(By.cssSelector(".main_nav"));
Point preheaderpointside = headerStickyElement.getLocation();
int initialheaderxcord = preheaderpointside.getX();
println (initialheaderxcord)
int initialheaderycord = preheaderpointside.getY();
System.out.println("Element's Position from top side Is "+initialheaderycord +" pixels.");

Thread.sleep(500)
WebElement element = driver.findElement(By.cssSelector("#divHomeWrap > div > div.dubai.font > div.panels > div > div:nth-child(10)"));
((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView();", element);
Point postpoint = leftStickyElement.getLocation();
int postxcord = postpoint.getX();
println ("after"+postxcord)
int postycord = postpoint.getY();
System.out.println("Element's Position from top side Is "+postycord +" pixels.");
		



Point postheaderpoint = headerStickyElement.getLocation();
int postheaderxcord = postheaderpoint.getX();
println ("after"+postheaderxcord)
int postheaderycord = postheaderpoint.getY();
System.out.println("Element's Position from top side Is "+postheaderycord +" pixels.");

if(initialxcord == postxcord && initialycord < postycord  && initialheaderxcord==postheaderxcord && initialheaderycord < postheaderycord){
	println ("*******Test Passed **************")
}
		
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')
	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
	return newTestObject
}