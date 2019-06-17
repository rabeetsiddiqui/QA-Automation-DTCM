import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/Visit dubai TC Header Home Footer')

suiteProperties.put('name', 'Visit dubai TC Header Home Footer')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\rabeet\\Katalon Studio\\DTCM QA Automation\\Reports\\Visit dubai TC Header Home Footer\\20190617_125345\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Visit dubai TC Header Home Footer', suiteProperties, [new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC01 Land on Visit Dubai Website', 'Test Cases/Visit dubai TC Header Home Footer/TC01 Land on Visit Dubai Website',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC02 Go to Department of Tourism', 'Test Cases/Visit dubai TC Header Home Footer/TC02 Go to Department of Tourism',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC03 Go to Business in Dubai', 'Test Cases/Visit dubai TC Header Home Footer/TC03 Go to Business in Dubai',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC04 Change Accessibility Options', 'Test Cases/Visit dubai TC Header Home Footer/TC04 Change Accessibility Options',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC05 Increase Text Size', 'Test Cases/Visit dubai TC Header Home Footer/TC05 Increase Text Size',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC08 Learn more about accessibility', 'Test Cases/Visit dubai TC Header Home Footer/TC08 Learn more about accessibility',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC09 Read about the accessibility options', 'Test Cases/Visit dubai TC Header Home Footer/TC09 Read about the accessibility options',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC10 Change Language', 'Test Cases/Visit dubai TC Header Home Footer/TC10 Change Language',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC22 Close Accessibility, Language or Sign-in', 'Test Cases/Visit dubai TC Header Home Footer/TC22 Close Accessibility, Language or Sign-in',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC23 Go to Discover', 'Test Cases/Visit dubai TC Header Home Footer/TC23 Go to Discover',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC24 Jump to specific sections from the megamenu', 'Test Cases/Visit dubai TC Header Home Footer/TC24 Jump to specific sections from the megamenu',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC25 Expand hidden content within the megamenu', 'Test Cases/Visit dubai TC Header Home Footer/TC25 Expand hidden content within the megamenu',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC26 Go to Shop, Dine, Relax', 'Test Cases/Visit dubai TC Header Home Footer/TC26 Go to Shop, Dine, Relax',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC27 Go to See, Thrill, Play', 'Test Cases/Visit dubai TC Header Home Footer/TC27 Go to See, Thrill, Play',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC28 Go to Travel Planning', 'Test Cases/Visit dubai TC Header Home Footer/TC28 Go to Travel Planning',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC29 Go to Dubai Calendar', 'Test Cases/Visit dubai TC Header Home Footer/TC29 Go to Dubai Calendar',  null), new TestCaseBinding('Test Cases/Visit dubai TC Header Home Footer/TC30 Go to Trip Planner', 'Test Cases/Visit dubai TC Header Home Footer/TC30 Go to Trip Planner',  null)])
