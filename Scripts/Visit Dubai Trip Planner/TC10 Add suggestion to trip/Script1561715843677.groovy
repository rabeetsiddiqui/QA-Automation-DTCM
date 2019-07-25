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
import javax.persistence.Convert as Convert
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Calendar as Calendar
import java.util.Date as Date
import org.apache.commons.lang.time.DateUtils as DateUtils
import org.apache.xmlbeans.impl.store.Locale.domNthCache
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

import java.util.concurrent.ThreadFactory
import java.util.concurrent.TimeUnit as TimeUnit
import org.openqa.selenium.support.ui.WebDriverWait as WebDriverWait
import org.openqa.selenium.support.ui.ExpectedConditions as ExpectedConditions


WebUI.openBrowser('https://www.google.com/')

def driver = DriverFactory.getWebDriver()
String baseUrl = 'https://www.google.com/'
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
selenium.open('https://www.visitdubai.com/en') //home page

WebUI.waitForPageLoad(200)
WebUI.click(getElement('css', '#tripPlannerIcon')) // click on trip planner icon on home page
   
WebUI.waitForPageLoad(200)

WebUI.click(getElement('css', '.tp_btn-sign-in.ng-binding.home-tp-btn > a'))// click on sign in
	
WebDriverWait wait = new WebDriverWait(driver, 40);
//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".signup_nav_wrap.account-login-new .google")))

for(i=0; i<5; i++)
{

	WebUI.click(getElement('css', '.signup_nav_wrap.account-login-new .google'))// click on google to sign in option
	WebUI.waitForPageLoad(2000)
	Thread.sleep(1500)
	
	if(driver.findElements(By.id("identifierId")).size() != 0)
	{
		
		break;
	}

}

WebUI.waitForPageLoad(200)

WebUI.setText(getElement('css',"#identifierId" ), 'testovrlod123@gmail.com');
WebUI.waitForPageLoad(200)
driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();

wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=password]")));
//Thread.sleep(3000)
//WebUI.waitForPageLoad(200)
WebUI.setText(getElement('css',".Xb9hP .whsOnd.zHQkBf" ), 'ovrlod_321321');


driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
//Thread.sleep(3000)
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".you-may-also-like-container")));

if(driver.findElements(By.cssSelector(".you-may-also-like-container > div")).size()>=2)
{
	println ("-----Test case passed*******")
}



TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}