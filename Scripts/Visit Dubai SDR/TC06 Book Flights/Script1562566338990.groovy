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
WebUI.click(getElement('css', '.modal-content.business-modal.visitdubai-modal .modal-header .close.b-close'))
Thread.sleep(500)

WebUI.setText(getElement('css',"#flightFrom" ), 'Chica')
//go, United States (CHIA)
WebUI.click(getElement('css', '.ui-autocomplete.ui-front.ui-menu > li:nth-child(1) > a > span'))
WebUI.focus(getElement('css', '.booking_wrapper > div:nth-child(1) > a.active'))

WebUI.scrollToElement(getElement('css','.vdf-col-right .sidebar-dynamic-img .banner-slide-wrap.slick-initialized.slick-slider .slick-dots .aaa-right-pause.aaa-right-control'), 150)
Thread.sleep(500)
selenium.click('id=travellersCabinField')
Thread.sleep(500)
WebUI.click(getElement('css', '.booking_wrapper .tab-content.active .booking_controls_wrap.active.in .travellers_cabin_field .travellers_cabin_value'))
Thread.sleep(500)
WebUI.click(getElement('css', '#flights > div.traveller_cabin_info_popup.on > div.dd-slick-wrapper .dd-select .dd-selected-text'));
Thread.sleep(500)
WebUI.click(getElement('css', '#flights > div.traveller_cabin_info_popup.on > div.dd-slick-wrapper > div > ul > li:nth-child(2) > a'))
Thread.sleep(1500)
selenium.click('id=travel-and-cabin-adult-passenger-increment')
Thread.sleep(500)
selenium.click('id=travel-and-cabin-children-passenger-increment')
Thread.sleep(500)
WebUI.click(getElement('css', '.childAges .childNode.active.in .dd-slick-wrapper .dd-container .dd-select .dd-selected .dd-selected-text'))
Thread.sleep(500)
WebUI.click(getElement('css', '#childDiv-0 .dd-options > li:nth-child(3) > a'))
Thread.sleep(500)
selenium.click('css=.button_done')
Thread.sleep(1500)
//WebUI.click(getElement('css', '#flights > div.booking_controls_wrap.active.in > div.booking_dates > label:nth-child(1)'))
WebUI.click(getElement('css', '#flights .booking_dates > label:nth-child(1)'))
public void datePickerTest() {
    def drivers = DriverFactory.getWebDriver()
    
        //Get Today's number
        String today = getCurrentDay(1);
        System.out.println("Today's number: " + today + "\n");
        
        //Click and open the datepickers
        drivers.findElement(By.cssSelector(".booking_dates > label:nth-child(1) .calendar_wrap"))
        
        //This is from date picker table
        Thread.sleep(700)
		if(Integer.parseInt(today) > 27){
			WebUI.click(getElement('css',"#ui-datepicker-div > div > a.ui-datepicker-next.ui-corner-all"))
			today=1
		}
        WebElement dateWidgetFrom = drivers.findElement(By.cssSelector(".ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all .ui-datepicker-calendar > tbody"))
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
    drivers.findElement(By.cssSelector(".booking_dates > label:nth-child(1) .calendar_wrap"))
    
    //This is from date picker table
    Thread.sleep(700)
	if(Integer.parseInt(today) > 27){
		//WebUI.click(getElement('css',"#ui-datepicker-div > div > a.ui-datepicker-next.ui-corner-all"))
		today=Integer.parseInt(today)-27
	}
    WebElement dateWidgetFrom = drivers.findElement(By.cssSelector(".ui-datepicker.ui-widget.ui-widget-content.ui-helper-clearfix.ui-corner-all .ui-datepicker-calendar > tbody"))
    //This are the rows of the from date picker table
    //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
    //This are the columns of the from date picker table
    List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
    //DatePicker is a table. Thus we can navigate to each cell
    //and if a cell matches with the current date then we will click it.
    for (WebElement cell: columns) {
        
        //Select Today's Date
        if (cell.getText().equals(today)) {
            println (cell)
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
datePickerTest();
datePickerReturn()
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
//Search Button
Thread.sleep(1000)
WebUI.click(getElement('css', '.booking_wrapper .tab-content.active .booking_button'));
TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')
    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
    return newTestObject
}