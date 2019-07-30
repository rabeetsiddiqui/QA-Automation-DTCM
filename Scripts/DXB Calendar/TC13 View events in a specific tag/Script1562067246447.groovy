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

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
selenium.open("https://www.visitdubai.com/en/events#/?type=Leisure")
WebUI.waitForPageLoad(200)

List<WebElement> filterElement = driver.findElements(By.cssSelector(".ng-scope .search-filter-dsf > a"));
int filterCount = filterElement.size();
//int filterCount = WebUI.getText(getElement('css', '.ng-scope .search-filter-dsf > a')).size()//get filter size

println (filterCount)
for(int i=1;i<=filterCount;i++){
	int match=0;
	if(i==2){
		continue;
	}
	String category= WebUI.getText(getElement('css', '.ng-scope .search-filter-dsf > a:nth-child('+i+')'))//get filter category
	Thread.sleep(500)
	WebUI.click(getElement('css','.ng-scope .search-filter-dsf > a:nth-child('+i+')'))// click on filter
	WebUI.waitForPageLoad(2000)
	Thread.sleep(1500)
	List<WebElement> itemElement = driver.findElements(By.cssSelector(".delimiter_v9 > div"));
	int itemCount = itemElement.size();
	println("item count----"+itemCount)
	
	for(int j=0;j<itemCount;j++){
		Thread.sleep(1500)
		List<WebElement> tagElement = driver.findElements(By.cssSelector("#event"+j+" > ul > li.trip_detail.main_cell.valign-top > div.trip_copy.font_24 > div > div"));
		int tagCount = tagElement.size();
		for(int y=1;y<=tagCount;y++){
			Thread.sleep(1500)			
			String tag=WebUI.getText(getElement('css', '#event'+j+' > ul > li.trip_detail.main_cell.valign-top > div.trip_copy.font_24 > div > div:nth-child('+y+')')).toLowerCase();
			if(tag.contains(category.toLowerCase()))
			{
				match++;
				break;
			}			
		}		
		
	}
	
	if(match==itemCount){
	println ("passed******"+category)
	selenium.open("https://www.visitdubai.com/en/events#/?type=Leisure")
	WebUI.waitForPageLoad(200)
	}
		
}
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')
	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
	return newTestObject
}