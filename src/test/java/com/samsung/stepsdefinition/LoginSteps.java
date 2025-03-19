package com.samsung.stepsdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {
    WebDriver driver;

    @Before
    public void SetupDriver() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @After
    public void AfteTest(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screnshotByte = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screnshotByte, "image/png", "screenshot");
        }
        this.driver.quit();
    }

    @Given("The login page should be showed in user screen")
    public void the_login_page_should_be_showed_in_user_screen() {
        this.driver.get("https://fado.vn/dang-nhap");
    }
    @When("The user leave all field are blank then click Login")
    public void the_user_leave_all_field_are_blank_then_click_login() throws InterruptedException {
        WebElement tbUsername = driver.findElement(By.id("auth-block__form-group__email"));
        WebElement tbPassword = driver.findElement(By.cssSelector("input[data-test-login-password]"));

        tbUsername.clear();
        tbPassword.clear();

        WebElement btnLogin = driver.findElement(By.cssSelector("button[data-test-login-btn-submit]"));
        btnLogin.click();

        Thread.sleep(2000);
    }
    @Then("The message {string} will be showed below username and password")
    public void the_message_will_be_showed_below_username_and_password(String string) {
        WebElement lbUserNameError = driver.findElement(By.id("auth-block__form-group__email-error"));
        WebElement lbPasswordError = driver.findElement(By.id("password-error"));

        assertThat(lbUserNameError.getText(), equalTo(string));
        assertThat(lbPasswordError.getText(), equalTo(string));
    }

    @When("The user attempt to sign in with {string} and password {string}")
    public void the_user_attempt_to_sign_in_with_and_password(String username, String password) throws InterruptedException {
        WebElement tbUsername = driver.findElement(By.id("auth-block__form-group__email"));
        WebElement tbPassword = driver.findElement(By.cssSelector("input[data-test-login-password]"));

        tbUsername.sendKeys(username);
        tbPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.cssSelector("button[data-test-login-btn-submit]"));
        btnLogin.click();

        Thread.sleep(2000);
    }
    @Then("The message {string} will be showed")
    public void the_message_will_be_showed(String string) throws InterruptedException {
        Thread.sleep(2000);

        WebElement tbError = driver.findElement(By.cssSelector(".my-alert.-alert-danger"));
        assertThat(tbError.getText(), equalTo(string));
    }

    @Then("The Dashboard page will be showed")
    public void the_dashboard_page_will_be_showed() {

    }
}
