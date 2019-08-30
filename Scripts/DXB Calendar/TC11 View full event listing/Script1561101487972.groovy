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

import javax.persistence.Convert

import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable as GlobalVariable
import com.test.GlobalVaribale
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
selenium.open("https://www.visitdubai.com/en/events#/?type=Leisure")
WebUI.waitForPageLoad(200)

WebUI.click(getElement('css','.events-dsf.ng-scope .heading .heading-link')) //click on view all events
WebUI.waitForPageLoad(1000)
Thread.sleep(2500)

//WebElement TxtBoxContent = driver.findElement(By.cssSelector(".heading.inner > small")).size();
String TxtBoxContent = WebUI.getText(getElement('css', '.heading.inner > small')).toString()
println (TxtBoxContent)

Thread.sleep(2000)
int EventCount=Integer.parseInt(TxtBoxContent.replaceAll("\\D+",""));
println(EventCount)

List<WebElement> pagecount = driver.findElements(By.cssSelector(".search-result-page.search-result-page-new >div >ul >li"));//page list count
int eventsinpagecount = driver.findElements(By.cssSelector('.delimiter_v9 .events-wrapper.events-wrapper-new.ng-scope')).size()
println("Page div count = "+eventsinpagecount)
for(int i=2; i<=pagecount.size();i++)
{
	driver.findElement(By.cssSelector(".search-result-page.search-result-page-new >div >ul >li:nth-child("+i+")")).click();
	Thread.sleep(1000)
	int tempCount= driver.findElements(By.cssSelector('.delimiter_v9 .events-wrapper.events-wrapper-new.ng-scope')).size()
	eventsinpagecount +=tempCount
	println("Page div count = "+tempCount)
}
println("--------------count"+eventsinpagecount);

if(EventCount==eventsinpagecount){
	println ("-----*****TEst passed****----")
}
else(EventCount!=eventsinpagecount)(
	{
		KeywordUtil.markFailed('Failed')
	}
	)

WebUI.closeBrowser();
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')
	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
	return newTestObject
}