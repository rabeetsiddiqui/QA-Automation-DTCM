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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename()+"/en/shop-dine-relax/shopping")

WebUI.click(getElement('css', '#bussiness-newslettermodal > div.modal-header > button'))
Thread.sleep(500)
WebUI.scrollToElement(getElement('css','#right-slider-icon'), 150)
Thread.sleep(500)
selenium.click('id=travellersCabinField')
Thread.sleep(500)
WebUI.click(getElement('css', '#flights > div.traveller_cabin_info_popup.on > div.dd-slick-wrapper > div > div > a'))
Thread.sleep(500)
WebUI.click(getElement('css', '#flights > div.traveller_cabin_info_popup.on > div.dd-slick-wrapper > div > ul > li:nth-child(2) > a'))
Thread.sleep(500)
selenium.click('id=travel-and-cabin-adult-passenger-increment')
Thread.sleep(500)
selenium.click('id=travel-and-cabin-children-passenger-increment')
Thread.sleep(500)
WebUI.click(getElement('css', '#childDiv-0 > div > div > div > a > label'))
Thread.sleep(500)
WebUI.click(getElement('css', '#childDiv-0 > div > div > ul > li:nth-child(3) > a'))
selenium.click('css=.button_done')
Thread.sleep(1500)
WebUI.click(getElement('css', '#flights > div.booking_controls_wrap.active.in > div.booking_dates > label:nth-child(1)'))

// Create object of SimpleDateFormat class and decide the format
DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
//get current date time with Date()
Date date = new Date();
// Now format the date
String date1= dateFormat.format(date);
// Print the Date
System.out.println(date1);

//for(int i =1 ; i=date1 ; i++)
//{
//	selenium.click('css=. ui-datepicker-days-cell-over.ui-datepicker-today'+ 'nth-child('+ i + ')')
//}

public static Date addDays(Date date, int days)
{
	Calendar cal = Calendar.getInstance();
	cal.setTime(date);
	cal.add(Calendar.DATE, days); //minus number would decrement the days
	return cal.getTime();
}
Calendar calendar = Calendar.getInstance();
calendar.setTime(new Date());
calendar.add(Calendar.DATE,1);
System.out.println(calendar.getTime());

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}

