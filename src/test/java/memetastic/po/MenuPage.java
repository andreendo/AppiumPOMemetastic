package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andreendo
 */
public class MenuPage extends BasePage {
    
    @FindBy(xpath = "//*[@text='Create']")
    RemoteWebElement createOption;

    @FindBy(xpath = "//*[@text='Favs']")
    RemoteWebElement favsOption;
    
    @FindBy(xpath = "//*[@text='Saved']")
    RemoteWebElement savedOption;
    
    public MenuPage(AndroidDriver d) {
        super(d);
    }
    
    
    public MainPage create() {
        createOption.click();
        return new MainPage(d);
    }

    public FavoritesPage favorites() {
        favsOption.click();
        return new FavoritesPage(d);
    }
    public SavedPage save() {
        savedOption.click();
        return new SavedPage(d);
    }
}
