package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features", glue= {"StepDefinitions"},
//to get a formatted information in console
monochrome =true
//for generating reports like html, json, xml
//plugin = {"pretty", "junit:target/JUnitReports/report.xml",
//		"json:target/JSONReports/report.json",
//		"html:target/HtmlReports"},

//plugin ={"pretty", "html:target/HTMLReports/report.html",
//                   "json:target/JSONReports/report.json",
//                    "junit:target/JUNITReports/report.xml"}

//   
//     plugin={"pretty", "html:target/reports"}
//     plugin={"pretty", "json:target/reports/cucumber.json"}
//     plugin={"pretty", "junit:target/reports/cucumber.xml"}
//    
		)



//tags="@SmokeTest")
public class TestRunner {



}
