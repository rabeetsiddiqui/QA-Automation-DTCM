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


suiteProperties.put('id', 'Test Suites/Visit Dubai TC Travel Planning')

suiteProperties.put('name', 'Visit Dubai TC Travel Planning')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\rabeet\\git\\QA-Automation-DTCM\\Reports\\Visit Dubai TC Travel Planning\\20190731_172101\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/Visit Dubai TC Travel Planning', suiteProperties, [new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC01 Explore Travel Planning', 'Test Cases/Visit Dubai TC Travel Planning/TC01 Explore Travel Planning',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC02 View Visa Information', 'Test Cases/Visit Dubai TC Travel Planning/TC02 View Visa Information',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC03 View interactive map of Dubai', 'Test Cases/Visit Dubai TC Travel Planning/TC03 View interactive map of Dubai',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC04 View guide details', 'Test Cases/Visit Dubai TC Travel Planning/TC04 View guide details',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC05 Go to Travel Tools', 'Test Cases/Visit Dubai TC Travel Planning/TC05 Go to Travel Tools',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC06 Go to Walking in Dubai', 'Test Cases/Visit Dubai TC Travel Planning/TC06 Go to Walking in Dubai',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC07 Go to Getting Around Dubai', 'Test Cases/Visit Dubai TC Travel Planning/TC07 Go to Getting Around Dubai',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC08 Change mode of transportation', 'Test Cases/Visit Dubai TC Travel Planning/TC08 Change mode of transportation',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC09 Go to Getting to Dubai', 'Test Cases/Visit Dubai TC Travel Planning/TC09 Go to Getting to Dubai',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC10 Go to Cruise in Dubai', 'Test Cases/Visit Dubai TC Travel Planning/TC10 Go to Cruise in Dubai',  null), new TestCaseBinding('Test Cases/Visit Dubai TC Travel Planning/TC11 Go to Itineraries', 'Test Cases/Visit Dubai TC Travel Planning/TC11 Go to Itineraries',  null)])
