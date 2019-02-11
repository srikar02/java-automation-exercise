package io.github.automation.bsk.ultimateqa.tests;

import io.github.automation.bsk.ultimateqa.pageobjects.Automation_Practice_PF;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Automation_Practice_Tests {

    private WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {

        Properties properties = new Properties();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("endpoints.properties");

        properties.load(resourceAsStream);
        System.setProperty("webdriver.chrome.driver","src/test/resources/browsers/chromedriver.exe");

        driver = new ChromeDriver();
        String baseURL = properties.getProperty("ultimateqa.url");

        driver.get(baseURL);
        driver.manage().window().fullscreen();
    }

    @Test
    public void first_test(){

        Automation_Practice_PF automation_practice_pf = new Automation_Practice_PF(driver);

        automation_practice_pf.click_big_page_with_many_elements_link();

    }



}
