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
import org.openqa.selenium.interactions.Action as Action
import org.openqa.selenium.interactions.Actions as Actions
import org.openqa.selenium.Keys as Keys
import com.test.GlobalVaribale


WebUI.openBrowser('https://www.google.com/')

def driver = DriverFactory.getWebDriver()

String baseUrl = 'https://www.google.com/'

selenium = new WebDriverBackedSelenium(driver, baseUrl)

driver.manage().window().maximize()

GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())
selenium.click('xpath=//*[@id="searchIcon"]')

selenium.type('xpath=//*[@id=\'search\']', 'dubai')

WebUI.mouseOver(getElement('xpath', '//*[@id="htmlBody"]/div[5]/div[1]'))
Thread.sleep(500);

WebUI.click(getElement('xpath', '//*[@id="htmlBody"]/div[5]/div[1]'))

WebUI.click(getElement('xpath', '//*[@id=\'searchIcon\']'))

WebUI.sendKeys(getElement('xpath', '//*[@id=\'search\']'), 'Abu')

WebUI.sendKeys(getElement('xpath', '//*[@id=\'search\']'), Keys.chord(Keys.ENTER))


TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}
