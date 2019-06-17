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
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.openBrowser('https://www.google.com/')

def driver = DriverFactory.getWebDriver()

String baseUrl = 'https://www.google.com/'

selenium = new WebDriverBackedSelenium(driver, baseUrl)

driver.manage().window().maximize()

GlobalVaribale gv = new GlobalVaribale()

selenium.open(gv.getWebsitename() + '/en/shop-dine-relax/shopping')

WebUI.waitForPageLoad(2000)

//after landing on shopping page Closing Newsletter Component to scroll
WebUI.click(getElement('css', '#bussiness-newslettermodal > div.modal-header > button'))

WebUI.scrollToElement(getElement('css', '#flights > div.booking_controls_wrap.active.in > div.booking_dates > label:nth-child(1) > div'), 
    10)

String DefaultUrl = WebUI.getUrl()

println(DefaultUrl)

//click/GetText on Articles
String Default = WebUI.getText(getElement('css', '#Articles_categoryDataRoot > li:nth-child(1) > div > a > h4'))

println(Default)

Thread.sleep(1500)

//Click on Experiences
WebUI.click(getElement('css', '#dsf_shop_sub_cat_filters > dl > dd > div > a:nth-child(3)'))

Thread.sleep(500)

String New = WebUI.getText(getElement('css', '#POIS_categoryDataRoot > li:nth-child(1) > div > a:nth-child(2) > h4'))

println(New)

if (Default != New) {
    println('Success')
} else {
    Default == New.call({ 
            println('Failed')
        })
}

//Click on Experience to land on detail page
WebUI.click(getElement('css', '#POIS_categoryDataRoot > li:nth-child(2) > div > a.select_deal'))

WebUI.click(getElement('css', '#POIS_categoryDataRoot > li:nth-child(1) > div > a.select_deal'))

//JavascriptExecutor js = ((driver) as JavascriptExecutor)
//js.executeScript('document.querySelectorAll(\'.dd-options\')[0].classList.add(\'language-selector-list\')')
//int TagsLength = driver.findElements(By.cssSelector('.tp_badge')).size()
//int TagsLength = WebUI.getText(getElement('css', '#tripPlannerIcon > span.trip_count.tp_badge'))
String TagsLength = WebUI.getText(getElement('css','#tripPlannerIcon > span.trip_count.tp_badge'))

//System.out.println(TagsLength) //
//for(int i =1 ; i <= TagsLength ; i++)
//{
//	selenium.click('css=.search-filter-dsf .filters a' + ':nth-child(' + i + ')')
//}

System.out.println(TagsLength)

TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

