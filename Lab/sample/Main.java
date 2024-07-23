import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Main {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the system property for the ChromeDriver location
        // This is required to let Selenium know where the ChromeDriver executable is located
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\selenium-java-4.23.0\\chromedriver-win64\\chromedriver.exe");
        
        // Initialize the ChromeDriver, which will open a new Chrome browser instance
        driver = new ChromeDriver();
    }

    @Test
    public void testIncrementButton() throws InterruptedException {
        // Load the local HTML file in the Chrome browser
        // The file path should point to the location of your HTML file on your system
        driver.get("file:///C:/Users/sample/counter.html"); // Replace with the correct path to your HTML file

        // Locate the button element with the id "increment-button" and click it
        // This simulates a user clicking the button in the browser
        driver.findElement(By.id("increment-button")).click();

        // Locate the element with the id "output" and get its text content
        // This is used to verify if the button click incremented the value correctly
        String result = driver.findElement(By.id("output")).getText();

        // Assert that the text content of the output element is "1"
        // If the value is not "1", an assertion error will be thrown with the specified message
        assert result.equals("1") : "Expected output to be 1, but got " + result;

        // Add a delay of 5 seconds (5000 milliseconds) before closing the browser
        // This allows you to see the browser and verify the result manually
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        // Close the browser and end the WebDriver session
        // This ensures that the browser is closed properly after the test is completed
        driver.quit();
    }
}
