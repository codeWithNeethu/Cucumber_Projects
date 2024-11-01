package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {


	@Given("user is in login page")
	public void user_is_in_login_page() {
       
      System.out.println("User is in login page");
		

	}

	@When("user enters <username> and <password>")
	public void user_enters_username_and_password() {
		System.out.println("User enters username and pwd");
		
	}

	@And("clicks on Login button")
	public void clicks_on_login_button() {
		System.out.println("uesr clicks login button");
		
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("user is in home page");
		
	}
}
