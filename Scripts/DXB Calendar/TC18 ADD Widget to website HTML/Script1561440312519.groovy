import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.util.KeywordUtil

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
import org.apache.poi.hssf.record.PageBreakRecord.Break
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import java.nio.file.Paths;
import java.awt.Desktop;
WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)

driver.manage().window().maximize()
selenium.open("https://www.visitdubai.com/en/events#/?type=Leisure")
WebUI.waitForPageLoad(200)
WebUI.click(getElement('css','.events-tiles > div:nth-child(3)'))

WebUI.waitForPageLoad(200)



int widgetStyleCount = driver.findElements(By.cssSelector('.custom-select.widget-dropdown #widgetType > option')).size()//size of widget dropdown
println (widgetStyleCount)
for(int i=0;i<widgetStyleCount;i++){
	
	WebUI.selectOptionByIndex(getElement('css', '.custom-select.widget-dropdown #widgetType'), i)
	WebUI.click(getElement('css', '.sp-replacer.sp-light'))//open color pallete
	Thread.sleep(500)
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement element = driver.findElement(By.className("sp-dragger"));
	Random rand = new Random();// for color palette
	js.executeScript("arguments[0].setAttribute('style', 'top: "+rand.nextInt(124)+"px; left: "+rand.nextInt(124)+"px;')", element);//generate RGB for palette
	WebUI.click(getElement('css', '.sp-dragger'))//drag pallete cursor
	Thread.sleep(500)
	WebUI.click(getElement('css', '.sp-choose'))//click on palette
	Thread.sleep(500)
	
	WebElement element1 = driver.findElement(By.className("sp-preview-inner"));
	String backgroundColor = element1.getCssValue("background-color");//get palette selected value
	println(backgroundColor)
	Thread.sleep(300)
	WebUI.click(getElement('css', '.dc-organisers-register.edit-event .btn-cal-default'))//click on generate code button
	
	Thread.sleep(300)
	String iframecode=driver.findElement(By.id("copyCode")).getAttribute("value");
	println(iframecode)
	
	
	Thread.sleep(300)
	String defaultiframecode=driver.findElement(By.cssSelector(".dc-organisers-register.edit-event #display")).getAttribute("innerHTML").replaceAll("&amp;","&")//get by default generated iframe
	//defaultiframecode;
	println ("pre generated: "+defaultiframecode)
	
	printToTxt(iframecode)
	
	if(defaultiframecode==iframecode){
	println ("----------Test paseed "+i+"***********")
	}
	
}


private void printToTxt(String inp){
	String idForTxtFile = new SimpleDateFormat("dd.MM.yyyy_HH.mm.ss").format(new Date());
	File file = new File("Filename" + idForTxtFile+".html");
	
	try {
	  FileWriter fw = new FileWriter(file, true);
	  fw.write(inp);
	
	  fw.flush();
	  fw.close();
	  if(file.exists()){
		   Desktop.getDesktop().browse(file.toURI());
	  }
	} catch (IOException e) {
	  e.printStackTrace();
	  System.out.println(e.getLocalizedMessage);
	}
}
TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')
	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)
	return newTestObject
}
