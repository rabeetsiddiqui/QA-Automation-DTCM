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
import com.test.GlobalVaribale as GlobalVaribale

WebUI.openBrowser('https://www.google.com/')

def driver = DriverFactory.getWebDriver()
String baseUrl = 'https://www.google.com/'
selenium = new WebDriverBackedSelenium(driver, baseUrl)
driver.manage().window().maximize()
GlobalVaribale gv = new GlobalVaribale()
selenium.open(gv.getWebsitename())
String AfterClick = "rgba(255, 255, 255, 1)";


WebUI.click(getElement('css', '.homepage_section .mobile_nav .main-nav .nav-section > li:nth-child(2)'))
WebUI.waitForPageLoad(20000)
String Colorcode  = driver.findElement(By.cssSelector('.homepage_section .mobile_nav .main-nav .nav-section > li:nth-child(2) > a')).getCssValue("color");
System.out.println(Colorcode)
if (Colorcode == 'rgba(194, 44, 145, 1)') {
    System.out.println('Font color is Pink')
} 
else {
    Colorcode != 'rgba(194, 44, 145, 1)'.call({ 
            System.out.println('Font color is not changed')
        })
}
WebUI.scrollToElement(getElement('css', '.container.mobile-full-width .row .col-sm-12 .icon-list > ul > li:nth-child(2)'), 10)
String DefaultContent = WebUI.getText(getElement('css', '.max-container.vdf-col-1 .ng-scope:nth-child(1) > div:nth-child(1) > div:nth-child(1) .tab-content-pod .exclude-external .vd-article-title.ng-binding'))
println (DefaultContent);

WebUI.mouseOver(getElement('css', '.ng-scope .container .row:nth-child(1) .icon-tabs.new-tab-icons.halign-center.col-sm-12 .tabular-tab.col-sm-3.col-md-3.col-lg-3:nth-child(3)'));
Thread.sleep(500)

WebUI.click(getElement('css', '.ng-scope .container .row:nth-child(1) .icon-tabs.new-tab-icons.halign-center.col-sm-12 .tabular-tab.col-sm-3.col-md-3.col-lg-3:nth-child(3)'))

String Colorcode1 = driver.findElement(By.cssSelector('.ng-scope .container .row:nth-child(1) .icon-tabs.new-tab-icons.halign-center.col-sm-12 .tabular-tab.col-sm-3.col-md-3.col-lg-3.active')).getCssValue('color')
println (Colorcode1);
Thread.sleep(500)
if(Colorcode1 == AfterClick)
{
	System.out.println('Font color is Converted into Blue')
}
else {Colorcode1 != AfterClick.call({
			System.out.println('Font color is not changed')
		})
}
Thread.sleep(500)
String Newtext = WebUI.getText(getElement('css', '.max-container.vdf-col-1 .ng-scope:nth-child(1) > div:nth-child(1) > div:nth-child(1) .tab-content-pod .exclude-external .vd-article-title.ng-binding'))
println (Newtext);
if(DefaultContent != Newtext)
{
	System.out.println('Successfully tab Changed ')
}
else {DefaultContent == Newtext.call({
			System.out.println('Failed Tab is not changed')
		})
}
Thread.sleep(500)
TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

