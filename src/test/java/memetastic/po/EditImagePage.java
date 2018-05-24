package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

public class EditImagePage extends BasePage {

    @FindBy(id = "io.github.gsantner.memetastic:id/memecreate__activity__image")
    RemoteWebElement image;

    @FindBy(id = "io.github.gsantner.memetastic:id/create_caption")
    RemoteWebElement caption;

    @FindBy(id = "io.github.gsantner.memetastic:id/done_caption")
    RemoteWebElement okButton;

    @FindBy(id = "io.github.gsantner.memetastic:id/action_save")
    RemoteWebElement saveButton;
    
    @FindBy(id = "android:id/alertTitle")
    RemoteWebElement alerta;

    public EditImagePage(AndroidDriver d) {
        super(d);
    }

    public void selectToAddText() {
        image.click();
    }

    public void insertText() {
        caption.sendKeys("meu meme");
        okButton.click();
    }

    public void saveMeme() {
        saveButton.click();
    }
    
    public String getAlert(){
        return alerta.getText();
    }
}
