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
import internal.GlobalVariable as GlobalVariable
// Custom added imports
import com.thoughtworks.selenium.Selenium as Selenium
import org.openqa.selenium.firefox.FirefoxDriver as FirefoxDriver
import org.openqa.selenium.WebDriver as WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium as WebDriverBackedSelenium
import static org.junit.Assert.*
import java.util.regex.Pattern as Pattern
import static org.apache.commons.lang3.StringUtils.join
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.openBrowser('http://arbksa.mirummea.com/en')

def driver = DriverFactory.getWebDriver()

String baseUrl = 'https://www.google.com/'

selenium = new WebDriverBackedSelenium(driver, baseUrl)

driver.manage().window().maximize()

//
//WebUI.sendKeys(getElement('css', '#UserName'), 'rabeet')
//
//WebUI.sendKeys(getElement('css', '#Password'), 'mirum_r')
WebUI.executeJavaScript('document.querySelectorAll(\'.pws-enhancements .main-header .top-nav-container .top-nav-inner .m-m-menu a\')[36].click()', 
    [])

Thread.sleep(500)

WebUI.executeJavaScript('document.querySelectorAll(\'.pws-enhancements .short-tabs li a\')[2].click();', [])

Thread.sleep(500)

WebUI.executeJavaScript('document.querySelectorAll(\'.radio-inline\')[0].click();', [])

Thread.sleep(500)

WebUI.executeJavaScript('document.querySelectorAll(\'.radio-inline\')[3\t].click();', [])

Thread.sleep(500)

WebUI.selectOptionByValue(findTestObject('CalculatorSelect'), 'Private-A', false)

Thread.sleep(500)

WebUI.sendKeys(getElement('css', '#txt-monthly-salary'), '5600')

Thread.sleep(500)

//WebUI.focus(getElement('css', '#txt-current-monthly-instal'))
WebUI.click(getElement('css', '#txt-current-monthly-instal'));
WebUI.sendKeys(getElement('css', '#txt-current-monthly-instal'), '1200')

//selenium.type("id=txt-current-monthly-instal", "1200")
//WebUI.click(getElement('css', '.form-control text-box single-line ')."1200")
//WebUI.sendKeys(getElement('css', '#id=txt-current-monthly-instal'), '1200')
Thread.sleep(500)


WebUI.click(getElement('css', '#MonthlyInstallment'))
Thread.sleep(500)
WebUI.click(getElement("css", "#btn-pf-calculate"))
//WebUI.click(getElement("css", "#btn-pf-calculate"));


//selenium.click('//*[@id="btn-pf-calculate"]')
//WebUI.executeJavaScript('document.getElementById(\'btn-pf-calculate\').click();', [])




TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

