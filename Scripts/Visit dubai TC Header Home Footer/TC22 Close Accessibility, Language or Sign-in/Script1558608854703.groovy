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
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.test.GlobalVaribale
import com.kms.katalon.core.util.KeywordUtil

WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = 'https://www.google.com/'
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()

GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())

String backgroundPositionPink = '-5px -31px'
String backgroundPosition ='-5px -5px';

selenium.click('xpath=//*[@id=\'literalAccessibility\']/a')
//WebUI.click(getElement('xpath', '//*[@id=\'literalAccessibility\']/a'))
WebUI.waitForPageLoad(20000)

String Colorcode = driver.findElement(By.xpath('//*[@id="literalAccessibility"]/a')).getCssValue('background-position')

System.out.println(Colorcode)


if (Colorcode == backgroundPositionPink) {
    System.out.println('Font color is pink')
} 
else (Colorcode != backgroundPositionPink)
{ 
     KeywordUtil.markFailed('Symbol / Text is not in Pink when Open')
}

Thread.sleep(1000)
selenium.click('xpath=//*[@id=\'literalAccessibility\']/a')

WebUI.mouseOver(getElement("css", "#ctl16_linkLogo"))
Thread.sleep(1000)
String Colorcode2 = driver.findElement(By.xpath('//*[@id=\'literalAccessibility\']/a')).getCssValue('background-position')

System.out.println(Colorcode2) 
if(Colorcode2 == backgroundPosition)
{
	System.out.println('Font color is Grey')
}
else(Colorcode2 != backgroundPosition){
	KeywordUtil.markFailed('Symbol / Text is not in grey when closed')
}



TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}
WebUI.closeBrowser()
