package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author renil
 */
public class CreatePage {
    protected AndroidDriver d;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/memecreate__activity__image")
    RemoteWebElement imageView;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/create_caption")
    RemoteWebElement textMeme;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/done_caption")
    RemoteWebElement done;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/action_save")
    RemoteWebElement save;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"yes\")")
    RemoteWebElement yesButton;
    
    @FindBy(id = "android:id/alertTitle")
    RemoteWebElement alert;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/fab")
    RemoteWebElement edit;
    
    public CreatePage(AndroidDriver d) {
        this.d = d;
        PageFactory.initElements(new AppiumFieldDecorator(d, 15, TimeUnit.SECONDS), this);
    }
    
    public void selectImageView(){
    	imageView.click();
    }
    
    public void writeTextMeme(String arg){
    	textMeme.sendKeys(arg);
    }
    
    public void selectDone(){
    	done.click();
    }
    
    public void selectSave(){
    	save.click();
    }
    
    public void selectYes(){
    	yesButton.click();
    }
    
    public String textAlert(){
    	return alert.getText();
    }
    
    public EditPage selectEdit(){
    	edit.click();
    	return new EditPage(d);
    }
}
