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


WebUI.openBrowser('https://www.google.com/')
def driver = DriverFactory.getWebDriver()
String baseUrl = "https://www.google.com/"
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())
String Backgroundcolor = "rgba(30, 158, 220, 1)";

//Hover on Travel Planning
WebUI.mouseOver(getElement('xpath', '//*[@id="ctl15_ctl02_rptSuperCategories_hlCategory_3"]'))
Thread.sleep(1000)

WebUI.mouseOver(getElement('css', '#ctl15_ctl02_rptSuperCategories_rptCategories_3_hlItem_2'))
Thread.sleep(500)

WebUI.click(getElement("css","#ctl15_ctl02_rptSuperCategories_rptCategories_3_hlItem_2"))

//String byDefault = WebUI.verifyTextPresent("Travel by Car", false)
//println (byDefault);

WebUI.click(getElement("css","#plhcontent_0_phcolumn1_1_panelContainer > div > div > a:nth-child(3)"))

//String AfterRedirect = WebUI.verifyTextPresent("Travel by Rail", false)
//println (AfterRedirect);


String Colorcode  = driver.findElement(By.xpath('//*[@id="plhcontent_0_phcolumn1_1_panelContainer"]/div/div/a[3]')).getCssValue("background-color");
println (Colorcode) 

if(Colorcode == Backgroundcolor)
{
	println ("Background is changed into Blue")
}
else(Colorcode != Backgroundcolor).call(
	{
		println ("Background is not changed")
	})

TestObject getElement(String selectorType, String locator) {
	TestObject newTestObject = new TestObject('Grid')

	newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

	return newTestObject
}