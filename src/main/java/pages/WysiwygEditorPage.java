package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WysiwygEditorPage extends HomePage {
    private WebDriver driver;
//  private String editorIframeId = "mce_0_ifr";
//    private By textArea = By.id("tinymce");
//    private By increaseIndentButton = By.xpath("//button[@title='Increase indent']");


    @FindBy(id = "mce_0_ifr")
    WebElement iFrame;

    @FindBy(id="tinymce")
    WebElement textAreaElement;

    @FindBy(xpath = "//button[@title='Increase indent']")
    WebElement increaseIndentButtonElement;


    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clearTextArea(){
        switchToEditArea();
        textAreaElement.clear();
        switchToMainArea();
    }

    public void setTextArea(String text){
        switchToEditArea();
        textAreaElement.sendKeys(text);
        switchToMainArea();
    }

    public void increaseIndentation(){
        increaseIndentButtonElement.click();
    }

    public String getTextFromEditor(){
        switchToEditArea();
        textAreaElement.getText();
        String text = textAreaElement.getText();
        switchToMainArea();
        return text;
    }
    private void switchToEditArea(){
        driver.switchTo().frame(iFrame);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }
}
