package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;


public class ViewImageSavedPage extends BasePage {
 
    @FindBy(id = "io.github.gsantner.memetastic:id/action_delete")
    private RemoteWebElement deleteButton;
    
    public ViewImageSavedPage(AndroidDriver d) {
        super(d);
    }
    
    public AndroidDriver delete(){
        deleteButton.click();
        return d;
    }
}
