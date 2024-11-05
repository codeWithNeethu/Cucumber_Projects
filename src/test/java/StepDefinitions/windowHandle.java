package StepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;

public class windowHandle {

    WebDriver driver;

    @Given("I navigate to the main page")
    public void i_navigate_to_the_main_page() {
        // Initialize driver without redeclaration
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.salesforce.com/au/");
        
        // Accept cookies
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        
        
    }

    @When("I click on {string} button")
    public void i_click_on_button(String button) {
    	// Click the "Start Trial" button (assuming that’s the CTA button)
        driver.findElement(By.xpath("//a[@class='cta_button']")).click();
        
    }

    @When("I navigated to another window")
    public void i_navigated_to_another_window() {
        // Ensure driver is initialized
        if (driver == null) {
            throw new NullPointerException("WebDriver is not initialized.");
        }

        // Get window handles and switch to the new window
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        
        if (iterator.hasNext()) {
            String mainpage = iterator.next();
            if (iterator.hasNext()) {
                String childpage = iterator.next();
                driver.switchTo().window(childpage); // Switch to the child window
            }
        }
    }

    @Then("I can enter {string} and {string}")
    public void i_can_enter_first_name_and_last_name(String firstname, String lastname) {
    	// Ensure driver is initialized
        if (driver == null) {
            throw new NullPointerException("WebDriver is not initialized.");
        }

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 

    /*
        //explicit wait
       // Create a wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds max

        // Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("UserFirstName")));
        
      */
        
        
    	driver.findElement(By.name("UserFirstName")).sendKeys(firstname);
        driver.findElement(By.name("UserLastName")).sendKeys(lastname);
    }

    @Then("navigate back to main page")
    public void navigate_back_to_main_page() {
        // Switch back to the main page (first window handle)
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();

        if (iterator.hasNext()) {
            String mainpage = iterator.next();
            driver.switchTo().window(mainpage); // Switch back to the main window
        }
    }
}
