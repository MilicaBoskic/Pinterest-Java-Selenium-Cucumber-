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

//    001
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

//    004
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

//    005
    @Then("I should see the Login button in the upper right corner")
    public void iShouldSeeTheLoginButtonInTheUpperRightCorner() {
        try {
            String loginBtn = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div[1]/div[2]/div[2]/button/div")).getText();
//            System.out.println(loginBtn);
            Assert.assertEquals(loginBtn, "Log in");
        }
        finally {
            driver.close();
            driver.quit();
        }
    }

//    006
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

//    007
    @Then("I should see the text in the center of the page")
    public void iShouldSeeTheTextInTheCenterOfThePage() {
        try {
            String text = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]")).getText();
//            System.out.println(text);
            Assert.assertEquals(text, "Get your next");
        }
        finally {
            driver.close();
            driver.quit();
        }
    }

//    008
    @Then("I should see the all elements")
    public void iShouldSeeTheAllElements() {
        try {
            wdWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div[2]/a/div/div/span")));
            String homeBtn = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div[2]/a/div/div/span")).getText();
//            System.out.println(homeBtn);
            Assert.assertEquals(homeBtn, "Home");

            Assert.assertTrue(driver.findElement(By.id("searchBoxContainer")).isDisplayed());
        }
        finally {
            driver.close();
            driver.quit();
        }
    }
}
