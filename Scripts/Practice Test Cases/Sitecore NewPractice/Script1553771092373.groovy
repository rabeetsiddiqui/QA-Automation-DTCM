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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.openBrowser('http://arb-enhc-dev-solr-fix/sitecore/login')

def driver = DriverFactory.getWebDriver()

//WebUI.maximizeWindow()
//WebUI.waitForPageLoad(30)
WebUI.sendKeys(getElement('css', '#UserName'), 'rabeet')

WebUI.sendKeys(getElement('css', '#Password'), 'mirum_r')

WebUI.click(getElement('css', '#LogInBtn'))

WebUI.click(getElement('xpath', '/html/body/div[1]/div/section/section/div/div/div[1]/div[2]/div[1]/a[1]'))

WebUI.click(getElement('css', '#Tree_Glyph_C7FB05E4FCD5442AA064AD5437A9A1C8'))

WebUI.click(getElement('css', '#Tree_Glyph_7FF2221ED64845EEBB68843C5FA0F696'))

WebUI.click(getElement('css', '#Tree_Glyph_F246AAC64DAA4676A803CA9BFC8C186F'))

WebUI.click(getElement('css', '#Tree_Glyph_0E5A89A3C5724BA2BA22FCA5720FE7A7'))

WebUI.click(getElement('css', '#Tree_Node_E4589878850B4F11917A09AB40F88E33'))

WebUI.click(getElement('css', '#RibbonE4589878850B4F11917A09AB40F88E33_Nav_PublishStrip'))

WebUI.click(getElement('css', '#C9B8B99F35AE84B29A320DFF191C4E3AB > div.panel > div:nth-child(2) > a:nth-child(1)'))

System.out.println('title 1: ' + WebUI.getWindowTitle())

WebUI.switchToWindowIndex(1)

//sc-progressindicator-inner
WebUI.waitForPageLoad(200)

WebUI.waitForElementNotVisible(getElement('css', '.sc-progressindicator-inner'), 200)

//Thread.sleep(20000)
System.out.println('title 2: ' + WebUI.getWindowTitle( // Dynamically creates test object that WebUI Functions can use to perform operations.
        ))

WebUI.click(findTestObject('null'))

System.out.println('clicked success')


WebUI.click(getElement('css', 'body > div:nth-child(184) > div.scInsertionHandleLeft.scAddToHere'))

//WebUI.click(getElement('css', '#Tabs_tab_9'))
WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

//WebUI.click(getElement('css', '#I51C13F0383644F61B8602EC6CA7439B3 > div'))
WebUI.click(findTestObject('null'))

//WebUI.click(getElement('css', '#OK'))
WebUI.click(findTestObject('null'))

//WebUI.click(findTestObject('null'))
//WebUI.click(findTestObject('null'))
//WebUI.executeJavaScript('document.querySelectorAll(".scContentTreeNodeGlyph")[1].click())',[])
WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null') //WebUI.click(getElement('css', '.scButtonPrimary'))
    )

WebUI.click(findTestObject('null'))

WebUI.executeJavaScript('document.querySelectorAll(\'#commandRow > a:nth-child(16) > span\')[1].click()', [])

WebUI.click(getElement('css', 'body > div:nth-child(2) > a:nth-child(2)'))


WebUI.scrollToElement(findTestObject('null'), 20)

WebUI.selectOptionByValue(findTestObject('null'), '{2FF9DC0D-D429-436E-8AAA-093FB92AB9F7}', false)

WebUI.click(findTestObject('null'))

TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

