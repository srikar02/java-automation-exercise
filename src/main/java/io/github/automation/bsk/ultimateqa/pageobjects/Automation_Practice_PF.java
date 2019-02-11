package io.github.automation.bsk.ultimateqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Automation_Practice_PF {

    private WebDriver webDriver;


    @FindBy(xpath = "//a[text()='Big page with many elements']")
    private WebElement big_page_with_many_elements_link;

    @FindBy(xpath = "//a[text()='Fake Landing Page']")
    private WebElement fake_Landing_Page_link;

    public Automation_Practice_PF(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver,this);
    }

    public void click_big_page_with_many_elements_link(){
        big_page_with_many_elements_link.click();
    }

    public void click_fake_Landing_Page_link(){
        fake_Landing_Page_link.click();
    }

}
