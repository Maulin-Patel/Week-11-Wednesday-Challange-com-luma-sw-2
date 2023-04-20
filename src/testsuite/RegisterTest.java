package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Random;

public class RegisterTest extends BaseTest {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSignInPageDisplay() {
        driver.findElement(By.xpath("//a[text()=\"Create an Account\"]")).click(); // Finding Create an account link and clicking on it
        String expectedText = "Create New Customer Account"; // Expected text from requirement
        String actualText = driver.findElement(By.xpath("//span[contains(text(),'Create New Customer Account')]")).getText();// Finding text element and getting text value
        Assert.assertEquals("Sign in page was not displayed", expectedText, actualText); // Validating expected and actual text
    }

    public static String getRandomEmail() { // Method generating Random email everytime
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder random = new StringBuilder();
        Random rnd = new Random();
        while (random.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            random.append(chars.charAt(index));
        }
        String email = random.toString() + "@gmail.com";
        return email;
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        driver.findElement(By.xpath("//a[text()='Create an Account']")).click(); // Finding Create an account link and clicking on it
        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Maulin");// Finding First name field and passing value
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Patel");// Finding last name field and passing value
        driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();// Finding sign up for newsletter check box and selecting it
        driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(getRandomEmail());// Finding email field and passing value
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abcd1234");// Finding password field and sending value
        driver.findElement(By.xpath("//input[@id='password-confirmation']")).sendKeys("Abcd1234");// Finding confirm password field and sending value
        driver.findElement(By.xpath("//div[@class='primary']")).click();//Finding create and account button and clicking on it
        String expectedMessage = "Thank you for registering with Main Website Store.";// Expected message from requirement
        String actualMessage = driver.findElement(By.xpath("//div[contains(text(),'Thank you for registering with Main Website Store.')]")).getText(); // Finding text element and getting text value
        Assert.assertEquals("User was unable to register successfully", expectedMessage, actualMessage);// Validating expected and actual message
        driver.findElement(By.xpath("//button[@class='action switch']")).click();// Finding drop down arrow icon next to username and clicking on it
        driver.findElement(By.xpath("//li[@class='authorization-link']")).click();// Finding and clicking on Sign out option
        String expectedMessage1 = "You are signed out";// Expected message from requirements
        String actualMessage1 = driver.findElement(By.xpath("//span[contains(text(),'You are signed out')]")).getText();// Finding text element and getting text value
        Assert.assertEquals("User was unable to sign out.", expectedMessage1, actualMessage1);// Validating expected and actual message

    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}
