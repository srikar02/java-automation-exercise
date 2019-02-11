package io.github.automation.bsk.letskodeit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Practice_Page_POM {

    private static WebElement element = null;

    private static WebElement hide_textbox_button(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id='hide-textbox']"));
        return element;
    }

    private static WebElement show_textbox_button(WebDriver driver){
        element = driver.findElement(By.xpath("//input[@id='show-textbox']"));
        return element;
    }

    //Actions
    public static void click_hide_textbox_button(WebDriver driver){
        hide_textbox_button(driver).click();
        PageFactory pageFactory = new PageFactory();

    }

    public static void click_show_textbox_button(WebDriver driver){
        show_textbox_button(driver).click();
    }
}
