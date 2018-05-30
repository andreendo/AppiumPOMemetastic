package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author andreendo
 */
public class EditPage {
    protected AndroidDriver d;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/fab")
    RemoteWebElement sizeBar;
    
    public EditPage(AndroidDriver d) {
        this.d = d;
        PageFactory.initElements(new AppiumFieldDecorator(d, 15, TimeUnit.SECONDS), this);
    }
    
    public void setSizeBar(){
    	sizeBar.click();
    }
}
