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


suiteProperties.put('id', 'Test Suites/DTCM QA Automation')

suiteProperties.put('name', 'DTCM QA Automation')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("C:\\Users\\rabeet\\Katalon Studio\\DTCM QA Automation\\Reports\\DTCM QA Automation\\20190510_121847\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/DTCM QA Automation', suiteProperties, [new TestCaseBinding('Test Cases/DTCM/Login and logout/DTCM Invalid Login Scenario', 'Test Cases/DTCM/Login and logout/DTCM Invalid Login Scenario',  null), new TestCaseBinding('Test Cases/DTCM/Language Change/DTCM Language Change Eng-Fr-Eng', 'Test Cases/DTCM/Language Change/DTCM Language Change Eng-Fr-Eng',  null), new TestCaseBinding('Test Cases/DTCM/Language Change/Language Change Az-Fr-Az', 'Test Cases/DTCM/Language Change/Language Change Az-Fr-Az',  null), new TestCaseBinding('Test Cases/DTCM/Forget Password/Forget Login Info', 'Test Cases/DTCM/Forget Password/Forget Login Info',  null), new TestCaseBinding('Test Cases/DTCM/Login and logout/DTCM Invalid Login Scenario', 'Test Cases/DTCM/Login and logout/DTCM Invalid Login Scenario',  null), new TestCaseBinding('Test Cases/DTCM/Login and logout/LoginFormValidation', 'Test Cases/DTCM/Login and logout/LoginFormValidation',  null), new TestCaseBinding('Test Cases/DTCM/SignUp/Create Account', 'Test Cases/DTCM/SignUp/Create Account',  null)])
