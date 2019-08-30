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
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.kms.katalon.core.testobject.ConditionType as ConditionType


import org.openqa.selenium.JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory
import com.test.GlobalVaribale

WebUI.openBrowser('https://www.google.com/');

def driver = DriverFactory.getWebDriver()
String base = driver.getWindowHandle();
String StartPoint = "https://www.google.com/"
String email = "muhammad.saad@ovrlod.com";
selenium = new WebDriverBackedSelenium(driver, StartPoint)
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename() + "/en/account/login")

//selenium.open("https://qacd2.testvisitdubai.com/en/account/login?v=78798789");
Thread.sleep(5000);
selenium.click("link=exact:Forgot login info?")
selenium.click("id=txtResetPasswordEmail")
selenium.type("id=txtResetPasswordEmail", email)
selenium.click("id=resetpassworddiv");
selenium.click("id=plhcontent_0_btnSendAccountReset")
Thread.sleep(20000)


// Open new tab and concatinantion of email in the URL
JavascriptExecutor js = ((driver) as JavascriptExecutor)
Thread.sleep(500);
String CreateAccountUrl = gv.getWebsitename() + '/en/account/create-account?UT=' + email;
String command = "window.open('" + CreateAccountUrl + "');";
System.out.println(command);
js.executeScript(command)

Thread.sleep(3000);
//Getting token from the cuurent account page and printing in the token id field in forget password page
ArrayList tabs = new ArrayList (driver.getWindowHandles());
System.out.println(tabs.size());
driver.switchTo().window(tabs.get(1));

Thread.sleep(5000);
WebElement ParentElement = driver.findElement(By.id("divHomeWrap"))
String htmlstring = ParentElement.getText();
System.out.println(htmlstring);
List ChildList = ParentElement.findElements(By.tagName("h2"))
WebElement otp = ChildList.get(0)
String value = otp.getText();
System.out.println(value);
Thread.sleep(2500);
driver.switchTo().window(base);
selenium.click("id=txtToken")
selenium.type("id=txtToken", value)
selenium.click("id=plhcontent_0_btnVerifyToken")
Thread.sleep(2500);
selenium.click("id=password")
Thread.sleep(500);
selenium.type("id=password", "Qwerty#1")
selenium.click("id=confirmPassword")
Thread.sleep(500);
selenium.type("id=confirmPassword", "Qwerty#1")
selenium.click("id=plhcontent_0_lbtnSubmit")
Thread.sleep(2500);
	
//WebUI.closeBrowser()


