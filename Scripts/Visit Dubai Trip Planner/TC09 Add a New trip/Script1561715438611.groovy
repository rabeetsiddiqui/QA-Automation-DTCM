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
driver.findElement(By.cssSelector("#identifierNext > span")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type=password]")));

WebUI.setText(getElement('css',".Xb9hP .whsOnd.zHQkBf" ), 'ovrlod_321321');


driver.findElement(By.cssSelector("#passwordNext > span > span")).click();

WebUI.waitForPageLoad(200)
Thread.sleep(1500)
//wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".tp_btn-add-activities.ng-binding.new-design")));
WebUI.mouseOver(getElement('css', '.tp_btn-add-activities.ng-binding.new-design > div'))//mouse hover on change trip
Thread.sleep(500)
WebUI.click(getElement('css', '.tp_btn-add-activities.ng-binding.new-design > div'))//click on change trip
wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#mytrips-view .tp_change-trip-items")));
int tripCount = driver.findElements(By.cssSelector('#mytrips-view .tp_change-trip-items > li')).size()//total trips in trip planner
String DefaultText =WebUI.getText(getElement('css', '.font_19.my-trip-title.ng-binding'))//get the pre selected trip title
if(tripCount==10){
	println ("inside 10 count")
	for(int i=1;i<=2;i++){
		WebElement temp = driver.findElement(By.cssSelector(".tp_change-trip-items > li:nth-child("+i+") > div"));
		if(elementHasClass(temp, "tp_change-trip-box-active")==false)
		{
			Thread.sleep(500)
			WebUI.click(getElement('css', '.tp_change-trip-items > li:nth-child('+i+') .tp_change-trip-box-trash'))//click on delete item
			Thread.sleep(500)	
			WebUI.click(getElement('css', '.ui-dialog-buttonset > button:nth-child(1)'))//click on YES to delete the trip
			WebUI.click(getElement('css', '#mytrips-view .tp-add-new-button'))//click to add new event
			String NewText =WebUI.getText(getElement('css', '.font_19.my-trip-title.ng-binding'))
			WebUI.click(getElement('css', '#tp_add-activities-close'))
			if(DefaultText!=NewText){
				println ("************ Test passed *********")
				break;
			}
			
		}
	}
}
else{
	for(int i=1;i<=2;i++){
		Thread.sleep(500)
		WebElement temp = driver.findElement(By.cssSelector(".tp_change-trip-items > li:nth-child("+i+") > div"));
		if(elementHasClass(temp, "tp_change-trip-box-active")==false)
		{	
			WebUI.click(getElement('css', '.tp_change-trip-items > li:nth-child('+i+') > div'))
			Thread.sleep(500)
			String NewText =WebUI.getText(getElement('css', '.font_19.my-trip-title.ng-binding'))
			WebUI.click(getElement('css', '#tp_add-activities-close'))
			if(DefaultText!=NewText){
				println ("************ Test passed *********")
				break;
			}
			
		}
	}
}


public boolean elementHasClass(WebElement element, String active) {
	return element.getAttribute("class").contains(active);
}

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}