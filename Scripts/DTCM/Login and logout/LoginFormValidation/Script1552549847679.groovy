
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

WebUI.openBrowser('https://www.visitdubai.com/en/account/login')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.visitdubai.com/en/account/login"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize();

												// Empty Email Empty password


//Thread.sleep(2500)
//selenium.click("id=plhcontent_0_lbtnSubmit")
//Thread.sleep(2000)
//String emailFieldErrorDisplay = driver.findElement(By.id("plhcontent_0_rfvEmail")).getCssValue("display");
//String passFieldErrorDisplay = driver.findElement(By.id("plhcontent_0_rfvPassword")).getCssValue("display");
//
//if(emailFieldErrorDisplay != "none" || passFieldErrorDisplay != "none"){
//	System.out.println("Test Case is Passed");
//}else{
//	System.out.println("Test Case is Failed");
//}

												//Valid Email empty Password

Thread.sleep(2500)
selenium.type("id=tbUsername", "muhammad.saad@ovrlod.com")
Thread.sleep(2000)

selenium.click("id=plhcontent_0_lbtnSubmit")

String emailFieldErrorDisplay = driver.findElement(By.id("plhcontent_0_rfvEmail")).getCssValue("display");
String passFieldErrorDisplay = driver.findElement(By.id("plhcontent_0_rfvPassword")).getCssValue("display");

if(passFieldErrorDisplay != "none"){
	System.out.println("Test Case is Passed");
}else{
	System.out.println("Test Case is Failed");
}



												// empty email Valid password


//Thread.sleep(2000)
//selenium.type("id=tbPassword", "Qwerty#1")
//Thread.sleep(2000)

//selenium.click("id=plhcontent_0_lbtnSubmit")
//
//
//String emailFieldErrorDisplay = driver.findElement(By.id("plhcontent_0_rfvEmail")).getCssValue("display");
//String passFieldErrorDisplay = driver.findElement(By.id("plhcontent_0_rfvPassword")).getCssValue("display");
//
//if(emailFieldErrorDisplay != "none"){
//	System.out.println("Test Case is Passed");
//}else{
//	System.out.println("Test Case is Failed");
//}

