
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\selenium-java-4.23.0\\chromedriver-win64\\chromedriver.exe");
        
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Open a webpage
        driver.get("https://www.google.com");
        
        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Close the browser
        driver.quit();
    }
}
