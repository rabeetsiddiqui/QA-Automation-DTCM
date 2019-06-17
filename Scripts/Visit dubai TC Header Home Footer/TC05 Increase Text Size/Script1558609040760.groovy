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
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import java.lang.Integer as Integer
import java.lang.Float as Float

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl('https://www.visitdubai.com/en')

String currentFontSize = WebUI.getCSSValue(getElement('css', 'body'), 'font-size')

println('Current font size: ' + currentFontSize)

WebUI.click(getElement('css', '#literalAccessibility'))

Thread.sleep(1000)

WebUI.click(getElement('css', '.signup_nav .accessibility-section .accessibility-wrap .accessibility-category .font-selector > li:nth-child(5)'))

println('Checking max font size')

String maxFontSize = WebUI.getCSSValue(getElement('css', 'body'), 'font-size')

println('Maximum font size: ' + maxFontSize)

if (getFloat(currentFontSize)  < getFloat(maxFontSize)) {
    println('New fontsize is greater then ' + currentFontSize)
}
else {
	println('Font size did not increase')
	WebUI.callTestCase(findTestCase('1'), [:], FailureHandling.STOP_ON_FAILURE)
}
Thread.sleep(1000)

WebUI.click(getElement('css', '.signup_nav .accessibility-section .accessibility-wrap .accessibility-category .font-selector > li:nth-child(1)'))

println('Checking min font size')

String minFontSize = WebUI.getCSSValue(getElement('css', 'body'), 'font-size')

println('Minimum font size: ' + minFontSize)


if (getFloat(currentFontSize)  > getFloat(minFontSize)) {
    println('New fontsize is less then ' + currentFontSize)
} 
else {
	println('Font size did not decrease')
	WebUI.callTestCase(findTestCase('1'), [:], FailureHandling.STOP_ON_FAILURE)
}
Thread.sleep(1000)

Float getFloat(String inputStr){
	return Float.parseFloat(inputStr.substring(0, inputStr.indexOf('px')))
}


TestObject getElement(String selectorType, String locator) {
    TestObject newTestObject = new TestObject('Grid')

    newTestObject.addProperty(selectorType, ConditionType.EQUALS, locator)

    return newTestObject
}

