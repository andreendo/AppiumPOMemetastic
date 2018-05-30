package memetastic.po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

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
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"io.github.gsantner.memetastic:id/search_button\")")
    RemoteWebElement search;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"io.github.gsantner.memetastic:id/search_src_text\")")
    RemoteWebElement textSearch;
    
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"io.github.gsantner.memetastic:id/item__square_image__image\")")
    RemoteWebElement imagem;
    
    @FindBy(id = "io.github.gsantner.memetastic:id/item__square_image__image_bottom_end")
    RemoteWebElement starButton;
    
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

    public MenuPage openMenu() {
        menu.click();
        return new MenuPage(d);
    }
    
    public void selectSearchButton(){
    	search.click();
    }
    
    public void writeTextSearch(String arg){
    	textSearch.sendKeys(arg);
    }
    
    public CreatePage selectImagem(){
    	imagem.click();
    	return new CreatePage(d);
    }
    
    public void selectStarButton(){
    	starButton.click();
    }
    
}
