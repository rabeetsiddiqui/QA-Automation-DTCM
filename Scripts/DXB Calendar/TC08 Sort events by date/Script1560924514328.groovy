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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor


WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename()+"/en/events#/list?type=Leisure&dates=0-0")

WebUI.waitForPageLoad(200)
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('document.querySelectorAll(\'.custom.ng-pristine.ng-valid.ng-touched > option\')')

int TravelDayNavigation = driver.findElements(By.cssSelector('.custom-select.ng-scope #dtcm-date-select > option')).size()
println (TravelDayNavigation)


WebUI.click(getElement('css', '.custom-select.ng-scope #dtcm-date-select '))
WebUI.click(getElement('css', '.heading.inner'))
List eventDates = new ArrayList();

for(int i=0; i <TravelDayNavigation; i++)//till dropdown count
{
	
	
	
	WebUI.selectOptionByIndex(getElement('css','.custom-select.ng-scope #dtcm-date-select '), i)//select drop down by click
	Thread.sleep(500);
	WebUI.waitForElementVisible(getElement('css','.delimiter_v9'), 10)//waiting for load
	Thread.sleep(3500);
	
	int count = driver.findElements(By.cssSelector('.delimiter_v9 .events-wrapper.events-wrapper-new.ng-scope')).size()//event size in first dd click
	println (count)
	Thread.sleep(500)
	if(i == TravelDayNavigation -1)
	{
		Thread.sleep(1000)
		println ("--------************---------")
		datePickerTest();
		datePickerReturn()
//		WebUI.click(getElement("css", ".trip-calendar-buttons .calendar-search-now"))
		Thread.sleep(500)
		WebUI.click(getElement("css", ".trip-calendar-buttons .calendar-search-now"))
		
	}
	for(int x=0;x<count;x++){
		
		Thread.sleep(500)
		String a='//*[@id="event'+x+'"]/ul/li[2]/div[1]';
		Thread.sleep(500)
		String list = WebUI.getText(getElement('xpath', a))
		Thread.sleep(500)
		println(list)
		String xyz=list.substring(0, 6).replaceAll("\\s+","");				
		eventDates[x]=xyz;

	}

	List<Date> eventList =new ArrayList<Date>();
	List<Date> eventList1 =new ArrayList<Date>();
	for (Iterator<String> it = eventDates.iterator(); it.hasNext();){
		String f = it.next();
		String month = f.substring(0, 3);
		String day = f.substring(3, 5);
		String dateString= day+"/"+month+"/"+"2019";
		Date date1=new SimpleDateFormat("dd/MMM/yyyy").parse(dateString);
		eventList.add(date1);
		eventList1.add(date1);
		Collections.sort(eventList1, new Comparator<Date>(){
			
					   @Override
					   public int compare(Date o1, Date o2) {
						   return o1.compareTo(o2);
					   }
				   });
		
		
	}
	if(eventList.equals(eventList1))
	{
		println("****Test Case passed "+i+"*****")
	}
	
	
}


//Get Cuurent date and click on next 4 day


public void datePickerTest() {
	def drivers = DriverFactory.getWebDriver()
	
        //Get Today's number
        String today = getCurrentDay(1);
        System.out.println("Today's number: " + today + "\n");
		
        //Click and open the datepickers
//		drivers.findElement(By.cssSelector(".booking_dates > label:nth-child(1) .calendar_wrap"))             
		
        //This is from date picker table
		Thread.sleep(1700)
		WebElement dateWidgetFrom = drivers.findElement(By.cssSelector(".datepicker.calendar-page-datepicker .ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all .ui-datepicker-calendar > tbody"))
        //This are the rows of the from date picker table
        //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
 
        //This are the columns of the from date picker table
        List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
 
        //DatePicker is a table. Thus we can navigate to each cell
        //and if a cell matches with the current date then we will click it.
        for (WebElement cell: columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
            if (cell.getText().equals(today)) {
				Thread.sleep(1700)
				  cell.click();
				
                break;
            }
        }
 
        //Wait for 4 Seconds to see Today's date selected.
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


public void datePickerReturn() {
def drivers = DriverFactory.getWebDriver()

	//Get Today's number
	String today = getCurrentDay(4);
	System.out.println("Today's number: " + today + "\n");
	
	//Click and open the datepickers
	
	//This is from date picker table
	Thread.sleep(700)
		WebElement dateWidgetFrom = drivers.findElement(By.cssSelector(".datepicker.calendar-page-datepicker .ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all .ui-datepicker-calendar > tbody"))
	//This are the rows of the from date picker table
	//List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

	//This are the columns of the from date picker table
	List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

	//DatePicker is a table. Thus we can navigate to each cell
	//and if a cell matches with the current date then we will click it.
	for (WebElement cell: columns) {
		println(cell)
		//Select Today's Date
		if (cell.getText().equals(today)) {
			cell.click();
			break;
		}
	}
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

private String getCurrentDay (int day){
	//Create a Calendar Object
	Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

	//Get Current Day as a number
	int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
	todayInt += day;
	System.out.println("Today Int: " + todayInt+"\n");

	//Integer to String Conversion
	String todayStr = Integer.toString(todayInt);
	System.out.println("Today Str: " + todayStr + "\n");

	return todayStr;
}


TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}
