package io.github.automation.bsk.letskodeit.tests;

import io.github.automation.bsk.letskodeit.pageobjects.Practice_Page_PF;
import io.github.automation.bsk.letskodeit.pageobjects.Practice_Page_POM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Practice_Page_Tests {

    private WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {

        //ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Properties properties = new Properties();
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("endpoints.properties");

        properties.load(resourceAsStream);
        System.setProperty("webdriver.chrome.driver","src/test/resources/browsers/chromedriver.exe");

        driver = new ChromeDriver();
        String baseURL = properties.getProperty("letskodeit.url");

        driver.get(baseURL);
        driver.manage().window().fullscreen();
    }

    @Test
    public void test_POM_page() {

        Practice_Page_POM.click_hide_textbox_button(driver);

        //Practice_Page_POM.click_show_textbox_button(driver);

    }

    @Test
    public void test_PF_page() {

        Practice_Page_PF practice_page_pf = new Practice_Page_PF(driver);

        practice_page_pf.click_hide_textbox_button();

        //Practice_Page_POM.click_show_textbox_button(driver);

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
