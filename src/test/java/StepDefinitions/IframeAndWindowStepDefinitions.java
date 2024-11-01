package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.Assert;

import java.util.Set;

public class IframeAndWindowStepDefinitions {

    WebDriver driver;

    @Given("I navigate to the iframe page")
    public void i_navigate_to_the_iframe_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @When("I switch to the iframe")
    public void i_switch_to_the_iframe() {
        WebElement iframeElement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframeElement);
    }

    @Then("I can see {string} inside the iframe")
    public void i_can_see_inside_the_iframe(String expectedText) {
        WebElement body = driver.findElement(By.id("tinymce"));
        String actualText = body.getText();
        Assert.assertEquals(expectedText, actualText);
        driver.switchTo().defaultContent();
        driver.quit();
    }

    @Given("I navigate to the multiple windows page")
    public void i_navigate_to_the_multiple_windows_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    @When("I click on {string} link")
    public void i_click_on_link(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("I switch to the new window")
    public void i_switch_to_the_new_window() {
        String originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    @Then("I verify the text {string} in the new window")
    public void i_verify_the_text_in_the_new_window(String expectedText) {
        WebElement body = driver.findElement(By.tagName("h3"));
        String actualText = body.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @Then("I close the new window and return to the original window")
    public void i_close_the_new_window_and_return_to_the_original_window() {
        String originalWindow = driver.getWindowHandles().iterator().next();
        driver.close();
        driver.switchTo().window(originalWindow);
        driver.quit();
    }
}
