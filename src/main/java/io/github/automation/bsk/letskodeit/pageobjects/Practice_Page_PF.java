package io.github.automation.bsk.letskodeit.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Practice_Page_PF {

    WebDriver webDriver;

    @FindBy(xpath = "//input[@id='hide-textbox']")
    WebElement hide_textbox_button;

    @FindBy(xpath = "//input[@id='show-textbox']")
    WebElement show_textbox_button;

    public Practice_Page_PF(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public void click_hide_textbox_button(){
        hide_textbox_button.click();
    }

    public void click_show_textbox_button(){
        show_textbox_button.click();
    }
}
