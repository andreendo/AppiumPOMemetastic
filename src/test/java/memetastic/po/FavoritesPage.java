package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
/**
 *
 * @author andreendo
 */
public class FavoritesPage extends BasePage {
    
    @FindBy(className = "android.widget.TextView")
    RemoteWebElement title;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/main__activity__list_empty__text")
    RemoteWebElement msg;
    
    
    public FavoritesPage(AndroidDriver d) {
        super(d);
    }
    
    public String getTitle() {
        return title.getText();
    }
    
    public String msgVazio(){
        return  msg.getText();
    }
}
