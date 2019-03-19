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
import org.openqa.selenium.JavascriptExecutor;

WebUI.openBrowser('https://www.google.com/');
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize();
selenium.open("https://qacd2.testvisitdubai.com/en/account/login?v=78798789")
driver.manage().window().maximize();

String CurrentURL = "https://qacd2.testvisitdubai.com/en/account/login?v=78798789";
String locationNow = selenium.location ;
String CssSelector ="css=.dd-options:first li";
String dropdown ="xpath=(.//*[normalize-space(text()) and normalize-space(.)=";
//selenium.click(dropdown+"'English'])[2]/following::span[1]")

//selenium.click(".dd-selected:first")

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("document.querySelectorAll('.dd-options')[0].classList.add('language-selector-list')");

int languagesLength = driver.findElements(By.cssSelector(".language-selector-list li")).size();

System.out.println('number of languages: '+ languagesLength);

for (int i=1 ; i <= languagesLength ;i++ )
{
	js.executeScript("document.querySelectorAll('body .dd-selected')[0].click()");
	Thread.sleep(200)
	selenium.click(CssSelector+ ":nth-child("+i+") .dd-option")
	Thread.sleep(2000)
}
