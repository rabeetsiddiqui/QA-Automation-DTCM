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
import org.openqa.selenium.WebDriver
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory


WebUI.openBrowser('https://twitter.com/login?lang=en')
def driver = DriverFactory.getWebDriver()
driver.manage().window().maximize();
Thread.sleep(1000);
WebUI.setText(findTestObject('Object Repository/Page_Login on Twitter/input_Log in_sessionusername_or_email'), 'rabeet.sijdi')
Thread.sleep(500);
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Login on Twitter/input_Log in_sessionpassword'), 'F5Epga5gQt8bttFOyyZEHg==')
Thread.sleep(500);
WebUI.click(findTestObject('Object Repository/Page_Login on Twitter/button_Log in'))

WebUI.closeBrowser()

