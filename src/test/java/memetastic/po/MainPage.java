package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author andreendo
 */
public class MainPage extends BasePage {
     @FindBy(id = "Open navigation drawer")
    RemoteWebElement menu;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Human\")")
    RemoteWebElement humanTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Animals\")")
    RemoteWebElement animalsTab;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Cartoon\")")
    RemoteWebElement cartoonTab; 
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Rage\")")
    RemoteWebElement rageTab;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Other\")")
    RemoteWebElement otherTab;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/item__square_image__image")
    RemoteWebElement image;
    
    
    public MainPage(AndroidDriver d) {
        super(d);
    }

    public void selectTabHumans() {
        humanTab.click();
    }

    public void selectTabAnimals() {
        animalsTab.click();
    }

    public void selectTabCartoon() {
        cartoonTab.click();
    }
    
    public void selectTabRage() {
        rageTab.click();
    }
    
    public void selectTabOther() {
        otherTab.click();
    }
    public CreatePage selectImage(){
        image.click();
        return new CreatePage(d);
    }

    public MenuPage openMenu() {
        menu.click();
        return new MenuPage(d);
    }
    
}
