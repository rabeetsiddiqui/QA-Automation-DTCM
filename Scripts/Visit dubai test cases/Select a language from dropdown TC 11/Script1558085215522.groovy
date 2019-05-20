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
import com.kms.katalon.core.webui.keyword.builtin.VerifyTextPresentKeyword as VerifyTextPresentKeyword
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty as SystemProperty
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import java.util.List as List
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.openBrowser('https://www.google.com/')

def driver = DriverFactory.getWebDriver()

String baseUrl = 'https://www.google.com/'

selenium = new WebDriverBackedSelenium(driver, baseUrl)

driver.manage().window().maximize()

//selenium.open("https://qacd2.testvisitdubai.com/en/account/login?v=78798789")
selenium.open('https://www.visitdubai.com/')

driver.manage().window().maximize()

String CurrentURL = 'https://qacd2.testvisitdubai.com/en/account/login?v=78798789'

String locationNow = selenium.location

String CssSelector = 'css=.dd-options:first li'

String dropdown = 'xpath=(.//*[normalize-space(text()) and normalize-space(.)='

//selenium.click(dropdown+"'English'])[2]/following::span[1]")
//selenium.click(".dd-selected:first")
JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('document.querySelectorAll(\'.dd-options\')[0].classList.add(\'language-selector-list\')')

//System.out.println("document.getElementById('plhcontent_0_PanelsRepeater_PanelsChipPanel_0_headTitleH1_0')");
int languagesLength = driver.findElements(By.cssSelector('.language-selector-list li')).size()

System.out.println('number of languages: ' + languagesLength)

//String Tittles= driver.findElement(By.id('#plhcontent_0_PanelsRepeater_PanelsChipPanel_0_headTitleH1_0'));
for (int i = 1; i <= languagesLength; i++) {
    js.executeScript('document.querySelectorAll(\'body .dd-selected\')[0].click()')

    Thread.sleep(200)

    selenium.click(((CssSelector + ':nth-child(') + i) + ') .dd-option')

    Thread.sleep(2000)

    //    title = WebUI.getWindowTitle()
    //    System.out.println(title)
    if (WebUI.verifyElementPresent(findTestObject('Loop/Heading Object'), 0)) {
		String Heading = WebUI.getText(getElement('css', '#plhcontent_0_PanelsRepeater_PanelsChipPanel_0_headTitleH1_0'))		
		
		
		if(Heading.length() == 0){
			System.out.println('Heading present but no text in heading element');
		}else{
			System.out.println("Heading Found Successfully")
			System.out.println(Heading)
		}
		
		
    } else {
		System.out.println(WebUI.getUrl());
        System.out.println('Failed Heading is not Present')
    }
    

//    WebUI.verifyMatch(Heading, Heading, false, FailureHandling.CONTINUE_ON_FAILURE) //String Heading = WebUI.getText(getElement("css", "#plhcontent_0_PanelsRepeater_PanelsChipPanel_0_headTitleH1_0"));
} //
//System.out.println(Heading)



TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

