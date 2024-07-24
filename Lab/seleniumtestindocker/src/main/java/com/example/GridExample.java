package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class GridExample {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            // Define Chrome options
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--ignore-ssl-errors=yes");
            options.addArguments("--ignore-certificate-errors");

            // Replace "localhost" with the actual address of your Selenium Grid hub
            URL hubUrl = new URL("http://localhost:4444/wd/hub");

            // Create a RemoteWebDriver instance pointing to the hub
            driver = new RemoteWebDriver(hubUrl, options);

            // Maximize the window size
            driver.manage().window().maximize();
            Thread.sleep(10000); // Just for demonstration

            // Navigate to browserstack.com
            driver.get("https://www.browserstack.com/");
            Thread.sleep(10000); // Just for demonstration

            // Click on the "Get started for free" button
            driver.findElement(By.linkText("Get started free")).click();
            Thread.sleep(10000); // Just for demonstration
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }

        // Ensure the JVM exits properly
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutdown hook ran!");
        }));
    }
}
