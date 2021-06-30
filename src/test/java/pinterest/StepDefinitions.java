package pinterest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wdWait = new WebDriverWait(driver,20);

    @Given("I am on the homepage")
    public void iAmOnHomepage() {
        driver.manage().window().maximize();
        driver.get("https://www.pinterest.com/");
    }

    @When("I click on the Log in button")
    public void iClickOnLogInButton() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("RCK")));
        WebElement loginBtn = driver.findElement(By.className("RCK"));
        loginBtn.click();
    }

    @And("I enter {string} in the Email field")
    public void iEnterInEmailField(String email) {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
    }

    @And("I enter {string} in the Password field")
    public void iEnterInPasswordField(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @And("I click on Log in button")
    public void iClickOnTheLogInButton() {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("SignupButton")));
        WebElement sendMessageBtn = driver.findElement(By.className("SignupButton"));
        sendMessageBtn.click();
    }

    @Then("I should see the {string}")
    public void iShouldSee(String result) throws InterruptedException {
        try {
                String actualURL = driver.getCurrentUrl();
//                System.out.println(actualURL);
//                System.out.println(result);
                Assert.assertEquals(result, actualURL);
        }

        finally {
            driver.close();
            driver.quit();
        }
    }

    @Then("I should see the site name")
    public void iShouldSeeTheTitle() {
        try {
            String siteName = driver.findElement(By.className("lH1")).getText();
//            System.out.println(siteName);

            Assert.assertEquals(siteName, "Pinterest");
        }

        finally {
            driver.close();
            driver.quit();
        }
    }


    @Then("I should see the Pinterest logo in the upper left corner")
    public void iShouldSeeThePhoneNumberInTheUpperLeftCorner() throws InterruptedException {
        try {
            Assert.assertTrue(driver.findElement(By.className("kVc")).isDisplayed());
        }

        finally {
            driver.close();
            driver.quit();
        }
    }
}
