/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Andressa
 */
public class CreatePage extends BasePage {
    
    @FindBy(id = "io.github.gsantner.memetastic:id/action_save")
    RemoteWebElement savememe;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"YES\")")
    RemoteWebElement yesButton;
    
    @FindBy(id = "android:id/alertTitle")
    RemoteWebElement alert;
    
    
    public CreatePage(AndroidDriver d) {
        super(d);
    }
    
    public void saveMeme(){
        savememe.click();
    }
    
    public void confirmSave(){
        yesButton.click();
    }
    
    public String memeSaved(){ 
       return alert.getText();
    }
            
    
    
    
    
    
}
